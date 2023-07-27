package com.example.accountmanagement.controller;

import com.example.accountmanagement.model.Account;
import com.example.accountmanagement.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    HttpSession session;
    @Autowired
    IAccountService iAccountService;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        Account account1 = iAccountService.create(account);
        if (account1 != null)
            return new ResponseEntity<>(account1, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAll() {
        return new ResponseEntity<>(iAccountService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account) {
        Account account1 = iAccountService.checkLogin(account.getUsername(), account.getPassword());
        if (account1 != null) {
            session.setAttribute("currentAccount", account1);
            return new ResponseEntity<>(account1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<Account> edit(@RequestBody Account account) {
        Account account1 = iAccountService.edit(account);
        return new ResponseEntity<>(account1, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Account> delete(@RequestBody Account account) {
        iAccountService.delete(account);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public void logout() {
        session.setAttribute("currentAccount", null);
    }

}
