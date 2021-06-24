package com.g5.tms.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Booking;


@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {
	@Query("select b from Booking b where  b.ticket.ticketId=:ticketId")
    Optional<Booking> findByTicketId(@Param("ticketId") Integer ticketId);
}
