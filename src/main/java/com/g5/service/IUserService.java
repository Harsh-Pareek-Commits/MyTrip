package com.g5.service;



import com.g5.entities.User;
import com.g5.exceptions.InvalidCredentialException;

public interface IUserService {
public  User addNewUser(User user);
public User signIn(User user) throws InvalidCredentialException;
public User signOut(User user);
}
