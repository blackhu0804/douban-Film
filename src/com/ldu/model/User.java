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
	
	//@Transient ��ʾ͸�����ԣ���д�����ݿ� 
	//@Temporal(TemporalType.DATE); ��Ӧ�������͵����ݿ�����
	@Id		//˵������id
	//@GeneratedValue	//��д����native
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//�Զ�������������ʽidentity
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
