package com.onlineshop.repository;

import com.onlineshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
