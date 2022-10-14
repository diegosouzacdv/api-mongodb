package com.blog.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.example.models.User;

public interface UserRepository extends MongoRepository<User, String>{

}
