package com.gs52.jwt.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gs52.jwt.models.User;

@Qualifier("user")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findById(String id);

	Boolean existsById(String id);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
