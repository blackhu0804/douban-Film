package com.ldu.action;

import com.ldu.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	User user; /* model�� */
	private String result; 
	
	

	public String execute() {
		System.out.println("������¼�ˣ�");
		System.out.println("�û�����"+user.getUsername());
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
			result = "{\"login\":\"success\"}";
		}
		else{
			result = "{\"login\":\"false\"}";
		}
		//return message;
		return "success";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
