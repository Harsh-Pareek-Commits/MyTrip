package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

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
		

			int username=user.getUserId();
			String pass=user.getPassword();
		
			Optional<User>opt = user_repo.findByUser(username, pass);
	    if(opt.isEmpty()){
			throw new InvalidCredentialException("Autorization failed! user not found in signin");

		}

		return opt.get();
	}

	@Override
	public User signOut(User user) {

		return null;
	}

}
