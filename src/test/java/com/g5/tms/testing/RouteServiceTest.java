package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Bus;
import com.g5.tms.entities.Route;
import com.g5.tms.exceptions.ReportNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;

import com.g5.tms.repository.IRouteRepository;

import com.g5.tms.service.RouteServiceImpl;


@SpringBootTest
@ActiveProfiles("routeTest")
public class RouteServiceTest {
	
	@Autowired
	private IRouteRepository routeRepository;
	
	@Autowired
	private RouteServiceImpl routeService;
	
	
	
	@Test
	public void testRouteById() throws RouteNotFoundException {
		int input = 101;
		Route route = mock(Route.class);
		Optional<Route> optional_route = Optional.of(route);
		when(routeRepository.findById(input)).thenReturn(optional_route);
		Optional<Route> route_test = Optional.of(routeService.searchRoute(input));
		assertEquals(optional_route, route_test);
	}
	
	
	@Test
	public void testViewAllRoutes() {
		List<Route> routeList = mock(List.class);
		when(routeRepository.findAll()).thenReturn(routeList);
		List<Route> outputRoutList = routeService.viewRouteList();
		assertEquals(routeList, outputRoutList);
		
	}
	
	
	@Test
	public void testAddRoute() {
		LocalDate depTime = LocalDate.now();
		LocalDate arrTime = LocalDate.now();
		LocalTime depaTime= LocalTime.now();
		LocalTime arraTime= LocalTime.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, depaTime,arraTime, "HydStop", 2000.00);
		when(routeRepository.save(r1)).thenReturn(r1);
		Route result = routeService.addRoute(r1);
		assertEquals(r1, result);
		
	}
	
	
	@Test
	public void testUpdateRoute() throws RouteNotFoundException {
		LocalDate depTime = LocalDate.now();
		LocalDate arrTime = LocalDate.now();
		LocalTime depaTime= LocalTime.now();
		LocalTime arraTime= LocalTime.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, depaTime,arraTime, "HydStop", 2000.00);
		Optional<Route> optionalRoute = Optional.of(r1);
		Route updatedRoute = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, depaTime,arraTime, "HydStop", 2000.00);
		when(routeRepository.findById(1)).thenReturn(optionalRoute);
		when(routeRepository.save(updatedRoute)).thenReturn(updatedRoute);
		Route outputCustomer = routeService.updateRoute(updatedRoute);
		assertEquals(updatedRoute, outputCustomer);
		
	}
	@Test
	void testRouteNotFoundException() {
		LocalDate depTime = LocalDate.now();
		LocalDate arrTime = LocalDate.now();
		LocalTime depaTime= LocalTime.now();
		LocalTime arraTime= LocalTime.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, depaTime,arraTime, "HydStop", 2000.00);
		Optional<Route> route = Optional.of(r1);
		when(routeRepository.findById(1)).thenReturn(route);
		org.junit.jupiter.api.function.Executable executable = ()->routeService.searchRoute(3);
		assertThrows(RouteNotFoundException.class, executable);
	}
}


