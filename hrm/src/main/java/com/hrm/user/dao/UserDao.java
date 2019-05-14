package com.hrm.user.dao;

import com.hrm.user.beans.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

     User loginByUser(User user);

    List<User> selectUser(Map map);

    void addUser(User user);

    String selectloginname(String loginname);

    void deleteUser(int[] id);

    Integer selectTotal(User user);

    User selectUserById(Integer id);

    void modifyUser(User user);
}
