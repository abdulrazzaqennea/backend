package com.example.fullstackbe.Controller;

import com.example.fullstackbe.Model.Users;
import com.example.fullstackbe.Repository.UserRepository;
import com.example.fullstackbe.Services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {
    private static final String DEFAULT_ROLE = "ROLE_USER";
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/demouser")
    public void demouser(@RequestBody Users user){
        user.setRole(DEFAULT_ROLE);
        String encryptedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPwd);
        repository.save(user);
    }

    @GetMapping("/user")
    public List<Users> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUser(@PathVariable String id){
        return this.userService.getUser(Long.parseLong(id));
    }

    @PostMapping("/adduser")
    public Users addUser(@Valid @RequestBody Users user){
        logger.info("New User Registered.");
        return this.userService.addUser(user);
    }

    @PutMapping("/user")
    public Users updateUser(@RequestBody Users user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/newuser/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteUser(@PathVariable String id){
        this.userService.deleteUser(Long.parseLong(id));
    }

    @GetMapping("/newusers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Users> getNewUser(boolean block, boolean auth){
        return this.userService.getNewUsers(block,auth);
    }

    @GetMapping("/authusers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Users> getAuthUsers(boolean block, boolean auth){
        return this.userService.getAuthUsers(block,auth);
    }

    @GetMapping("/blockedusers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Users> getBlockedUsers(boolean block, boolean auth){
        return this.userService.getBlockedUsers(block,auth);
    }

    @PutMapping("/blockuser/{id}")
    public void blockUser(boolean block,boolean auth,@PathVariable long id){
        logger.info("User Blocked with id : {}",id);
        this.userService.blockUser(block,auth,id);
    }

    @PutMapping("/authenticateuser/{id}")
    public void unBlockUser(boolean auth,boolean block,@PathVariable long id){
        logger.info("User Unblocked with id : {}",id);
        this.userService.unBlockUser(auth,block,id);
    }

    @GetMapping("/authuserss")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Users> getAuthUsers(boolean block, boolean auth, Principal principal){
//        String u = getLoggedInUser(principal).getRole();
//        System.out.println(u);
        return this.userService.getAuthUsers(block,auth);
    }

//    private Users getLoggedInUser(Principal principal){
//        return repository.findByBusiness(principal.getName()).get();
//    }
}
