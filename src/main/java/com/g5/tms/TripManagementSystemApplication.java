package com.g5.tms;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class TripManagementSystemApplication {
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TripManagementSystemApplication.class, args);
	
	}

}
