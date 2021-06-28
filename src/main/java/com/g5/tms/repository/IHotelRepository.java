package com.g5.tms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Hotel;
@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

	

	@Query("select h from Hotel h where h.hotelName=:hotelName")
	Optional<Hotel> findByName(@Param("hotelName") String hotelName);
	

	@Query("select h from Hotel h where h.city=:city")
	List<Hotel> findByCity(@Param("city") String city);
	
}
