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
	void testInvalidCredintialsException() {
		User user = new User(12, "2", "phhhhifn");
		User user2 = new User(10, "2", "kjnfkkjn");
	Optional<User> opt = Optional.of(user);
	when(user_repo.findById(12)).thenReturn(opt);
	Executable executable = ()->user_service.signIn(user2);
	assertThrows(InvalidCredentialException.class, executable);
}

}
