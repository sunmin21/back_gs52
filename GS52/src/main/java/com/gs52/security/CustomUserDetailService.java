package com.gs52.security;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gs52.dao.emp.empDAO;
import com.gs52.vo.emp.EmpVO;



@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	empDAO eDAO = null;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//username을 이용하여 mapper에서 원하는 값을 받아옴.
		EmpVO user =eDAO.selectUser(username);
		String password= user.getEMP_PWD();
		String[] userRoles = {user.getAdmin()};
		Collection<GrantedAuthority> roles = AuthorityUtils.createAuthorityList(userRoles);
		return new User(username,password,roles);
	}

}
