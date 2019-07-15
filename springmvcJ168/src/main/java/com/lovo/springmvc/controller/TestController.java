package com.lovo.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.springmvc.entitiy.UserEntity;

@Controller
public class TestController {

	@RequestMapping("test.lovo")
	public ModelAndView test(String message) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("info","hello word");
		System.out.println("后台"+message);
		return mv;
	}
	
	@RequestMapping("test2.lovo")
	public ModelAndView test2(String message,HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
	   String message2=	req.getParameter("message");
		mv.addObject("info","hello word");
		System.out.println("后台"+message);
		return mv;
	}
	@RequestMapping("savaUser.lovo")
	public ModelAndView savaUser(String userName,String password,UserEntity user) {
		ModelAndView mv=new ModelAndView();
		System.out.println(userName+"/"+password+"/"+user.getUserName());
		mv.setViewName("index.jsp");
		return mv;
		
	}
}
