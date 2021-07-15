package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Hotel;
import com.g5.tms.exceptions.HotelNotFoundException;
import com.g5.tms.repository.IHotelRepository;
import com.g5.tms.service.IHotelService;


@SpringBootTest
@ActiveProfiles("test9")
public class HotelServiceTest {
	
	@Autowired
	IHotelRepository hotel_repo;
	@Autowired
	IHotelService hotel_serv;	
	
	@Test
	public void testAddHotel() throws HotelNotFoundException{
		
		Hotel hotel = new Hotel(1,"abcd","xyzab","dsff","aervc",2000,"available","adbcd");
		Mockito.when(hotel_repo.save(hotel)).thenReturn(hotel);
		Hotel test_hotel = hotel_serv.addHotel(hotel);
		assertEquals(hotel, test_hotel);
		
	}
	@Test
	public void testsearchHotelbyName(String name) throws HotelNotFoundException{
		Hotel hotel = new Hotel(1,"abcd","xyzab","dsff","aervc",2000,"available","adbcd");		
		Optional<Hotel> opt = Optional.of(hotel);
		Mockito.when(hotel_repo.findByName("abcd")).thenReturn(opt);
		Hotel test_hotel = hotel_serv.searchHotelbyName("abcd");
		assertEquals(hotel, test_hotel);
	}
	
	@Test
	public void testsearchHotelbyCity(String name) throws HotelNotFoundException{
		Hotel hotel = new Hotel(1,"asdf","xyzab","dsff","aervc",2000,"available","lmn");		
		List<Hotel> hotelList = Arrays.asList(hotel);
		Mockito.when(hotel_repo.findByCity("lmn")).thenReturn(hotelList);
		List<Hotel> test_hotel = hotel_serv.searchHotelbyCity("lmn");
		assertEquals(hotel, test_hotel);
	}
	

}
