package com.g5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
