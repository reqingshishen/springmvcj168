package com.lovo.springmvc.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity  //标注此类是一个实体，hibernate会来管理
@Table(name="sys_user")//映射表，默认表名是类名
public class UserEntity {
	//Id必须要有
	@Id
	@Column(name="u_id",length=32)//注解数据表列的属性
	//自定义UUID生成策略
	@GenericGenerator(name="useruuid",strategy="uuid")
	//ID的生成策略
	@GeneratedValue(generator="useruuid")
	private String userId;
	@Column(length=48,name="u_name")
	private String userName;
	@Column(length=48,name="u_pass")
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

}
