package com.example.moviedb.Repository;


import com.example.moviedb.Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends MongoRepository<User, ObjectId> {

    Optional<User> deleteUserByUsername(String Username);
}
