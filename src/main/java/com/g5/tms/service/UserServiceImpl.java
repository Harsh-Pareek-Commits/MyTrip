package com.g5.tms.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;
import com.g5.tms.repository.IUserRepository;

@Service

public class UserServiceImpl implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	@Transactional
	public User addNewUser(User user) {
		try {
			user.setUserType("1");
			userRepository.save(user);
		} catch (Exception e) {
			e.getStackTrace();

		}

		return user;
	}

	@Override
	public User signIn(User user) throws InvalidCredentialException {
		
		Optional<User> opt = userRepository.findById(user.getUserId());
		try {
			if (opt.isPresent()) {
				User u = opt.get();
				boolean matched = BCrypt.checkpw(user.getPassword(), u.getPassword());
				if (matched) {
					return u;

				} else {
					throw new InvalidCredentialException("Invalid username or password");
				}
			} else {
				throw new InvalidCredentialException("Invalid username or password");
			}
		} catch (Exception e) {
			throw new InvalidCredentialException("Invalid username or password");
		}
	}

	@Override
	public User signOut(User user) {

		return null;
	}

}
