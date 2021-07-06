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
	
	@Column(name="emp_photo")
	private String photo;
	
	@Column(name="emp_bank_name")
	private String bank_name;
	
	@Column(name="emp_account_number")
	private Integer account_number;
	

	public UpdateUser() {
	}

	public UpdateUser(String password, String address, String phone, String birth, String photo, String bank_name, Integer account_number) {
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
		this.photo = photo;

		this.bank_name=bank_name;
		this.account_number =account_number;
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

	public void setAccount_number(Integer account_number) {
		this.account_number = account_number;
	}

	

}