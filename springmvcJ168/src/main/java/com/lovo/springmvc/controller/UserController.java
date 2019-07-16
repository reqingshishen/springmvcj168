package com.lovo.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.springmvc.entitiy.UserEntity;
import com.lovo.springmvc.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private IUserService userService ;
	
	@RequestMapping("/savaUser.lovo")
	public ModelAndView savaUser(UserEntity user) {
		ModelAndView mv=new ModelAndView();
		userService.SavaUser(user);
		mv.addObject("info","保存成功");
		mv.setViewName("index");
		return mv;
		
	}
	
	@RequestMapping("/savaUserString.lovo")
	public String savaUserString(UserEntity user,HttpServletRequest request) {
		
		userService.SavaUser(user);
	    request.setAttribute("info","保存成功");
		return "index";		
	}
	
	@RequestMapping("/savaUserParam.lovo")
	public ModelAndView savaUserParam(@RequestParam("userName")String user,@RequestParam("password")String pass) {
		ModelAndView mv=new ModelAndView();
	    log.info(user+"/"+pass+"/");
		mv.setViewName("index");
		return mv;
		
	}
	@RequestMapping("/getJSON.lovo")
	@ResponseBody//不返回视图只返回数据
	public String getJSON(String str) {
		log.info(str);
		return "{'userName':'zy'}";
	}
	
	@RequestMapping("/getJsonUser.lovo")
	@ResponseBody//不返回视图只返回数据
	public UserEntity getJsonUser(String str) {
		UserEntity user=new UserEntity();
		user.setUserName("赵云");
		user.setPassword("123456");
		return user;
	}
}
