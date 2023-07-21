package com.onlineshop.repository;

import com.onlineshop.model.Bill;
import com.onlineshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, Integer> {
    public Bill findByUserAndStatus(User user, int status);
}
