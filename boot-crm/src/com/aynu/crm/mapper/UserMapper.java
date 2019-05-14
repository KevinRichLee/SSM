package com.aynu.crm.mapper;

import com.aynu.crm.pojo.Users;

public interface UserMapper {

	void insertUser(Users users);

	String selectUserByName(String userState);

	Users selectUser(Users userName);

	void updateUserPwd(Users user);

	
}
