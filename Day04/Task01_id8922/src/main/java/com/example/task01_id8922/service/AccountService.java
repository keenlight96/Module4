package com.example.task01_id8922.service;

import com.example.task01_id8922.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    List<Account> accounts;

    public AccountService() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1, "long","123", "Long", "VN"));
        accounts.add(new Account(2, "jon","123", "Jon", "USA"));
    }

    public boolean checkAccount(Account account) {
        for (Account acc :
                accounts) {
            if ((acc.getUsername().equals(account.getUsername())) && (acc.getPassword().equals(account.getPassword())))
                return true;
        }
        return false;
    }
}
