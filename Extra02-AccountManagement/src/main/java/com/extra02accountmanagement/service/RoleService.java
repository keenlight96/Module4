package com.extra02accountmanagement.service;

import com.extra02accountmanagement.dao.RoleDAO;
import com.extra02accountmanagement.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDAO roleDAO;

    public Role getRoleByName(String name) {
        List<Role> roles = roleDAO.getRoles();
        for (Role role :
                roles) {
            if (role.getName().equals(name))
                return role;
        }
        return null;
    }
}
