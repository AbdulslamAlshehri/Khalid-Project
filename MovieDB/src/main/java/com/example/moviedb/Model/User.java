package com.example.moviedb.Model;

import com.fasterxml.jackson.databind.type.CollectionType;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.Collection;
import java.util.List;

@Document(collection ="Users")
public class User {
    @Id
    @MongoId
    public ObjectId id;
    @NotNull
    @Size(max = 25)
    public String username;
    @Email
    public String email;
    public String password;
    public List<String> Wishlist;

    public User(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }
}

