package com.g5.tms.testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import com.g5.tms.repository.IFeedbackRepository;

@Profile("test3")
@Configuration
public class FeedbackServiceTestConfiguration {
	
	@Bean
	@Primary
	public IFeedbackRepository feedbackService() {
		return Mockito.mock(IFeedbackRepository.class);
	}

}
