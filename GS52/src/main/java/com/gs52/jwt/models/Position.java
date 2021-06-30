package com.gs52.jwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "position"
)


public class Position {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Id
	 @Column(name="position_index")
	 private Long position_index;

	@NotBlank   // "", " "
	@Size(max = 20)
	 @Column(name="position_name")
	private String position_name;


	public Position() {
	}

	public Position(long position_index, String position_name) {
		System.out.println("position");
		System.out.println(position_index);
		System.out.println(position_name);
		this.position_index = position_index;
		this.position_name = position_name;
	}


	public Long getPosition_index() {
		return position_index;
	}

	public void setPosition_index(Long position_index) {
		this.position_index = position_index;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

}

 

