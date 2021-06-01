package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


import com.g5.tms.repository.IPackageRepository;

@Profile("test4")
@Configuration
public class PackageServiceTestConfiguration {
	@Bean
	   @Primary
	   public IPackageRepository packageService() {
		return Mockito.mock(IPackageRepository.class);
	}

}
