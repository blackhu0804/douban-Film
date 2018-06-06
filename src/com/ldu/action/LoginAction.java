package com.ldu.action;

import com.ldu.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	User user; /* model类 */
	private String result; 
	
	

	public String execute() {
		System.out.println("过来登录了！");
		System.out.println("用户名："+user.getUsername());
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
