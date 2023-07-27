package com.example.accountmanagement.service;

import com.example.accountmanagement.model.Role;
import org.springframework.stereotype.Service;

public interface IRoleService {
    Role getById(int id);
}
