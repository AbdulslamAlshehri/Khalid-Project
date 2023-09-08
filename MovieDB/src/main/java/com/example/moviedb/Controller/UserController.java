package com.example.moviedb.Controller;

import com.example.moviedb.Model.User;
import com.example.moviedb.Repository.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/User")
public class UserController {


    @Autowired
    private UsersRepository Repository;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> CheckUser(@PathVariable ObjectId id){
        return  new ResponseEntity<Optional<User>>(Repository.findById(id),HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity<List<User>>(Repository.findAll(),HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{username}")
    public ResponseEntity deleteUser(@PathVariable String username){


        return new ResponseEntity(Repository.deleteUserByUsername(username),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> Update(){
        return new ResponseEntity<User>(HttpStatus.OK);
    }

@PostMapping("/add")
@ResponseBody
    public ResponseEntity<User> addUser(@RequestParam(name = "username") String username ,@RequestParam(name = "email") String email , @RequestParam(name="password") String password){

        return new ResponseEntity<User>(Repository.save(new User(username,email,password)),HttpStatus.CREATED);
}
}
