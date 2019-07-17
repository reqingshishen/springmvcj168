package com.lovo.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lovo.springmvc.entitiy.UserEntity;
import com.lovo.springmvc.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private IUserService userService ;
	
	@RequestMapping("/savaUser.lovo")
	public ModelAndView savaUser(UserEntity user,HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		userService.savaUser(user);
	   //保存成功代表登录，把用户放入到session
		 req.getSession().setAttribute("userObj",user);
		
		
		//重定向到查询
	   RedirectView rv=new RedirectView();
	   rv.setUrl("findUserList.lovo");
	  //把重定向视图放入到模型视图
	   mv.setView(rv);
		return mv;
		
	}
	
	@RequestMapping("/savaUser2.lovo")
	public String savaUser2(UserEntity user) {

		userService.savaUser(user);
		return "redirect:findUserList.lovo";
		
	}
	
	
	@RequestMapping("/savaUserString.lovo")
	public String savaUserString(UserEntity user,HttpServletRequest request) {
		
		userService.savaUser(user);
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
	
	@RequestMapping("/findUserList.lovo")
	public ModelAndView findUserList(String userName,String password) {
		
		ModelAndView mv=new ModelAndView("show");
		//查询所有用户
		List<UserEntity>  list=	userService.getUserList(userName, password);
		//把数据放入模型
		mv.addObject("listUser", list);
		return mv;
	}
	
	//登录
	@RequestMapping("/loginUser.lovo")
  public ModelAndView loginUser(String userName,String password,HttpServletRequest req) {
	  ModelAndView mv=new ModelAndView("show");
	UserEntity user=  userService.findByUserNameAndPassword(userName, password);
	  //如果登录成功就放入到session，否则就回到登录页面
	if(null!=user) {
		req.getSession().setAttribute("userObj", user);
		//重定向到查询
		   RedirectView rv=new RedirectView();
		   rv.setUrl("findUserList.lovo");
		  //把重定向视图放入到模型视图
		   mv.setView(rv);
	}else {
		 mv.setViewName("login");
	}
	  
	  
	
		return mv;
  }	
	
}
