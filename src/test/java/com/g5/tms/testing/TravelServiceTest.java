package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import com.g5.tms.entities.Travels;

import com.g5.tms.exceptions.TravelsNotFoundException;
import com.g5.tms.repository.ITravelsRespository;
import com.g5.tms.service.ITravelsService;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test4")
public class TravelServiceTest {
	
	@Autowired
	ITravelsRespository travel_repo;
	@Autowired
	ITravelsService travel_service;
	
	@Test
	public void testAddTravel() throws TravelsNotFoundException  {
		Travels travel = new Travels(1, "MakeMyTrip", "Harsh","indranagar","7485961230");
		Mockito.when(travel_repo.save(travel)).thenReturn(travel);
		Travels result = travel_service.addTravels(travel);
		assertEquals(travel, result);
		
	}
	
	@Test
	public void testUpdateTravel() throws TravelsNotFoundException {
		Travels travel = new Travels(1, "MakeMyTrip", "Harsh","indranagar","7485961230");
		Optional<Travels> travels_opt = Optional.of(travel);
		travel_repo.save(travel);
		Travels updatedTravel = new Travels(1, "MakeMyTrip", "iflak","indranagar","7485978230");
		Mockito.when(travel_repo.findById(1)).thenReturn(travels_opt);
		Mockito.when(travel_repo.save(updatedTravel)).thenReturn(updatedTravel);
		Travels outputTravel = travel_service.updateTravels(updatedTravel);
		assertEquals(outputTravel,updatedTravel);
	}
	
	@Test
	public void testViewById() throws TravelsNotFoundException {
		Travels travel = new Travels(1, "MakeMyTrip", "Harsh","indranagar","7485961230");
		Optional<Travels> opt = Optional.of(travel);
		Mockito.when(travel_repo.findById(1)).thenReturn(opt);
		Travels test_travel = travel_service.searchTravels(1);
		assertEquals(travel, test_travel);
	}
	
	@Test
	public void testViewAllTravel() {
		Travels travel = new Travels(1, "MakeMyTrip", "Harsh","indranagar","7485961230");
		Travels travel1 = new Travels(2, "MakeMyTrip", "iflak","srinagar","7485978230");
		List<Travels> travel_list = Arrays.asList(travel,travel1);
		Mockito.when(travel_repo.findAll()).thenReturn(travel_list);
		List<Travels> actual_travel = travel_service.viewTravels();
		assertEquals(travel_list, actual_travel);
	};
	
	@Test
	void testTravelsNotFoundException() {
		Travels travels = new Travels(1, "MakeMyTrip", "Harsh","indranagar","7485961230");
		
		Optional<Travels> opt = Optional.of(travels);
		when(travel_repo.findById(1)).thenReturn(opt);
		org.junit.jupiter.api.function.Executable executable = ()->travel_service.searchTravels(3);
		assertThrows(TravelsNotFoundException.class, executable);
	}


}
