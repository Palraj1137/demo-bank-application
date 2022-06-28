package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//main class to execute the spring application
@SpringBootApplication
public class DemoBankApplicationSecondApplication {

	public static void main(String[] args) {
		System.out.println("Hello, Welcome to the Spring boot Banking Application implemented by using Hibernate and JPA(JPQL)");
		SpringApplication.run(DemoBankApplicationSecondApplication.class, args);

	}

}
