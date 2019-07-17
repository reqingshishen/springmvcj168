package com.lovo.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.springmvc.dao.IUserDao;
import com.lovo.springmvc.dao.IUserQueryDao;
import com.lovo.springmvc.entitiy.UserEntity;
import com.lovo.springmvc.service.IUserService;
import com.lovo.springmvc.util.StringUtil;
@Service(value="userService")
public class UserServiceImpl implements IUserService {
    @Autowired
	private IUserDao userDao;
    @Autowired
    private IUserQueryDao userQueryDao;
	public void SavaUser(UserEntity user) {
		
		userDao.save(user);
	}

	@Override
	public List<UserEntity> findListUser() {

		return (List<UserEntity>) userDao.findAll();
	}

	@Override
	public List<UserEntity> getUserList(String userName, String password) {

		return userQueryDao.getUserList(userName, password);
	}

	@Override
	public List<UserEntity> getUserListHQL(String userName, String password) {
		String hql="from UserEntity where 1=1 ";
		String[] params= null;//条件数组
		if(StringUtil.blString(userName)&&!StringUtil.blString(password)) {
			//用户为空，密码不为空
			hql+=" and password=?";
			params= new String[1];
			params[0]=password;
		}else if(!StringUtil.blString(userName)&&StringUtil.blString(password)) {
			//用户不为空，密码为空
			hql+=" and userName=?";
			params= new String[1];
			params[0]=userName;
		}else if(!StringUtil.blString(userName)&&!StringUtil.blString(password)) {
			//用户名和密码都不为空
			hql+=" and userName=? and password=?";
			params= new String[2];
			params[0]=userName;
			params[1]=password;
		}
		
		
		
		return userQueryDao.getUserList(hql, params);
	}

}
