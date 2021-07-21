package com.gs52.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gs52.jwt.security.jwt.AuthEntryPointJwt;
import com.gs52.jwt.security.jwt.AuthTokenFilter;
import com.gs52.jwt.security.services.UserDetailsServiceImpl;


//Security에서는 모든 웹페이지에 대한 요청이 들어올 때 OncePerRequestFilter로 오는 것으로 설계가 되어 있음
//OncePerRequestFilter에서 수행하는 동작은 웹페이지에 접근할 때 현재 로그인이 되어 있는 상태인지에 대한 부분을 검사함

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)      // @PreAuthorize("hasRole('MODERATOR')") 로 TestController에 정의함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
		
//		OncePerRequestFilter로부터 상속받은 객체로, 직접 선언해야 함
//		로그인을 시도할 때 객체를 생성하며, Security의 내장 객체(UserDetails)를 가지고 인증을 수행함
	}

	//인증방법 의미
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
		
//		Security 내장객체인 AuthenticationManager를 반환합니다. 별도로 선언은 하지 않아도 되며, 
//		인증 수행을 위한 동작을 나타냄.
	}

	//로그인 시 db에 BCrypt로 저장되어 있는 패스워드를 로그인할 때 입력한 비밀번호와 비교하기 위해 사용
	@Bean
	public PasswordEncoder passwordEncoder() {  //내장객체로, 비밀번호 암호화를 담당
		return new BCryptPasswordEncoder();
	}

	//jwt 인증이 실패할 경우 처리할 entry 설정과 JWT인증에서는 세션을 사용하지 않기 때문에, session을 stateless해줌.
	//jwt인증을 처리할 filter를 springsecurity의 기본적인 필터인 UsernamePasswordAuthenticationFilter를 넣어준다.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("안녕");
		http.cors().and().csrf().disable()   // rest api이므로 csrf 보안이 필요없으므로 disable처리
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()   // jwt token으로 인증할것이므로 세션필요없음
			.authorizeRequests()
			.antMatchers("/manager/holiday/showHoliday").permitAll()
			//.antMatchers("/manager").access("hasAnyRole('ADMIN', 'TEAMLEADER')")
			.antMatchers("/manager/regist/**").access("hasAnyRole('ADMIN')")
			.antMatchers("/manager/addAccount/**").access("hasAnyRole('ADMIN')")
			.antMatchers("/manager/addoptions/**").access("hasAnyRole('ADMIN')")
			.antMatchers("/manager/holiday/addHoliday").access("hasAnyRole('ADMIN')")
			.antMatchers("/manager/holiday/delHoliday").access("hasAnyRole('ADMIN')")
			.antMatchers("/manager/insight/**").access("hasAnyRole('ADMIN')")
			.antMatchers("/manager/vacation/**").access("hasAnyRole('ADMIN','TEAMLEADER')")
			.antMatchers("/manager/project/**").access("hasAnyRole('ADMIN','TEAMLEADER')")
			.antMatchers("/report/empList").access("hasRole('TEAMLEADER')")
			.antMatchers("/api/auth/**").permitAll()
			.antMatchers("/**").permitAll()
			//.antMatchers("/manager").access("hasRole('ROLE_ADMIN')")
//			.antMatchers("/manager/**").hasRole("ROLE_ADMIN")
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
