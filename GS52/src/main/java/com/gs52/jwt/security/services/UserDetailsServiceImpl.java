package com.gs52.jwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gs52.jwt.models.User;
import com.gs52.jwt.repository.UserRepository;

@Service("UserDetailService")                                                     // UserDetailsService - 내장 객체로부터 상속받은 UserDetailsServiceImpl 사용자 객체임
public class UserDetailsServiceImpl implements UserDetailsService {
	@Qualifier("user")
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}
