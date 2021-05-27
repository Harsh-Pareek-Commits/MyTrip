package com.g5.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;
import com.g5.tms.repository.IUserRepository;

@Service

public class UserServiceImpl implements IUserService {
	@Autowired
	IUserRepository user_repo;

	@Override
	@Transactional
	public User addNewUser(User user) {
		try {
			user_repo.save(user);
		} catch (Exception e) {
			e.getStackTrace();

		}

		return user;
	}

	@Override
	public User signIn(User user) throws InvalidCredentialException {
		User user1 = null;

		try {
			int username=user.getUserId();
			String pass=user.getPassword();
			user1 = user_repo.findByUser(username, pass);
		} catch (Exception e) {
			e.getStackTrace();
			throw new InvalidCredentialException("User not found in signin");

		}

		return user1;
	}

	@Override
	public User signOut(User user) {

		return null;
	}

}
