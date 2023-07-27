package com.example.accountmanagement.service.impl;

import com.example.accountmanagement.model.Account;
import com.example.accountmanagement.repository.IAccountRepository;
import com.example.accountmanagement.repository.IRoleRepository;
import com.example.accountmanagement.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository iAccountRepository;
    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public List<Account> getAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Account getById(int id) {
        if (iAccountRepository.findById(id).isPresent())
            return iAccountRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public Account create(Account account) {
        account.setRole(iRoleRepository.findByName("User"));
        if (iAccountRepository.findByUsername(account.getUsername()) == null)
            return iAccountRepository.save(account);
        else
            return null;
    }

    @Override
    public Account edit(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        iAccountRepository.deleteById(account.getId());
    }

    @Override
    public Account checkLogin(String username, String password) {
        return iAccountRepository.findByUsernameAndPassword(username, password);
    }

}
