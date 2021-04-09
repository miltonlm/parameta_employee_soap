package com.parameta.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Main class for the spring boot.
 * */
@SpringBootApplication
public class EmployeeApplication {

	/**
	 * Entry point for the program.
	 *
	 * @param args Arguments from the command line.
	 * */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
