package com.lovo.springmvc.service;

import java.util.List;

import com.lovo.springmvc.entitiy.UserEntity;

public interface IUserService {
  /**
   * 保存用户
   * @param user
   */
	public void SavaUser(UserEntity user);
	/**
	 * 查询所有
	 * @return
	 */
	public List<UserEntity> findListUser();
	/**
	 * 根据用户名和密码查询
	 * @param userName
	 * @param password
	 * @return
	 */
	public List<UserEntity> getUserList(String userName, String password);
	
	public List<UserEntity> getUserListHQL(String userName, String password);
}
