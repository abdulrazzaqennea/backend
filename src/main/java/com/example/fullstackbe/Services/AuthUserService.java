package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.AuthUser;

import java.util.List;
import java.util.Optional;

public interface AuthUserService {
    public List<AuthUser> getAuthUsers();
//
//    public Optional<AuthUser> getAuthUser(long id);
      public void addAuthUser(AuthUser authUser);

      public void deleteAuthUser(long id);
}
