package com.example.moviedb.Model;

import org.springframework.stereotype.Component;

@Component

public class Film1 {

    public Integer id;
    public String discription;
    public String name;

    public Film1() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

