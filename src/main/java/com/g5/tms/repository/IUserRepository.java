package com.g5.tms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.g5.tms.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
