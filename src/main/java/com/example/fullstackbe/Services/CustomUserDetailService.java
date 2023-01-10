package com.example.fullstackbe.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(userName.equals("Razzaq")) {
            return new User("Razzaq", "abdul", new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User Not Found !!");
        }
    }
}
