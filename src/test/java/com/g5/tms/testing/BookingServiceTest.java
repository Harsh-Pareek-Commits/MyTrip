package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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

import com.g5.tms.entities.Package;
import com.g5.tms.entities.PaymentDetails;
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
	public void testBookingbyId() throws BookingNotFoundException {
		LocalDate date = LocalDate.now();
		Package pack = new Package(12, "xyz", "bchd", "type", 2000, null, null);
		PaymentDetails pd=new PaymentDetails();
		pd.setNetAmount(2000);
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, pack, 1, pd, null);

		Optional<Booking> opt = Optional.of(book);
		Mockito.when(book_repo.findById(12)).thenReturn(opt);
		Booking test_book = book_serv.viewBooking(12);
		assertEquals(book, test_book);
	}

	@Test
	public void testAddBooking() {
		LocalDate date = LocalDate.now();
		Package pack = new Package(12, "xyz", "bchd", "type", 2000, null, null);
		PaymentDetails pd=new PaymentDetails();
		pd.setNetAmount(2000);
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, pack, 1, pd, null);

		Mockito.when(book_repo.save(book)).thenReturn(book);
		Booking test_book = book_serv.makeBooking(book);
		assertEquals(book, test_book);

	}

	@Test
	public void testDeleteBookingbyId() throws BookingNotFoundException {
		LocalDate date = LocalDate.now();
		Package pack = new Package(12, "xyz", "bchd", "type", 2000, null, null);
		PaymentDetails pd=new PaymentDetails();
		pd.setNetAmount(2000);
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, pack, 1, pd, null);

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
		Package pack = new Package(12, "xyz", "bchd", "type", 2000, null, null);
		PaymentDetails pd=new PaymentDetails();
		pd.setNetAmount(2000);
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, pack, 1, pd, null);

		List<Booking> book_list = Arrays.asList(book);
		Mockito.when(book_repo.findAll()).thenReturn(book_list);
		List<Booking> actual_booklist = book_serv.viewAllBookings();
		assertEquals(book_list, actual_booklist);
	}

	@Test
	void testBookingNotFoundException() {
		LocalDate date = LocalDate.now();
		Package pack = new Package(12,"xyz","bchd","type",2000,null,null);		
		PaymentDetails pd=new PaymentDetails();
		pd.setNetAmount(2000);
		Booking book = new Booking(12, "xys", "hcjks", "bjhh", date, pack, 1, pd, null);


		Optional<Booking> bookopt = Optional.of(book);
		when(book_repo.findById(1)).thenReturn(bookopt);
		org.junit.jupiter.api.function.Executable executable = () -> book_serv.viewBooking(10);
		assertThrows(BookingNotFoundException.class, executable);
	}

}
