package com.kichan.cookestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CookestoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookestoreApplication.class, args);
	}

}
