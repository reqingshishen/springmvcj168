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
}
