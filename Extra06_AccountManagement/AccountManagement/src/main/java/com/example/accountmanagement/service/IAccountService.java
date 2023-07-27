package com.example.accountmanagement.service;

import com.example.accountmanagement.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();
    Account getById(int id);
    Account create(Account account);
    Account edit(Account account);
    void delete(Account account);
    Account checkLogin(String username, String password);
}
