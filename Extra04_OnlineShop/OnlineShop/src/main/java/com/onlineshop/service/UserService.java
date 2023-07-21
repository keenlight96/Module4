package com.onlineshop.service;

import com.onlineshop.model.Bill;
import com.onlineshop.model.User;
import com.onlineshop.repository.IBillRepository;
import com.onlineshop.repository.IRoleRepository;
import com.onlineshop.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IRoleRepository iRoleRepository;
    @Autowired
    IBillRepository iBillRepository;

    public User findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    public void add(User user) {
        if (iRoleRepository.findById(1).isPresent()) {
            user.setRole(iRoleRepository.findById(1).get());
        }
        iUserRepository.save(user);

        Bill bill = new Bill();
        bill.setUser(user);
        iBillRepository.save(bill);
    }


    public User checkLogin(User user) {
        return iUserRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

}
