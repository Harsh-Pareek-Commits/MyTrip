package com.g5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.entities.User;
import com.g5.exceptions.InvalidCredentialException;
import com.g5.repository.IUserRepository;
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
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public User signIn(User user) throws InvalidCredentialException {
		User user1=null;
		
		try {
			user1=user_repo.findByUser(user.getUserId(),user.getPassword());
		} catch (Exception e) {
			e.getStackTrace();
			throw new InvalidCredentialException("User not found");
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public User signOut(User user) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
