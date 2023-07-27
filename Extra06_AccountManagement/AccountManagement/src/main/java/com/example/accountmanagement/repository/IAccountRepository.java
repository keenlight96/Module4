package com.example.accountmanagement.repository;

import com.example.accountmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsernameAndPassword(String username, String password);
    Account findByUsername(String username);
}
