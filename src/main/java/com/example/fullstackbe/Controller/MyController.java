package com.example.fullstackbe.Controller;

import com.example.fullstackbe.Model.User;
import com.example.fullstackbe.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class MyController {

    @Autowired
    private UserService userService;
    @GetMapping("/Login")
    public String home(){
        return "Welcome to Login Page";
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id){
        return this.userService.getUser(Long.parseLong(id));
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id){
        this.userService.deleteUser(Long.parseLong(id));
    }

//    @GetMapping("/user/{business}/{password}")
//    public Optional<User> getUserByNameAndPassword(@PathVariable String business,@PathVariable String password){
//        return this.userService.getUserData(business,password);
//    }

}
