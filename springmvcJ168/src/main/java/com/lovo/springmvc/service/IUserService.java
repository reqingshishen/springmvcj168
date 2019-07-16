package com.lovo.springmvc.service;

import com.lovo.springmvc.entitiy.UserEntity;

public interface IUserService {
  /**
   * 保存用户
   * @param user
   */
	public void SavaUser(UserEntity user);
}
