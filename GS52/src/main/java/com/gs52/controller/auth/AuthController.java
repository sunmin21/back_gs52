package com.gs52.controller.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.emp.empDAO;
import com.gs52.jwt.models.ERole;
import com.gs52.jwt.models.Role;
import com.gs52.jwt.models.User;
import com.gs52.jwt.payload.request.LoginRequest;
import com.gs52.jwt.payload.request.SignupRequest;
import com.gs52.jwt.payload.request.UpdatePwdRequest;
import com.gs52.jwt.payload.request.UpdateRequest;
import com.gs52.jwt.payload.response.JwtResponse;
import com.gs52.jwt.payload.response.MessageResponse;
import com.gs52.jwt.repository.RoleRepository;
import com.gs52.jwt.repository.UserRepository;
import com.gs52.jwt.security.jwt.JwtUtils;
import com.gs52.jwt.security.services.UserDetailsImpl;
import com.gs52.vo.schedule.ProjectVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired(required=true)	
	private AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
    
	@Autowired
	empDAO eDAO;
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println("#####signin#####");
				// authenticataionManager.authenticate() 메소드로 검사하며 Security 내장 기능으로 수행함
		Authentication authentication = authenticationManager.authenticate(
				// UserDetailsService를 호출하는 것은 AuthTokenFilter와 동일하다 볼 수 있으며, 비밀번호 검사를 하는 추가 작업인 PasswordEncoder도 추가로 호출함
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		String tok=jwtUtils.getUserNameFromJwtToken(jwtUtils.generateJwtToken(authentication));
//		System.out.println("tok");
//		System.out.println(tok);
		
		
//		System.out.println("authentication.getAuthorities()");
//		System.out.println(authentication.getAuthorities());
		
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		//System.out.println("roles");
		//System.out.println(roles);

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getIndex(),
												 userDetails.getUsername(), 
												 userDetails.getId(), 
												 userDetails.getEmail(),
												 userDetails.getFirst_login(), 
												 userDetails.getRank(),
												 userDetails.getPosition(),
												 userDetails.getTeam(),
												 userDetails.getVacation(),
												 roles));
	}
	
	/*
	 	1) signUpRequest로부터 회원가입 정보를 받음.
		2) userRepository에서 Username 존재여부를 검사함(existsByUsername)
		3) 존재하지 않으면 User 객체를 신규로 생성함.
		4) 권한(Role)도 생성함.
		5) 권한이 있으면 해당 권한을 추가하고, 없으면 기본 권한을 부여함.
		6) 회원정보를 저장하고(save), 완료 메시지를 뿌려줌.
	 */

	// AuthTokenFilter가 Request로 넘어온 정보를 가지고 로그인 여부를 검사했으면,
	// Authentication Manager에서는 입력된 Request 정보가 올바른지를 검사하는 것으로 볼 수 있음
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws ParseException {
		
		//중복 아이디 가입 불가능
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			System.out.println("중복아이디");
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: ID is already taken!"));
		}
		
		//중복 이메일 가입 불가능
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			System.out.println("중복이메일");
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		

		
		CalculVacation cal = new CalculVacation();
		long vac = cal.CalculVacation(signUpRequest.getEntry_date());

		// Create new user's account
		User user = new User(
				 			 signUpRequest.getId(), 
							 signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getPosition(),
							 signUpRequest.getRank(),
							 signUpRequest.getTeam(),
							 signUpRequest.getFirst_login(),
							 vac,
							 signUpRequest.getEntry_date());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		System.out.println("signUpRequest.getRank()");
		System.out.println(signUpRequest.getRank());

		

		//직책이 팀장일때 teamleader 부여
		if(signUpRequest.getPosition()==2) {
			Role teamLeaderRole = roleRepository.findByName(ERole.ROLE_TEAMLEADER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(teamLeaderRole);
		}
		else {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		}
		
		/*
		if (strRoles == null) {
			System.out.println("str roles == null");
//  select
//        role0_.id as id1_3_,
//        role0_.name as name2_3_ 
//    from
//        roles role0_ 
//    where
//        role0_.name=?			
 
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			System.out.println(userRole);
			System.out.println(userRole.toString());
			System.out.println(userRole.getName());
			System.out.println(userRole.getId());
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					System.out.println("getRank adminnnnnnnnnnnnnnnnnn");
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		*/

		user.setRoles(roles);
		userRepository.save(user);
       
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@PostMapping("/updateEmpImg")
	public int updateEmpImg(@ModelAttribute ProjectVO vo) {
		
		return eDAO.updateEmpImg(vo);
	}
	
	@PostMapping("/update_Pwd")
	public ResponseEntity<?> pwdCheck(@Valid @RequestBody UpdatePwdRequest updatePwd) {
		System.out.println("#####checkPwd#####");
		System.out.println(updatePwd.getUsername());
		System.out.println(updatePwd.getPassword());
		System.out.println(updatePwd.getNewPassword());
				// authenticataionManager.authenticate() 메소드로 검사하며 Security 내장 기능으로 수행함
		Authentication authentication = authenticationManager.authenticate(
				// UserDetailsService를 호출하는 것은 AuthTokenFilter와 동일하다 볼 수 있으며, 비밀번호 검사를 하는 추가 작업인 PasswordEncoder도 추가로 호출함
				new UsernamePasswordAuthenticationToken(updatePwd.getUsername(), updatePwd.getPassword()));
		
		System.out.println(authentication);
		
		Optional<User> user = userRepository.findByUsername(updatePwd.getUsername());

		user.ifPresent(selectUser->{
			selectUser.setPassword(encoder.encode(updatePwd.getNewPassword()));
			userRepository.save(selectUser);
		});
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@PostMapping("/update_user")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateRequest update) {
		System.out.println("update_user");
		System.out.println(update.getId());
		System.out.println(update.getAddress());
		System.out.println(update.getPhone());
		
		Optional<User> user = userRepository.findByUsername(update.getId());

		user.ifPresent(selectUser->{
			selectUser.setPassword(encoder.encode(update.getPassword()));
			selectUser.setAddress(update.getAddress());
			selectUser.setPhone(update.getPhone());
			selectUser.setFirst_login(0L);
			userRepository.save(selectUser);
		});

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	@PostMapping("/update_userInfo")
	public ResponseEntity<?> updateUserInfo() {
		System.out.println("#####updateUserInfo#####");
				// authenticataionManager.authenticate() 메소드로 검사하며 Security 내장 기능으로 수행함
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("111111111111111111111111111111111");
		System.out.println(authentication);
		//User user = (User)authentication.getPrincipal();

		System.out.println("22222222222222222222222222222");
		
		//SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		System.out.println("333333333333333333333333333333");
		//String tok=jwtUtils.getUserNameFromJwtToken(jwtUtils.generateJwtToken(authentication));
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		
//		System.out.println("authentication.getAuthorities()");
//		System.out.println(authentication.getAuthorities());

		
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if(principal instanceof UserDetails) {
//			String username = ((UserDetails)principal).getUsername();
//			String password = ((UserDetails)principal).getPassword()
//
//		}else {
//			String username = principal.toString();
//		}
		return ResponseEntity.ok(new JwtResponse(jwt, 
												userDetails.getIndex(),
												 userDetails.getUsername(), 
												 userDetails.getId(), 
												 userDetails.getEmail(),
												 userDetails.getFirst_login(), 
												 userDetails.getRank(),
												 userDetails.getPosition(),
												 userDetails.getTeam(),
												 userDetails.getVacation(),
												 roles));
	}
	
}
