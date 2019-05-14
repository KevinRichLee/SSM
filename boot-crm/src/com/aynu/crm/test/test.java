package com.aynu.crm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aynu.crm.pojo.Users;
import com.aynu.crm.service.UserService;
import com.aynu.crm.service.impl.UserServiceImpl;

public class test {

	public static void main(String[] args) {
		/*
		 * 有一筐鸡蛋，筐里最多放5000个蛋。 1个1个拿拿完。 
		 * 2个2个拿剩1个。 3个3个拿拿完。 4个4个拿剩一个。 5个5个拿剩2个。
		 * 6个6个拿剩3个。 7个拿7个拿拿完。 8和8个拿剩一个。
		 *  9个9个拿拿完,问应该放多少鸡蛋在筐里合适？
		 */
		// int e = ?
		for (int i = 1; i < 5001; i++) {
			if(i % 1 == 0 && i % 2 == 1 && i % 3 == 0 
					&& i % 4 == 1 &&i % 5 == 2 &&i % 6 == 3 &&i % 7 == 0 &&
					i % 8 == 1 &&i % 9 == 0 ){
				System.out.println(i);
			}
		}
	}
	@Test
	public void fun1() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		UserService service = (UserService) app.getBean("userservice");
		Users users = new Users();
		users.setUserName("kevinlee");
		users.setUserPassword("123456");
		Users user = service.queryUser(users);
		System.out.println(user);
		
	}

}
