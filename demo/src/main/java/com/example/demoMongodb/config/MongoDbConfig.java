package com.example.demoMongodb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demoMongodb.document.Users;
import com.example.demoMongodb.repository.UserRepository;

@EnableMongoRepositories(basePackageClasses=UserRepository.class)
@Configuration
public class MongoDbConfig {
  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepository) {
	  return strings->{
		  userRepository.save(new Users(1,"suri","development","3000L"));
		  userRepository.save(new Users(2,"aravind","tester","2000L"));
	   };
  }
  
  }
