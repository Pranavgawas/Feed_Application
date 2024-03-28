package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.User;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT count(u)>0 FROM User u WHERE u.username = :username AND u.password = :password AND u.role <> 'admin'")
    boolean validateUser(@Param("username") String username, @Param("password") String password);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.username = :username AND u.password = :password AND u.role = 'admin'")
    boolean validateAdmin(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u.id FROM User u WHERE u.username = :username")
    Long getUserIdByUsername(@Param("username") String username);
    
//    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.id = :userId AND u.role = 'admin'")
//    boolean isAdmin( int user_id, String role);


}
