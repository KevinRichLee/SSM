package com.aynu.crm.service;

import com.aynu.crm.pojo.Users;

public interface UserService {

	void addUser(Users users);

	String queryUserByName(String userState);

	Users queryUser(Users users);

	void modifyUserPwd(Users user);

	
}
