package com.lovo.springmvc.dao;

import java.util.List;

import com.lovo.springmvc.entitiy.UserEntity;

public interface IUserQueryDao {

	public List<UserEntity> getUserList(String userName,String password);
	/**
	 * 根据条件查询
	 * @param hql 组装好的HQL
	 * @param objs 条件
	 * @return 集合
	 */
	public List<UserEntity> getUserList(String hql, Object[] objs);
}
