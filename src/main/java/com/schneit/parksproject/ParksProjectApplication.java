package com.schneit.parksproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class ParksProjectApplication implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;

	public ParksProjectApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(ParksProjectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT full_name FROM parks WHERE id = 1";

		String result = jdbcTemplate.queryForObject(sql, String.class);

		System.out.println(result);
	}
}
