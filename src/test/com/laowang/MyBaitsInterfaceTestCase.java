package com.laowang;

import com.laowang.mapper.UserMapper;
import com.laowang.pojo.User;
import com.laowang.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2017/1/5.
 */
public class MyBaitsInterfaceTestCase {

    private SqlSession sqlSession;
    private UserMapper userMapper;


    @Before
    public void setup(){
        sqlSession = SqlSessionFactoryUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void close(){
        sqlSession.close();
    }

    @Test
    public void findById(){
        User user = userMapper.findById(3);
        System.out.println(user);
    }

    @Test
    public void save(){
        User user = new User();
        user.setName("二货航");
        user.setTel("250");
        userMapper.save(user);
        System.out.println(user.getId());
        sqlSession.commit();
    }

    @Test
    public void findByNameAndTel(){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name","二货航");
        param.put("tel","250");
        User user = userMapper.findByNameAndTel(param);
        System.out.println(user);
    }
    @Test
    public void findByParam(){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name","逗比航");
        param.put("tel","5428");
        User user = userMapper.findByParam(param);
        System.out.println(user);
    }
    @Test
    public void findByIds(){
        List<User> userList = userMapper.findByIds(Arrays.asList(5,6,7,8,9));
        for (User user :userList){
            System.out.println(user);
        }
    }

    @Test
    public void batchSave(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("逗比航","250"));
        userList.add(new User("二货航","150"));
        userList.add(new User("小阳阳","110"));
        userList.add(new User("大逗比航","250"));
        userMapper.batchSave(userList);
        sqlSession.commit();

    }







}
