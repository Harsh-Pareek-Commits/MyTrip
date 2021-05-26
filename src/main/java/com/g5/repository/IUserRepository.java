package com.g5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
