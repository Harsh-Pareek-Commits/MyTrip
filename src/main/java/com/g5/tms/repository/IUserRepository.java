package com.g5.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
@Query("Select u from User u where u.userId=:username and u.password=:pass")
User findByUser(@Param("username") Integer username,@Param("pass") String pass);
}
