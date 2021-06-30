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
      sequenceName="SEQ_user", //시퀀스 이름
      initialValue=1, //시작값
      allocationSize=1 //메모리를 통해 할당할 범위 사이즈, 50~100
)

public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GEN")
	 @Column(name="emp_index")
	 private Long id;

	@NotBlank   // "", " "
	@Size(max = 20)
	 @Column(name="emp_id")
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	 @Column(name="emp_email")
	private String email;

	@NotBlank
	@Size(max = 120)
	@Column(name="emp_pwd")
	private String password;
	
	 @Column(name="emp_rank_index")
	private Long rank;
	 
	 @Column(name="emp_position_index")
	private Long position;
	
	 @Column(name="emp_team_index")
	private Long team;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "emp_index"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password, Long position, Long rank, Long team) {
		this.username = username;
		this.email = email;
		this.password = password;

		this.rank = rank;
		this.position=position;
		this.team =team;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	
}

//@Entity
//@Table(	name = "users", 
//		uniqueConstraints = { 
//			@UniqueConstraint(columnNames = "username"),
//			@UniqueConstraint(columnNames = "email") 
//		})
//public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@NotBlank
//	@Size(max = 20)
//	private String username;
//
//	@NotBlank
//	@Size(max = 50)
//	@Email
//	private String email;
//
//	@NotBlank
//	@Size(max = 120)
//	private String password;
//
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(	name = "user_roles", 
//				joinColumns = @JoinColumn(name = "user_id"), 
//				inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles = new HashSet<>();
//
//	public User() {
//	}
//
//	public User(String username, String email, String password) {
//		this.username = username;
//		this.email = email;
//		this.password = password;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
//}


////////////////////////////////////////////////////////////////////////
//@Entity
//@Table( name = "users",
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "username"),
//                @UniqueConstraint(columnNames = "email")
//        })
//
//@SequenceGenerator(
//        name="USER_SEQ_GEN", //시퀀스 제너레이터 이름
//        sequenceName="SEQ_user", //시퀀스 이름
//        initialValue=1, //시작값
//        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
//)
//
//public class User {
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GEN")
//    private Long id;
//
//    private String user
 

 

