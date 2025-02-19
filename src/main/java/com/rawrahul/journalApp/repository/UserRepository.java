package com.rawrahul.journalApp.repository;

import com.rawrahul.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByusername(String username);
    void deleteByusername(String username);
}

