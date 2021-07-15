package com.g5.tms.testing;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Bus;
import com.g5.tms.entities.Hotel;
import com.g5.tms.entities.Package;
import com.g5.tms.entities.Route;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.repository.IPackageRepository;
import com.g5.tms.service.IPackageService;



@SpringBootTest
@ActiveProfiles("test4")
public class PackageServiceTest {
	@Autowired
	IPackageRepository pack_repo;
	@Autowired
	IPackageService pack_serv;	
	@Test
	public void testPackageById() throws PackageNotFoundException {
		Package pack = new Package(12,"xyz","bchd","type",2000,null,null);		
		Optional<Package> opt = Optional.of(pack);
		Mockito.when(pack_repo.findById(12)).thenReturn(opt);
		Package test_pack = pack_serv.searchPackage(12);
		assertEquals(pack, test_pack);
	}
	@Test
	public void testAddPackage() throws PackageNotFoundException{
		LocalDate depTime = LocalDate.now();
		LocalDate arrTime = LocalDate.now();
		LocalTime depaTime= LocalTime.now();
		LocalTime arraTime= LocalTime.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, depaTime,arraTime, "HydStop", 2000.00);
		Hotel hotel = new Hotel(1,"abcd","xyzab","dsff","aervc",2000,"available","adbcd");
		List<Hotel>hlist= Arrays.asList(hotel);
		Package pack = new Package(13,"asdf","bchd","type",2000,r1,hlist);
		Mockito.when(pack_repo.save(pack)).thenReturn(pack);
		Package test_pack = pack_serv.addPackage(pack);
		assertEquals(pack, test_pack);
		
	}
	@Test
	public void testAllPackage() {
		
		Package pack = new Package(12,"xyz","bchd","type",2000,null,null);
		List<Package> pack_list = Arrays.asList(pack);
		Mockito.when(pack_repo.findAll()).thenReturn(pack_list);
		List<Package> actual_packlist = pack_serv.viewAllPackages(null, null);
		assertEquals(pack_list, actual_packlist); 
	}

	@Test
	public void testDeletePackagebyId() throws PackageNotFoundException {

		Package pack = new Package(12,"xyz","bchd","type",2000,null,null);
		Optional<Package> opt = Optional.of(pack);
		pack_repo.save(pack);
		pack_repo.delete(pack);
		Mockito.when(pack_repo.findById(12)).thenReturn(opt);
		
		Package test_pack = pack_serv.deletePackage(12);
		assertEquals(pack, test_pack);
		
	}
	@Test
		void testPackageNotFound() {
		Package pack = new Package(12, "packi2", "descc", "type", 12356,null, null);
		
		Optional<Package> opt = Optional.of(pack);
		when(pack_repo.findById(12)).thenReturn(opt);
		Executable executable = ()->pack_serv.searchPackage(10);
		assertThrows(PackageNotFoundException.class, executable);
	}
	/*@Test
	public List<Package> viewByRoute(String from, String to, Optional<String> sortBy, Optional<String> sort,String string ) throws PackageNotFoundException{
		List<Package> list = null;
		LocalDate depTime = LocalDate.now();
		LocalDate arrTime = LocalDate.now();
		LocalTime depaTime= LocalTime.now();
		LocalTime arraTime= LocalTime.now();
		Bus bus1 = new Bus(101, "xyz", "AP90", 20, null);
		Bus bus2 = new Bus(102, "xyz", "AP90", 20, null);
		List<Bus> bList = Arrays.asList(bus1, bus2);
		Route r1 = new Route(01, "Hyd", "Banglore", bList, depTime, arrTime, depaTime,arraTime, "HydStop", 2000.00);

		when(pack_repo.findByRoute("Hyd", "Banglore", depTime)).thenReturn(list);
		Executable executable = ()->pack_serv.viewByRoute("Hyd", "Banglore", depTime, "asc", "2021-01-22");
		assertThrows(PackageNotFoundException.class, executable);
	}
	*/
	@Test
	public void testsearchPackagebyName(String name) throws PackageNotFoundException{
		Package pack = new Package(12,"xyz","bchd","type",2000,null,null);		
		Optional<Package> opt = Optional.of(pack);
		Mockito.when(pack_repo.findByName("xyz")).thenReturn(opt);
		Package test_pack = pack_serv.searchPackagebyName("xyz");
		assertEquals(pack, test_pack);
	}
	@Test
	public  void  testdeletePackagebyName(String name) throws PackageNotFoundException{
		Package pack = new Package(12,"xyz","bchd","type",2000,null,null);
		Optional<Package> opt = Optional.of(pack);
		pack_repo.save(pack);
		pack_repo.delete(pack);
		Mockito.when(pack_repo.findByName("xyz")).thenReturn(opt);
		
		Package test_pack = pack_serv.deletePackagebyName("xyz");
		assertEquals(pack, test_pack);
		
	}
	}
	

