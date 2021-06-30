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
@Table(	name = "team"
)


public class Team {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="team_index")
	 private Long team_index;

	@NotBlank   // "", " "
	@Size(max = 20)
	 @Column(name="team_name")
	private String team_name;


	public Team() {
	}

	public Team(long team_index, String team_name) {
		System.out.println("team");
		System.out.println(team_index);
		System.out.println(team_name);
		this.team_index = team_index;
		this.team_name = team_name;
	}


	public Long getTeam_index() {
		return team_index;
	}

	public void setTeam_index(Long team_index) {
		this.team_index = team_index;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

}

 

