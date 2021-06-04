package com.g5.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@SpringBootApplication

public class TripManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripManagementSystemApplication.class, args);
	
	}

}
