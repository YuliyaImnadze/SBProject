package com.example.sb.repository;

import com.example.sb.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {
    Optional<User> findByLogin(String login);



}