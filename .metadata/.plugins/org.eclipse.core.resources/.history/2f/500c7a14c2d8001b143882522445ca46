package com.gs52.jwt.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@SequenceGenerator(
        name="roles_SEQ_GEN", 
        sequenceName="SEQ_roles", 
        initialValue=1, 
        allocationSize=1 
)
public class Role {
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roles_SEQ_GEN")
	 private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}




//@Entity
//@Table(name = "roles")
//public class Role {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//
//	@Enumerated(EnumType.STRING)
//	@Column(length = 20)
//	private ERole name;
//
//	public Role() {
//
//	}
//
//	public Role(ERole name) {
//		this.name = name;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public ERole getName() {
//		return name;
//	}
//
//	public void setName(ERole name) {
//		this.name = name;
//	}
//}