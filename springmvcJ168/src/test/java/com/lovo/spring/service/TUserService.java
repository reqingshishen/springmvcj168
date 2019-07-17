package com.lovo.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lovo.springmvc.entitiy.UserEntity;
import com.lovo.springmvc.service.IUserService;

public class TUserService {

	ClassPathXmlApplicationContext app=null;
	IUserService s=null;
	@Before
	public void before() {
		app=new ClassPathXmlApplicationContext("applicationJPA.xml");
	   s=(IUserService) app.getBean("userService");
	}
	
	@Test
	public void savaUser() {
		UserEntity user=new UserEntity();//瞬时状态
	 
	   	
		s.savaUser(user);
	}
	
	@Test
	public void testListUser() {
		List<UserEntity> list=	s.getUserListHQL("", "123");
		System.out.println(list.size());
	}
	@Test
	public void testLogin() {
	UserEntity user=	s.findByUserNameAndPassword("赵云","123");
	System.out.println(user.getUserName());
	}
}
