package com.docker.springauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SpringBootRestAuthenticationPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestAuthenticationPracticeApplication.class, args);
	}

}
