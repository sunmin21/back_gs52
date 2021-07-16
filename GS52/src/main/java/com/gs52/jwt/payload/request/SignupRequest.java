package com.gs52.jwt.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {  // 회원가입 시 웹페이지에서 입력한 Request 내용임
    @NotBlank
    //@Size(min = 3, max = 50)
    @Size(max = 20)
    private String id;
    
    
    @NotBlank
    //@Size(max = 20)
    @Size(min = 3, max = 50)
    private String username;
    
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    

	private Long rank;
    
	private Long team;

	private Long position;

	private Long first_login;
	
	private String entry_date;
	
	private Long vacation;
	
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.id = username;
    }
 
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.username = id;
	}

	public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public Long getTeam() {
		return team;
	}

	public void setTeam(Long team) {
		this.team = team;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getFirst_login() {
		return first_login;
	}

	public void setFirst_login(Long first_login) {
		this.first_login = first_login;
	}

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public Long getVacation() {
		return vacation;
	}

	public void setVacation(Long vacation) {
		this.vacation = vacation;
	}
    
	
}
