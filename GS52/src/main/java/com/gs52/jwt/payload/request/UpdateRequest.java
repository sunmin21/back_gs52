package com.gs52.jwt.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class UpdateRequest {  // 회원가입 시 웹페이지에서 입력한 Request 내용임
    private String id;
	
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
	private String address;

	private String phone;

	private String bitrh;
	private String photo;
	private String bank_name;
	private long account_number;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBitrh() {
		return bitrh;
	}

	public void setBitrh(String bitrh) {
		this.bitrh = bitrh;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	
	
  
    
}
