package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Booking;

import com.g5.tms.exceptions.BookingNotFoundException;
import com.g5.tms.repository.IBookingRepository;
import com.g5.tms.service.IBookingService;;
@SpringBootTest
@ActiveProfiles("test2")
public class BookingServiceTest {
	@Autowired
	IBookingRepository book_repo;
	@Autowired
	IBookingService book_serv;
	@Test
	public void testBookingbyId() throws BookingNotFoundException{
		LocalDate date = LocalDate.now();
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, null, 1, null, null);
		//book.setBookingId(12);
		
		Optional<Booking> opt = Optional.of(book);
		Mockito.when(book_repo.findById(12)).thenReturn(opt);
		Booking test_book = book_serv.viewBooking(12);
		assertEquals(book, test_book);
	}
	@Test
	public void testAddBooking() {
		LocalDate date = LocalDate.now();
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, null, 1, null, null);
		Mockito.when(book_repo.save(book)).thenReturn(book);
		Booking test_book = book_serv.makeBooking(book);
		assertEquals(book, test_book);
		
	}
	@Test
	public void testDeleteBookingbyId() throws BookingNotFoundException {
		LocalDate date = LocalDate.now();
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, null, 1, null, null);
		Optional<Booking> opt = Optional.of(book);
		book_repo.save(book);
		book_repo.delete(book);
		Mockito.when(book_repo.findById(12)).thenReturn(opt);
		
		Booking test_book = book_serv.cancelBooking(12);
		assertEquals(book, test_book);
		
	}
	@Test
	public void testAllBooking() {
		LocalDate date = LocalDate.now();
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, null, 1, null, null);
		List<Booking> book_list = Arrays.asList(book);
		Mockito.when(book_repo.findAll()).thenReturn(book_list);
		List<Booking> actual_booklist = book_serv.viewAllBookings();
		assertEquals(book_list, actual_booklist);
	}

	
}
