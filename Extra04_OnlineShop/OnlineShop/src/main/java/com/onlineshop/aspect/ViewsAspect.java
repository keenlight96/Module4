package com.onlineshop.aspect;

import com.onlineshop.model.Product;
import com.onlineshop.service.ProductService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ViewsAspect {
    @Autowired
    ProductService productService;
    @AfterReturning(value = "execution(* com.onlineshop.controller.ProductController.toProductDetail(..)) && args(product,..)")
    public void afterExecuteToProductDetail(Product product) {
        productService.increaseViews(product);
    }
}
