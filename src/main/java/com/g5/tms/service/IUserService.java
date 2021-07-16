package com.g5.tms.service;



import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;

public interface IUserService {
public  User addNewUser(User user);
public  User getUser(User user);
public String signIn(User user) throws InvalidCredentialException;
public User signOut(User user);
}
