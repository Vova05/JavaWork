package com.example.repos;

import com.example.components.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
