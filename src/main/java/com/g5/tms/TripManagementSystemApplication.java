package com.g5.tms;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@Configuration
public class TripManagementSystemApplication {
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
	
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("Travel website").description("contains api to manipulate trip management")
				.version("myproductappV1.1").build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TripManagementSystemApplication.class, args);
	
	}

}
