package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.AuthUser;
import com.example.fullstackbe.Repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService{
    @Autowired
    private AuthUserRepository authUserRepository;
    @Override
    public List<AuthUser> getAuthUsers(){
        return authUserRepository.findAll();
    };
//
//    public Optional<AuthUser> getAuthUser(long id){
//        return authUserRepository.findById(id);
//    };
    @Override
    public void addAuthUser(AuthUser authUser){
        authUserRepository.save(authUser);
    }

    @Override
    public void deleteAuthUser(long id){
        AuthUser u=authUserRepository.getOne(id);
        authUserRepository.delete(u);
    }

}
