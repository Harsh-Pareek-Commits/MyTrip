package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.assertj.core.error.SubarraysShouldHaveSameSize;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Bus;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Route;
import com.g5.tms.entities.Travels;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.repository.IRouteRepository;
import com.g5.tms.service.ICustomerService;
import com.g5.tms.service.RouteServiceImpl;
import com.jayway.jsonpath.Option;

@SpringBootTest
@ActiveProfiles("routeTest")
public class RouteServiceTest {
	
	@Autowired
	private IRouteRepository routeRepository;
	
	@Autowired
	private RouteServiceImpl routeService;
	
	
	@Test
	public void testOrderByIt() throws RouteNotFoundException {
		LocalDateTime depTime = LocalDateTime.now();
		LocalDateTime arrTime = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, date, "HydStop", 2000.00);
		Optional<Route> optional_route = Optional.of(r1);
		Mockito.when(routeRepository.findById(1)).thenReturn(optional_route);
		Route route_test = routeService.searchRoute(1);
		assertEquals(r1, route_test);
	}
	
	@Test
	public void testViewAllRoutes() {
		LocalDateTime depTime = LocalDateTime.now();
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
		assertIterableEquals(routeList,expected_outList);
		
	}
	
	
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

	
	
}


