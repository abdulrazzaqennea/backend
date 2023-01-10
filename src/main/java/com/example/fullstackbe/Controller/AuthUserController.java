package com.example.fullstackbe.Controller;

import com.example.fullstackbe.Model.AuthUser;
import com.example.fullstackbe.Model.User;
import com.example.fullstackbe.Services.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AuthUserController {
    @Autowired
    private AuthUserService authUserService;
    @GetMapping("/authuser")
    public List<AuthUser> getAuthUsers(){
        return this.authUserService.getAuthUsers();
    }
//
//    @GetMapping("/authuser/{id}")
//    public Optional<AuthUser> getAuthUser(@PathVariable String id){
//        return this.authUserService.getAuthUser(Long.parseLong(id));
//    }
    @PostMapping("/authuser")
    public void addAuthUser(@RequestBody AuthUser authUser){
        this.authUserService.addAuthUser(authUser);
    }

    @DeleteMapping("/authuser/{id}")
    public void deleteAuthUser(@PathVariable String id){
        this.authUserService.deleteAuthUser(Long.parseLong(id));
    }
}
