package com.g5.tms.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
	/*
	 * @Override public User signIn(User user) throws InvalidCredentialException {
	 * 
	 * Optional<User> opt = userRepository.findById(user.getUserId()); try { if
	 * (opt.isPresent()) { User u = opt.get(); boolean matched =
	 * BCrypt.checkpw(user.getPassword(), u.getPassword()); if (matched) { return u;
	 * 
	 * } else { throw new InvalidCredentialException("Invalid password"); } } else {
	 * throw new InvalidCredentialException("Invalid userID"); } } catch (Exception
	 * e) { throw new InvalidCredentialException("Invalid username or password"); }
	 * }
	 * 
	 */
	@Override
	public String signIn(User user) throws InvalidCredentialException {
		String email = "try@xyz.com";
		try {
         
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(),user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidCredentialException("Invalid Credential");
		}
		UserDetails userdetail = this.loadUserByUsername(email);
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(20).get();
		return new org.springframework.security.core.userdetails.User("sca", user.getPassword(),new ArrayList<>());

	}
	

}