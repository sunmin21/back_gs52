package com.gs52.jwt.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long index;
	private String id;
	private String username;
	private String email;
	private Long first_login;
	private List<String> roles;
	private Long rank;
	private Long position;
	private Long team;
	private Long vacation;

	public JwtResponse(String accessToken, Long index, String id, String username, String email, Long first_login, long rank, long position, long team, Long vacation, List<String> roles) {
		this.token = accessToken;
		this.index=index;
		this.id = id;
		this.username = username;
		this.email = email;
		this.first_login = first_login;
		this.roles = roles;
		this.rank = rank;
		this.position = position;
		this.team = team;
		this.vacation = vacation;
		
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	
	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

	public Long getFirst_login() {
		return first_login;
	}

	
	
	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getTeam() {
		return team;
	}

	public void setTeam(Long team) {
		this.team = team;
	}

	public void setFirst_login(Long first_login) {
		this.first_login = first_login;
	}

	
	public Long getVacation() {
		return vacation;
	}

	public void setVacation(Long vacation) {
		this.vacation = vacation;
	}

	public List<String> getRoles() {
		return roles;
	}
}
