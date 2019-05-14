package com.aynu.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aynu.crm.mapper.UserMapper;
import com.aynu.crm.pojo.Users;
import com.aynu.crm.service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(Users users) {

		userMapper.insertUser(users);
	}

	@Override
	public String queryUserByName(String userState) {
		return userMapper.selectUserByName(userState);
	}

	@Override
	public Users queryUser(Users users) {
		return userMapper.selectUser(users);
	}

	@Override
	public void modifyUserPwd(Users user) {
		userMapper.updateUserPwd(user);
		
	}

}
