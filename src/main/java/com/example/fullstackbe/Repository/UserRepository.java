package com.example.fullstackbe.Repository;

import com.example.fullstackbe.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u from Users u where u.block=:block and u.auth=:auth")
    public List<Users> getNewUsers(@Param("block") boolean block, @Param("auth") boolean auth);

    @Query("SELECT u from Users u where u.block=:block and u.auth=:auth")
    public List<Users> getAuthUsers(@Param("block") boolean block, @Param("auth") boolean auth);

    @Query("SELECT u from Users u where u.block=:block and u.auth=:auth")
    public List<Users> getBlockedUsers(@Param("block") boolean block, @Param("auth") boolean auth);

    @Transactional
    @Modifying
    @Query("UPDATE Users u SET u.block=:block,u.auth=:auth where u.id=:id")
    public void blockUser(@Param("block") boolean block,@Param("auth") boolean auth,@Param("id") long id);

    @Transactional
    @Modifying
    @Query("UPDATE Users u SET u.auth=:auth,u.block=:block where u.id=:id")
    public void unBlockUser(@Param("auth") boolean auth,@Param("block") boolean block,@Param("id") long id);

    Optional<Users> findByBusiness(String business);
}
