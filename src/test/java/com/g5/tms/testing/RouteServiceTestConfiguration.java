package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import com.g5.tms.repository.IRouteRepository;

@Profile("routeTest")
@Configuration

public class RouteServiceTestConfiguration {
	
	@Bean
	@Primary
	public IRouteRepository routeService() {
		return Mockito.mock(IRouteRepository.class);
	}
	

}
