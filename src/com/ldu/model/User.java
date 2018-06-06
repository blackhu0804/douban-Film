package com.ldu.model;

import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")

public class User {
	
	private int id;
	private String username;
	private String password;
	
	//@Transient 表示透明属性，不写入数据库 
	//@Temporal(TemporalType.DATE); 对应各种类型的数据库数据
	@Id		//说明这是id
	//@GeneratedValue	//不写就是native
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//自动递增，递增方式identity
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
