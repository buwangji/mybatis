package com.laowang;

import com.laowang.pojo.UserMapper;
import com.laowang.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/1/4.
 */
public class MyBatisTestCase {
    @Test
    public void readXml(){
        try {
            //1.读取classpath中的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //2.构建SqlSessionFactory对象
            SqlSessionFactory sessionFactory =
                    new SqlSessionFactoryBuilder().build(reader);
            //3.创建Sqlsession对象
            SqlSession sqlSession = sessionFactory.openSession();

            //查询单个对象
            UserMapper userMapper = sqlSession.selectOne("com.laowang.mapper.UserMapper.findById",3);
            System.out.println(userMapper);

            //4.释放资源
            sqlSession.close();
        }catch (IOException e){
            throw new RuntimeException("读取mybatis.xml文件异常",e);
        }

    }
    @Test
    public  void  save(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = new UserMapper();
        userMapper.setName("asa");
        userMapper.setTel("1234567890");
        sqlSession.insert("com.laowang.mapper.UserMapper.save",userMapper);
        sqlSession.close();
    }
    @Test
    public void update(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.selectOne("com.laowang.mapper.UserMapper.findById",3);
        userMapper.setName("航航");
        sqlSession.update("com.laowang.mapper.UserMapper.update",userMapper);
        sqlSession.close();
    }

    @Test
    public void del(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        sqlSession.delete("com.laowang.mapper.UserMapper.del",4);
        sqlSession.close();
    }
}
