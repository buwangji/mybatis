package com.laowang.mapper;

import com.laowang.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/5.
 */
public interface UserMapper {
    User findById(Integer id);
    void save(User user);
    User findByNameAndTel(Map<String,Object> param);
    User findByParam(Map<String,Object> param);
    List<User> findByIds(List<Integer> idList);
    void batchSave(List<User> userList);

}
