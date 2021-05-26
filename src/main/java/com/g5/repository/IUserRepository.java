package com.g5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g5.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
@Query("Select u from User where u.userId=:user_id and u.password=:password")
User findByUser(int user_id,String password);
}
