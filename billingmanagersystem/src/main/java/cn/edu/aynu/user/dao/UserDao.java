package cn.edu.aynu.user.dao;

import cn.edu.aynu.user.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/14
 */
@Mapper
public interface UserDao {
    User login(User user);

    List<User> getUser(User user);

    User getUserById(Integer id);

    User getUpdateId(Integer id);

    void update(User user);

    void delete(Integer id);

    void add(User user);
}
