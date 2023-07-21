package com.onlineshop.repository;

import com.onlineshop.model.Category;
import com.onlineshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    public Product findByName (String name);
}
