package com.learning.foodorderservice.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "food-ordering")
public class DefaultConfigurations {
	
	private List<String> timings;

	public List<String> getTimings() {
		return timings;
	}

	public void setTimings(List<String> timings) {
		this.timings = timings;
	}

}
