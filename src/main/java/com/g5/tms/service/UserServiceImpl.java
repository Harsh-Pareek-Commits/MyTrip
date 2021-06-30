package com.g5.tms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Admin;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;
import com.g5.tms.repository.IUserRepository;
import com.g5.tms.security.JwtUtil;

@Service

public class UserServiceImpl implements IUserService, UserDetailsService {
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	IUserRepository userRepository;
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	/*
	 * Author= Iflak Yousuf Mir Date= 24-May-2021 Method name: addNewUser
	 * Parameters: user object Return Type: user object
	 *
	 **/

	@Override
	@Transactional
	public User addNewUser(User user) {
		try {
			if ((user.getPassword() != null)) {
				String securedPasswordHash =passwordEncoder.encode(user.getPassword());
				user.setPassword(securedPasswordHash);
			}
			user.setUserType("2");
			userRepository.save(user);
		} catch (Exception e) {
			log.error("Adding user exception", e);

		}

		return user;
	}

	/*
	 * Author= Iflak Yousuf Mir Date= 24-May-2021 Method name: signIn Parameters:
	 * user object Return Type: user object
	 *
	 **/
	
	@Override
	public String signIn(User user) throws InvalidCredentialException {
		
		try {
         
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidCredentialException("Invalid Credential");
		}
		UserDetails userdetail = this.loadUserByUsername(user.getEmail());
		String token = this.jwtutil.generateToken(userdetail);
		return token;
	}

	/*
	 * Author= Iflak Yousuf Mir Date= Method name: signOut Parameters: user object
	 *
	 **/

	@Override
	public User signOut(User user) {

		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email).get();
		System.out.println("USER ROCKS" +"   "+ user.getUserType());
		 String role="";
		if(user.getUserType().equals("2")) {
			System.out.println("ADMIN ROCKS");
			role="ROLE_ADMIN";
			
		}
		else if(user.getUserType().equals("3")) {
			System.out.println("CUSTOMER ROCKS");
			role="ROLE_USER";
			
		}
		 Set auth = new HashSet<>();
		
	            auth.add(new SimpleGrantedAuthority(role));
		
		System.out.println(auth);
		 	return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),auth);

	}
	

}