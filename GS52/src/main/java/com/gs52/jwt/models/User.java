package com.gs52.jwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(	name = "emp")

@SequenceGenerator(
      name="USER_SEQ_GEN", //시퀀스 제너레이터 이름
     sequenceName="emp_seq", //시퀀스 이름
     // sequenceName="seq_users",
      initialValue=1, //시작값
      allocationSize=1 //메모리를 통해 할당할 범위 사이즈, 50~100
)

public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO, generator="USER_SEQ_GEN")
	 @Column(name="emp_index")
	 private Long index;

	 //사원번호(아이디)
	@NotBlank   // "", " "
	@Size(max = 20)
	 @Column(name="emp_name")
	private String id;

	@NotBlank   // "", " "
	@Size(max = 50)
	 @Column(name="emp_id")
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	 @Column(name="emp_email")
	private String email;

	@NotBlank
	@Size(max = 150)
	@Column(name="emp_pwd")
	private String password;
	
	@Column(name="emp_rank_index")
	private Long rank;
	
	@Column(name="emp_position_index")
	private Long position;


	@Column(name="emp_team_index")
	private Long team;
	 
	@Column(name="emp_first_login")
	private Long first_login;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "emp_index"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@Column(name="emp_address")
	private String address;
	@Column(name="emp_phone")
	private String phone;
	@Column(name="emp_birth")
	private String birth;
	@Column(name="emp_entry_date")
	private String entry_date;
	@Column(name="emp_vacation")
	private long vacation;
	
	
	

	public User() {
	}

	public User(String id, String username, String email, String password, Long position, Long rank, Long team, Long first_login, long vacation, String emp_entry_date) {
		System.out.println("id");
		System.out.println(id);
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;

		this.rank = rank;
		this.position=position;
		this.team =team;
		this.first_login=first_login;
		this.vacation=vacation;
		this.entry_date=emp_entry_date;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public Long getFirst_login() {
		return first_login;
	}

	public void setFirst_login(Long first_login) {
		this.first_login = first_login;
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

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public long getVacation() {
		return vacation;
	}

	public void setVacation(long vacation) {
		this.vacation = vacation;
	}
	
	
}
