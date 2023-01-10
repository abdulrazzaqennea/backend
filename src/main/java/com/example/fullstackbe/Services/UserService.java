package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getUsers();

    public Optional<User> getUser(long id);

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(long id);

//    public Optional<User> getUserData(String business, String password);
}
