package com.g5.tms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	@Query("Select f from Feedback f where f.customer.userId=:customerId")
	List<Feedback> findbyCustId(@Param("customerId") Integer customerId);
		
	

}
