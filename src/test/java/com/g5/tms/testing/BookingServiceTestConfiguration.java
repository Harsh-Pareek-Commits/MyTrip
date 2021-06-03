package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.g5.tms.repository.IBookingRepository;

@Profile("test2")
@Configuration
public class BookingServiceTestConfiguration {
	@Bean
	   @Primary
	   public IBookingRepository bookingService() {
		return Mockito.mock(IBookingRepository.class);
	}

}
