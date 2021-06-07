package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Customer;
import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;
import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.repository.IUserRepository;
import com.g5.tms.service.ICustomerService;
import com.g5.tms.service.IUserService;

@SpringBootTest
@ActiveProfiles("user")
public class UserServiceTest {
	@Autowired
	IUserRepository user_repo;
	@Autowired
	IUserService user_service;
	@Autowired
	private ICustomerService cust_Service;

	@Autowired
	private ICustomerRepository cust_repo;
	@Test
	public void testAddUser() {
		User user = new User(12, "2", "phhhhifn");
		Mockito.when(user_repo.save(user)).thenReturn(user);
		User result = user_service.addNewUser(user);
		assertEquals(user, result);
		
	}
	
	@Test
	public void testSignIn() throws InvalidCredentialException {
		//Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		//Customer cust = new Customer(customerName, address, mobileNo, email);
		User user= new User();
		user.setUserType("3");
		user.setUserId(1);
		user.setPassword("nshshsh");
		String securedPasswordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
		user.setPassword(securedPasswordHash);
		user_repo.save(user);
		System.out.println(user);
		Optional<User> opt = Optional.of(user);
		when(user_service.signIn(user)).thenReturn(user);
		when(user_repo.findById(1)).thenReturn(opt);
		User usera =user_service.signIn(user);
		System.out.println(usera);
		//User user2=(User)cust2;
		
		assertEquals(usera, user);
		
	}
	@Test
	void testInvalidCredintialsException() {
		User user = new User(12, "2", "phhhhifn");
		User user2 = new User(10, "2", "kjnfkkjn");
	Optional<User> opt = Optional.of(user);
	when(user_repo.findById(12)).thenReturn(opt);
	Executable executable = ()->user_service.signIn(user2);
	assertThrows(InvalidCredentialException.class, executable);
}

}
