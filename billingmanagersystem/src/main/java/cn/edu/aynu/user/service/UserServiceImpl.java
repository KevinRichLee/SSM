package cn.edu.aynu.user.service;

import cn.edu.aynu.user.dao.UserDao;
import cn.edu.aynu.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/14
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUpdateId(Integer id) {
        return userDao.getUpdateId(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }
}
