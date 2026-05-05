package com.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.profile")
public class ProtfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtfolioApplication.class, args);
	}

}
