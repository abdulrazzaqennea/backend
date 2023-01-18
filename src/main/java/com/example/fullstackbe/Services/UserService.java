package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<Users> getUsers();

    public Optional<Users> getUser(long id);

    public Users addUser(Users user);

    public Users updateUser(Users user);

    public void deleteUser(long id);

    public List<Users> getNewUsers(boolean block, boolean auth);

    public List<Users> getAuthUsers(boolean block, boolean auth);

    public List<Users> getBlockedUsers(boolean block, boolean auth);

    public void blockUser(boolean block,boolean auth,long id);

    public void unBlockUser(boolean auth,boolean block,long id);
}
