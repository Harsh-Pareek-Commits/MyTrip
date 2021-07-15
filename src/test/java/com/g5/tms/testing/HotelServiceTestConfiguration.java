package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.g5.tms.repository.IHotelRepository;



@Profile("test9")
@Configuration
public class HotelServiceTestConfiguration {

	@Bean
	@Primary
	public IHotelRepository hotelService() {
		return Mockito.mock(IHotelRepository.class);
	}

}
