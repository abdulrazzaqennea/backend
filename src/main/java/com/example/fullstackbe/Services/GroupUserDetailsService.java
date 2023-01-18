package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.Users;
import com.example.fullstackbe.Repository.UserRepository;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@Service
public class GroupUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = repository.findByBusiness(username);

        return user.map(GroupUserDetails::new).orElseThrow(()->new UsernameNotFoundException(username+" doesn't exist in system"));
    }
}
