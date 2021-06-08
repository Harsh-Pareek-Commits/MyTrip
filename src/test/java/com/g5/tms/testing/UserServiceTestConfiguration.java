package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.repository.ITravelsRespository;
import com.g5.tms.repository.IUserRepository;

@Profile("user")
@Configuration
public class UserServiceTestConfiguration {

	@Bean
	@Primary
	public IUserRepository userService() {
		return Mockito.mock(IUserRepository.class);
	}
	@Bean
	   @Primary
	   public ICustomerRepository  customerService() {
	      return Mockito.mock(ICustomerRepository.class);
	   }
}
