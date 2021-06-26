package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
		/**LocalDateTime depTime = LocalDateTime.now();
		LocalDateTime arrTime = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList1 = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList1, depTime, arrTime, date, "HydStop", 2000.00);
		Bus bus3 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus4 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList2 = Arrays.asList(bus3, bus4);
		Route r2 = new Route(01, "Hyd", "Banglore", bList2, depTime, arrTime, date, "HydStop", 2000.00);
		List<Route> routeList = Arrays.asList(r1, r2);
		System.out.println(routeList);
		when(routeRepository.findAll()).thenReturn(routeList);
		List<Route> expected_outList = routeService.viewRouteList();
		System.out.println(expected_outList);
		assertIterableEquals(routeList,expected_outList);**/
		List<Route> routeList = mock(List.class);
		when(routeRepository.findAll()).thenReturn(routeList);
		List<Route> outputRoutList = routeService.viewRouteList();
		assertEquals(routeList, outputRoutList);
		
	}
	
	/*
	@Test
	public void testAddRoute() {
		LocalDateTime depTime = LocalDateTime.now();
		LocalDateTime arrTime = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, date, "HydStop", 2000.00);
		when(routeRepository.save(r1)).thenReturn(r1);
		Route result = routeService.addRoute(r1);
		assertEquals(r1, result);
		
	}
	
	
	@Test
	public void testUpdateRoute() throws RouteNotFoundException {
		LocalDateTime depTime = LocalDateTime.now();
		LocalDateTime arrTime = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(1, "Hyd", "Banglore", bList, depTime, arrTime, date, "HydStop", 2000.00);
		Optional<Route> optionalRoute = Optional.of(r1);
		Route updatedRoute = new Route(1, "Banglore", "Hyd", bList, depTime, arrTime, date, "BangloreStop", 2000.00);
		when(routeRepository.findById(1)).thenReturn(optionalRoute);
		when(routeRepository.save(updatedRoute)).thenReturn(updatedRoute);
		Route outputCustomer = routeService.updateRoute(updatedRoute);
		assertEquals(updatedRoute, outputCustomer);
		
	}
	@Test
	void testRouteNotFoundException() {
		LocalDateTime depTime = LocalDateTime.now();
		LocalDateTime arrTime = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		Route r1 = new Route(1, "Hyd", "Banglore", null, depTime, arrTime, date, "HydStop", 2000.00);
		Optional<Route> route = Optional.of(r1);
		when(routeRepository.findById(1)).thenReturn(route);
		org.junit.jupiter.api.function.Executable executable = ()->routeService.searchRoute(3);
		assertThrows(RouteNotFoundException.class, executable);
	}
	*/
	
}


