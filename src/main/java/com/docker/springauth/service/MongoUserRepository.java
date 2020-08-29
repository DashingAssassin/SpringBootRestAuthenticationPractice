package com.docker.springauth.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.docker.springauth.model.User;

@Repository
public interface MongoUserRepository extends MongoRepository<User, ObjectId> {

	User findByUsername(String username);

}
