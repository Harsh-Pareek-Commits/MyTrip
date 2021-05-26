package com.g5.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Booking;
import com.g5.tms.exceptions.BookingNotFoundException;
@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

}
