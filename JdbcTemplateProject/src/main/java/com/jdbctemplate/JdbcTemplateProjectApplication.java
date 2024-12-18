package com.jdbctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JdbcTemplateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateProjectApplication.class, args);
	}

}
