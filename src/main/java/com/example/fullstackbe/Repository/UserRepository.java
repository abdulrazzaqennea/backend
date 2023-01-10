package com.example.fullstackbe.Repository;

import com.example.fullstackbe.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select * from user where business=?1 and password=?2")
//    public Optional<User> getUserByNameAndPassword(String business, String password);
}
