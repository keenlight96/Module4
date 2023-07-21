package com.onlineshop.service;

import com.onlineshop.model.Comment;
import com.onlineshop.model.Product;
import com.onlineshop.model.User;
import com.onlineshop.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    ICommentRepository iCommentRepository;

    public List<Comment> findAllByProduct(Product product) {
        return iCommentRepository.findAllByProduct(product);
    }

    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

}
