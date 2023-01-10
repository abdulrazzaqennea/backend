package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.User;
import com.example.fullstackbe.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(long id){
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user){
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(long id){
        User u=userRepository.getOne(id);
        userRepository.delete(u);
    }

//    @Override
//    public Optional<User> getUserData(String business, String password){
//        return userRepository.getUserByNameAndPassword(business,password);
//    }

}
