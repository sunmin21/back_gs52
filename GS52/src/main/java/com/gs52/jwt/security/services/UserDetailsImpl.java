package com.gs52.jwt.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gs52.jwt.models.User;

// 로그인 정보 객체로, 사용자 이름을 가지고 실제 등록된 사용자인지를 확인한 후 로그인 정보를 객체로 생성함
// 실제 인증 작업을 수행해서 이상유무를 판단 후, 이상이 없으면 Authentication을 생성함(setAuthentication)
public class UserDetailsImpl implements UserDetails {  // UserDetails - Security 내장 객체임
	private static final long serialVersionUID = 1L;

	private Long index;

	private String username;
	
	private String id;

	private String email;

	@JsonIgnore
	private String password;
	

	private Long rank;
	private Long position;
	private Long team;
	
	private long first_login;
	private long vacation;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long index, String username, String id, String email, String password, long first_login, long rank, long position, long team, long vacation,
			Collection<? extends GrantedAuthority> authorities) {
		this.index = index;
		this.username = username;
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;    // 
		this.first_login = first_login;
		this.rank = rank;
		this.position = position;
		this.team = team;
		this.vacation = vacation;
		
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getIndex(), 
				user.getUsername(), 
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				user.getFirst_login(), 
				user.getRank(), 
				user.getPosition(), 
				user.getTeam(), 
				user.getVacation(),
//				user.getAddress(),
//				user.getPhone(),
//				user.getBirth(),
//				user.getPhoto(),
//				user.getEntry_date(),
//				user.getBank_name(),
//				user.getAccount_number(),
//				user.get
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getIndex() {
		return index;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getFirst_login() {
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

	
	public long getVacation() {
		return vacation;
	}

	public void setVacation(long vacation) {
		this.vacation = vacation;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(index, user.index);
	}
}
