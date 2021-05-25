package com.g5.repository;

import com.g5.entities.User;

public interface IUserRepository {
public  User addNewUser(User user);
public User signIn(User user);
public User signOut(User user);
}
