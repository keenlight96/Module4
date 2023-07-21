package com.onlineshop.repository;

import com.onlineshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findByUsernameAndPassword(String username, String password);
}
