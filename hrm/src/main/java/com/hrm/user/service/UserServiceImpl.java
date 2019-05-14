package com.hrm.user.service;

import com.hrm.user.beans.User;
import com.hrm.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User loginByUser(User user) {

        return userDao.loginByUser(user);
    }

    @Override
    public List<User> selectAll(Map map) {
        return userDao.selectUser(map);
    }

    @Override
    public void addUser(User user) {
         userDao.addUser(user);
    }

    @Override
    public String  selectloginname(String loginname) {
        return userDao.selectloginname(loginname);
    }

    @Override
    public void deleteUser(int[] id) {
        userDao.deleteUser(id);
    }

    @Override
    public Integer selectTotal(User user) {
        return userDao.selectTotal(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.modifyUser(user);
    }


}
