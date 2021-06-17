package com.example.ecom.bean;

import javax.validation.constraints.Size;

public class Login {
	@Size(min=5,max = 15)
	private String loginId;
	private String password;
	@Size(min=8,max = 30)
	public Login() {
	}
	
	public Login(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String userId) {
		this.loginId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
