package com.gs52.jwt.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gs52.jwt.models.ERole;
import com.gs52.jwt.models.Role;



@Repository
@Qualifier("role")
public interface RoleRepository extends JpaRepository<Role, Long> {  // JPA에서 사용할 Role Repository임
	Optional<Role> findByName(ERole name);
}
