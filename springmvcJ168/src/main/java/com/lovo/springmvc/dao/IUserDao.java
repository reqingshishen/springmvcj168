package com.lovo.springmvc.dao;

import org.springframework.data.repository.CrudRepository;

import com.lovo.springmvc.entitiy.UserEntity;

public interface IUserDao extends CrudRepository<UserEntity,String>{

}
