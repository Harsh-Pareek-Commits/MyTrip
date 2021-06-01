package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.g5.tms.repository.IBookingRepository;
import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.repository.IPackageRepository;

@Profile("test")
@Configuration
public class CustomerServiceTestConfiguration {
	@Bean
	   @Primary
	   public ICustomerRepository  customerService() {
	      return Mockito.mock(ICustomerRepository.class);
	   }
	@Bean
	@Primary
	public IBookingRepository  bookingService() {
		return Mockito.mock(IBookingRepository.class);
	}
	@Bean
	@Primary
	public IPackageRepository  packageService() {
		return Mockito.mock(IPackageRepository.class);
	}
}
