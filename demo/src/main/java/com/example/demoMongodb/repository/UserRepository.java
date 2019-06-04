package com.example.demoMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demoMongodb.document.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {

}
