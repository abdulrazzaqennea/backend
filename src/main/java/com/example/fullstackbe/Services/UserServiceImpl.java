package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.Users;
import com.example.fullstackbe.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUser(long id){
        return userRepository.findById(id);
    }

    @Override
    public Users addUser(Users user){
        userRepository.save(user);
        return user;
    }

    @Override
    public Users updateUser(Users user){
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(long id){
        Users u=userRepository.getOne(id);
        userRepository.delete(u);
    }

    @Override
    public List<Users> getNewUsers(boolean block, boolean auth){
        return userRepository.getNewUsers(block,auth);
    }

    @Override
    public List<Users> getAuthUsers(boolean block, boolean auth){
        return userRepository.getAuthUsers(block,!auth);
    }

    @Override
    public List<Users> getBlockedUsers(boolean block, boolean auth){
        return userRepository.getBlockedUsers(!block,auth);
    }

    @Override
    public void blockUser(boolean block,boolean auth,long id){
        userRepository.blockUser(!block,auth,id);
    }
    @Override
    public void unBlockUser(boolean auth,boolean block,long id){
        userRepository.unBlockUser(!auth,block,id);
    }
}
