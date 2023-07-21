package com.onlineshop.repository;

import com.onlineshop.model.Comment;
import com.onlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "select c from Comment c where c.id = :id")
    public Comment findById(@Param("id") int id);

    List<Comment> findAllByProduct(Product product);
}
