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
@Table(	name = "rank"
)


public class Rank {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="rank_index")
	 private Long rank_index;

	@NotBlank   // "", " "
	@Size(max = 20)
	@Column(name="rank_name")
	private String rank_name;


	public Rank() {
	}

	public Rank(long rank_index, String rank_name) {
		System.out.println(rank_index);
		System.out.println(rank_name);
		this.rank_index = rank_index;
		this.rank_name = rank_name;
	}


	public Long getRank_index() {
		return rank_index;
	}

	public void setRank_index(Long rank_index) {
		this.rank_index = rank_index;
	}

	public String getRank_name() {
		System.out.println("Rank");
		return rank_name;
	}

	public void setRank_name(String rank_name) {
		this.rank_name = rank_name;
	}

}

 

