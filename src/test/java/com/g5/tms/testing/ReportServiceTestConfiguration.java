package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


import com.g5.tms.repository.IReportRepository;

@Profile("test8")
@Configuration
public class ReportServiceTestConfiguration {
	@Bean
	@Primary
	public IReportRepository reportService() {
	      return Mockito.mock(IReportRepository.class);

}
	}
