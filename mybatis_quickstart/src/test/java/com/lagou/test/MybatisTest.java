package com.lagou.test;

import com.lagou.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    @Test
        public  void mybatisQuickStart() throws IOException {
            //1.加载核心配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            //2.获取工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.获取sqlsession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //4.执行sql
            List<User> users = sqlSession.selectList("userMapper.findAll");
            //5.遍历打印
            for (User user: users) {
                System.out.println(user);
            }
            //6.
            sqlSession.close();

        }

        @Test
        public  void testSave() throws IOException {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            User user = new User();
            user.setUsername("jzo" +
                    "" +
                    "" +
                    "");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("nan");
            sqlSession.insert("userMapper.saveUser",user);
            /*sqlSession.commit();*/
            sqlSession.close();

        }


    @Test
    public  void testUpdate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(3);
        user.setUsername("lucy");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("nan");
        sqlSession.update("userMapper.updateUser",user);
        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public  void delete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userMapper.deleteUser",3);
        sqlSession.commit();
        sqlSession.close();

    }



}
