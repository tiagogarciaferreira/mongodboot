package com.estudo.mongodboot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = {"com.estudo.mongodboot.model"})
@ComponentScan(basePackages = {"com.estudo.mongodboot.*"})
@EnableMongoRepositories(basePackages = {"com.estudo.mongodboot.repository"})
@EnableTransactionManagement
@EnableMongoAuditing
public class MongodBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodBootApplication.class, args);
	}

}
