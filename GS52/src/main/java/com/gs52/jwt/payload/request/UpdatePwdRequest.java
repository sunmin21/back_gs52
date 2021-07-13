package com.gs52.jwt.payload.request;

import javax.validation.constraints.NotBlank;

public class UpdatePwdRequest {
	@NotBlank
	private String username;

	@NotBlank
	private String password;
	
	@NotBlank
	private String newPassword;

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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
