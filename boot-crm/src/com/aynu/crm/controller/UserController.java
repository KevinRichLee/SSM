package com.aynu.crm.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aynu.crm.pojo.Users;
import com.aynu.crm.service.UserService;

@Controller
@RequestMapping("Users")
public class UserController {

	@Autowired
	private UserService userService;  
	
	@RequestMapping("/register.action")
	public String register(Users users,Model model) {
		users.setUserState("1");
	    model.addAttribute("users", users);
		userService.addUser(users);
		return "/registerSuccess.jsp";
	}
	
	@RequestMapping("/check.action")
	@ResponseBody
	public String check(String userName) {
		System.out.println(userName);
		String data = userService.queryUserByName(userName);
		System.out.println(data);
		return data;
	}
	
	@RequestMapping("/login.action")
	public String login(Users users,HttpSession session) {
		System.out.println(users);
		Users user = userService.queryUser(users);
		System.out.println(user);
		if(user==null) {
			session.setAttribute("error","您输入的用户名或密码错误,请重新输入");
			
			return "/index.jsp";
		}else {
			session.setAttribute("user",user);
			return "/customer/list.action";
		}
	}
	@RequestMapping("loginOut.action")
	public String loginOut(HttpSession session) {
		session.removeAttribute("user");
		return "/index.jsp";
	}
	@RequestMapping("modify.action")
	public String ModifyUserPwd(Users user) {
		userService.modifyUserPwd(user);
		return "/modifySuccess.jsp";
	}
}
