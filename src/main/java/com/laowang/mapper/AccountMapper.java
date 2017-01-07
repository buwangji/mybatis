package com.laowang.mapper;

import com.laowang.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */
public interface AccountMapper {

    @Insert("insert into account (name,address) values(#{name},#{address})")
    void save(Account account);

    @Select("select * from account where id = #{id}")
    @Options(useCache = false)
    Account findById(Integer id);

    @Select("select * from account")
    List<Account> findAll();

    @Select("select * from account limit ${start},${size}")
    List<Account> findByPage(@Param("start") int start,
                             @Param("size") int size);



}
