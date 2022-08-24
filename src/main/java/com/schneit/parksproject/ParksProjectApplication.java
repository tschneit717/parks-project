package com.schneit.parksproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication(scanBasePackages = {"parks"})
public class ParksProjectApplication implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;

	public ParksProjectApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(ParksProjectApplication.class, args);
	}

	// Controller GET /hello
		// Answers the request
	// Service
		// "Middleware"
		// Handle or verify data
	// Repository Class
		// Speaks to third party source (databases, etc)
		// Map data from data access class to our model
	// Data Access Class
		// Return the type from database
	// Database

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT full_name FROM parks WHERE id = 1";

		String result = jdbcTemplate.queryForObject(sql, String.class);

		System.out.println(result);
	}
}
