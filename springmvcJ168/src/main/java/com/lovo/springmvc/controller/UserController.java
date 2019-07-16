package com.lovo.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.springmvc.entitiy.UserEntity;
import com.lovo.springmvc.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private IUserService userService ;
	
	@RequestMapping("/savaUser.lovo")
	public ModelAndView savaUser(UserEntity user) {
		ModelAndView mv=new ModelAndView();
		userService.SavaUser(user);
		mv.setViewName("/index.jsp");
		return mv;
		
	}
}
