package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.entities.Booking;
import com.g5.exceptions.BookingNotFoundException;
@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

}
