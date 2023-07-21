package com.onlineshop.formatter;

import com.onlineshop.model.Product;
import com.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

public class ProductFormatter implements Formatter<Product> {
    ProductService productService;

    public ProductFormatter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product parse(String id, Locale locale) throws ParseException {
        Product product = productService.findById(Integer.parseInt(id));
        return product;
    }

    @Override
    public String print(Product object, Locale locale) {
        return null;
    }
}
