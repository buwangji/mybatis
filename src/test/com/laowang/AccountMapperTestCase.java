package com.laowang;

import com.laowang.mapper.AccountMapper;
import com.laowang.pojo.Account;
import com.laowang.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */
public class AccountMapperTestCase {
    @Test
    public void save(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = accountMapper.findAll();

        for(Account account : accounts) {
            System.out.println(account.getName());
        }

       /* Account account = new Account();
        account.setName("二货航");
        account.setAddress("焦作");
        accountMapper.save(account);

        sqlSession.commit();*/
        sqlSession.close();
    }
    @Test
    public void findById(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
       Account account = accountMapper.findById(2);
       Account account1 = accountMapper.findById(2);
        System.out.println(account.getName());
        System.out.println(account1.getName());
        sqlSession.close();
    }

    @Test
    public void findByPage() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();

        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = accountMapper.findByPage(0,1);
        for(Account account : accounts) {
            System.out.println(account.getName());
        }

        sqlSession.close();

    }


}
