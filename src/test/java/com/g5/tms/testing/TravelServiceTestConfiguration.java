package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import com.g5.tms.repository.ITravelsRespository;

@Profile("test4")
@Configuration
public class TravelServiceTestConfiguration {
	
	@Bean
	@Primary
	public ITravelsRespository travelService() {
		return Mockito.mock(ITravelsRespository.class);
	}

}
