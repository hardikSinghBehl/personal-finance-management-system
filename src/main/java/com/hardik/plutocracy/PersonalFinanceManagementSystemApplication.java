package com.hardik.plutocracy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PersonalFinanceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceManagementSystemApplication.class, args);
	}

}
