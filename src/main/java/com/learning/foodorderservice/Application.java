package com.learning.foodorderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.foodorderservice.config.DefaultConfigurations;
import com.learning.foodorderservice.config.Nakul;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Application implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private Nakul nakulConfig;
	

	
	@Autowired
	private DefaultConfigurations defaultConfig;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info(nakulConfig.getEmail());
		log.info(defaultConfig.getTimings().toString());
	}

}
