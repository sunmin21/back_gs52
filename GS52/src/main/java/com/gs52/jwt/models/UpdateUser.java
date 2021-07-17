package com.gs52.jwt.models;

import javax.persistence.*;


@Entity
@Table(	name = "emp")

public class UpdateUser {
	 @Id
	 //@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_SEQ_GEN")
	 @Column(name="emp_index")
	 private Long index;
	 
	@Column(name="emp_pwd")
	private String password;

	@Column(name="emp_address")
	private String address;
	
	@Column(name="emp_phone")
	private String phone;
	
	@Column(name="emp_birth")
	private String birth;
	

	public UpdateUser() {
	}

	public UpdateUser(String password, String address, String phone, String birth) {
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}


}
