package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.entities.Booking;
import com.g5.exceptions.BookingNotFoundException;

public interface IBookingRepository extends JpaRepository<Booking, Integer> {

}
