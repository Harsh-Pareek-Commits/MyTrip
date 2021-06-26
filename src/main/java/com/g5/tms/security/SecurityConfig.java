package com.g5.tms.security;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.g5.tms.service.UserServiceImpl;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    public UserServiceImpl userservice;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userservice).passwordEncoder(passwordEncoder());
		
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	         http 	              
	              .cors().disable()
	              .csrf().disable()
	              .authorizeRequests()
	              .antMatchers("/customer/add","/user/signin").permitAll()
	              .anyRequest().authenticated()
	              .and()
	              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	              
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
 
}
