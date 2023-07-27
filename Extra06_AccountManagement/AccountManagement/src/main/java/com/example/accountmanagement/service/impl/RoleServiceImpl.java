package com.example.accountmanagement.service.impl;

import com.example.accountmanagement.model.Role;
import com.example.accountmanagement.repository.IRoleRepository;
import com.example.accountmanagement.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public Role getById(int id) {
        if (iRoleRepository.findById(id).isPresent())
            return iRoleRepository.findById(id).get();
        else
            return null;
    }
}
