package com.greatlearning.gradedproject6.erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.gradedproject6.erp.security.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
			.antMatchers("/h2-console/**", "/h2-console/login.do**", "/h2-console**","/**login**")	
				.permitAll()
			.antMatchers(HttpMethod.GET, "/api/employees/**")
				.hasAnyRole("USER","ADMIN")
			.antMatchers(HttpMethod.GET, "/api/users/**")
				.hasAnyRole("USER","ADMIN")
			.antMatchers(HttpMethod.GET, "/api/roles/**")
				.hasAnyRole("USER","ADMIN")
			.antMatchers(HttpMethod.POST,"/api/roles**")
				.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.POST,"/api/users**")
				.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.POST,"/api/employees**")
				.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.PUT,"/api/employees/**")
				.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.DELETE,"/api/employees**")
				.hasAnyRole("ADMIN")
			.anyRequest()
				.fullyAuthenticated()
			.and()
			.httpBasic();

		http
			.cors()
			.and()
			.csrf()
				.ignoringAntMatchers("/h2-console/**")
				.ignoringAntMatchers("/api/roles**")
				.ignoringAntMatchers("/api/users**")
				.ignoringAntMatchers("/api/employees**")
				.ignoringAntMatchers("/api/employees/**")
			.and()
			.headers()
			.frameOptions().disable();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
}
