package com.example.moviedb.Repository;



import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.moviedb.Model.Film1;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;



public class FilmRepository {

    private final List<Film1> Film1 = new ArrayList<Film1>();

    public FilmRepository(){


    }



    public List<Film1> findAll(){
        return Film1;
    }





    public Optional<Film1> findById(Integer id) {
        return Film1.stream().filter(c -> c.id == id).findFirst();
    }


    @PostConstruct
    private void init(){
    Film1 f = new Film1();
    f.id = 1;
    f.name = "The Ususal Suspects";
    Film1.add(f);
    }




}
