package com.exp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableEurekaClient
@EnableMongoRepositories(basePackages = "com.exp.user.repository")
@SpringBootApplication
public class MongoDbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbServiceApplication.class, args);
	}
}
