package com.lovo.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.springmvc.dao.IUserDao;
import com.lovo.springmvc.entitiy.UserEntity;
import com.lovo.springmvc.service.IUserService;
@Service(value="userService")
public class UserServiceImpl implements IUserService {
    @Autowired
	private IUserDao userDao;

	public void SavaUser(UserEntity user) {
		
		userDao.save(user);
	}

}
