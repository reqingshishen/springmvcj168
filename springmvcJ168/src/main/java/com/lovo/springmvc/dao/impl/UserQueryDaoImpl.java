package com.lovo.springmvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import com.lovo.springmvc.dao.IUserQueryDao;
import com.lovo.springmvc.entitiy.UserEntity;
import com.lovo.springmvc.util.StringUtil;
@Repository(value="userQueryDao")
public class UserQueryDaoImpl implements IUserQueryDao {

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	//获得entityManager
	public EntityManager getEntityManager() {
		return entityManagerFactory.getObject().createEntityManager();
	}
	
	public List<UserEntity> getUserList(String userName, String password) {
		String hql="from UserEntity where 1=1 ";
		if(StringUtil.blString(userName)&&!StringUtil.blString(password)) {
			//用户为空，密码不为空
			hql+=" and password=:password";
			
		}else if(!StringUtil.blString(userName)&&StringUtil.blString(password)) {
			//用户不为空，密码为空
			hql+=" and userName=:userName";
		
		}else if(!StringUtil.blString(userName)&&!StringUtil.blString(password)) {
			//用户名和密码都不为空
			hql+=" and userName=:userName and password=:password";
			
		}
		Query query=	getEntityManager().createQuery(hql);
		
		if(StringUtil.blString(userName)&&!StringUtil.blString(password)) {
			//用户为空，密码不为空
			
			query.setParameter("password", password);
		}else if(!StringUtil.blString(userName)&&StringUtil.blString(password)) {
			//用户不为空，密码为空
		
			query.setParameter("userName", userName);
		}else if(!StringUtil.blString(userName)&&!StringUtil.blString(password)) {
			//用户名和密码都不为空			
			query.setParameter("userName", userName);
			query.setParameter("password", password);
		}
		
		return query.getResultList();
	}

	@Override
	public List<UserEntity> getUserList(String hql, Object[] objs) {
		
		
		Query query=	getEntityManager().createQuery(hql);
		//把条件放入到HQL
		if(null!=objs) {
		for(int i=0;i<objs.length;i++) {
			query.setParameter(i, objs[i]);
		}
		}
		return query.getResultList();
	}

}
