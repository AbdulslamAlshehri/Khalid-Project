package com.example.moviedb.Controller;

import com.example.moviedb.Model.User;
import com.example.moviedb.Repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/Film")
@CrossOrigin()
public class FilmController {
    private final String api_key = "?api_key=0de24e1a81e3ae1e5197ac83ef9fd46f";
    private final String api = "https://api.themoviedb.org/3";
    private RestTemplate a = new RestTemplate();

    private final UsersRepository repository;

    public FilmController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<User> findAll() {
        return repository.findAll();

    }

    @GetMapping("/DB")
    public Object Movielist() {
        RestTemplate a = new RestTemplate();
        return new ResponseEntity<Object>(a.getForObject("https://api.themoviedb.org/3/movie/11?api_key=0de24e1a81e3ae1e5197ac83ef9fd46f", Object.class), HttpStatus.OK);

    }

    @GetMapping("/Search/{name}")
    public Object SearchMovie(@PathVariable String name) {
        RestTemplate a = new RestTemplate();
        StringBuilder temp = new StringBuilder(api + "/search/movie?query=");
        String[] tmp = name.split(" ");
        if (tmp.length == 1)
            temp.append(name);
        else {
            temp.append(tmp[0]);
            for (int i = 1; i < tmp.length; i++) {
                temp.append("%20" + tmp[i]);
            }
        }

        return a.getForObject(temp + "&api_key=0de24e1a81e3ae1e5197ac83ef9fd46f", Object.class);

    }

    @GetMapping("/{id}")
    public Object GetFilmById(@PathVariable int id) {

        return a.getForObject(api + "/movie/" + id + api_key, Object.class);
    }

    @GetMapping("/popular")
    public Object getPopular() {

        String temp = api+("/movie/popular")+(api_key);
        System.out.println(temp);
        return a.getForObject(temp, Object.class);


    }

    @GetMapping("/DB/User")
    public void hello() {
        System.out.println("Hello World.");
    }

    @GetMapping("/Actor/{id}")
    public ResponseEntity<Object> getActorById(@PathVariable int id) {
        String temp = api+"/person/"+id+api_key;
        return new ResponseEntity<Object>(a.getForObject(temp,Object.class),HttpStatus.OK);
    }
    @GetMapping("/Actor/popular")
    public ResponseEntity<Object> getActorPopular(){
        String temp = api + "/trending/person/week" + api_key;
        return new ResponseEntity<Object>(a.getForObject(temp,Object.class),HttpStatus.OK);
    }
    @GetMapping("/Cast/{movie_id}")
    public ResponseEntity<Object> getCast(@PathVariable int movie_id){
        return new ResponseEntity<>(a.getForObject(api+"/movie/"+movie_id+"/credits"+api_key,Object.class)
        ,HttpStatus.OK);
    }



}