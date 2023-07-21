package com.onlineshop.validate;

import com.onlineshop.model.Product;
import com.onlineshop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class ProductValidate implements Validator {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        Product product1 = iProductRepository.findByName(product.getName());

        if (product1 != null) {
            if (product.getId() != product1.getId()) {
                errors.rejectValue("name", "", "Product name existed");
            }
        }
    }
}
