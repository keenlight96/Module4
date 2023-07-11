package com.extra02studentmanagement.service;

import com.extra02studentmanagement.model.Account;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    List<Account> accounts;

    public AccountService() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1, "tot", "0987654321", "https://upload.wikimedia.org/wikipedia/en/0/04/Hollow_Knight_first_cover_art.webp", "1999-03-03"));
        accounts.add(new Account(2, "long", "018395351", "https://www.google.com/logos/doodles/2023/algeria-national-day-2023-6753651837109899-2xa.gif", "1999-03-03"));
        accounts.add(new Account(3, "huong", "048395911", "https://www.google.com/logos/doodles/2023/celebrating-martin-dibobe-6753651837110054-2x.png", "1999-03-03"));
    }

    public int getIndexById(int id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountById(int id) {
        int index = getIndexById(id);
        return accounts.get(index);
    }

    public void addAccount(Account account) {
        account.setId(getNewId());
        accounts.add(account);
    }

    public void removeAccountById(int id) {
        int index = getIndexById(id);
        accounts.remove(index);
    }

    public void editAccount(Account account) {
        int index = getIndexById(account.getId());
        accounts.set(index, account);
    }

    public int getNewId() {
        int max = accounts.get(0).getId();
        for (int i = 1; i < accounts.size(); i++) {
            if (accounts.get(i).getId() > max)
                max = accounts.get(i).getId();
        }
        return max + 1;
    }

    public LocalDate getBirthday(String birthday) {
        return LocalDate.parse(birthday);
    }
}
