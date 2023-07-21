package com.extra03_loginregister.service;

import com.extra03_loginregister.dao.AccountDAO;
import com.extra03_loginregister.dao.RoleDAO;
import com.extra03_loginregister.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    RoleDAO roleDAO;

    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

    public Account getAccountById(int id) {
        return accountDAO.getAccountById(id);
    }

    public void save(Account account, MultipartFile imgAvatar, int roleId) {
        String name = imgAvatar.getOriginalFilename();
        try {
            imgAvatar.transferTo(new File("G:\\My Drive\\Study\\Codegym\\Module4\\Extra03_Login-Register\\src\\main\\webapp\\images\\" + name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        account.setAvatar("/images/" + name);
        account.setRole(roleDAO.getRoleById(roleId));
        accountDAO.save(account);
    }

    public void update(Account account) {
        accountDAO.update(account);
    }

    public void remove(Account account) {
        accountDAO.remove(account);
    }

    public Account getLogin(Account account) {
        List<Account> accounts = getAccounts();
        for (Account acc :
                accounts) {
            if ((acc.getUsername().equals(account.getUsername())) && (acc.getPassword().equals(account.getPassword())))
                return acc;
        }
        return null;
    }
}
