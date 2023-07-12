package com.example.task02_id8915.service;

import com.example.task02_id8915.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1, "Apple", 5, "USA"));
        products.add(new Product(2, "Pear", 7, "USA"));
        products.add(new Product(3, "Watermelon", 14.6, "VN"));
        products.add(new Product(4, "Lemon", 3.2, "VN"));
    }

    public int getIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        int index = getIndexById(id);
        return products.get(index);
    }

    public void addProduct(Product product) {
        product.setId(getNewId());
        products.add(product);
    }

    public void removeProductById(int id) {
        int index = getIndexById(id);
        products.remove(index);
    }

    public void editProduct(Product product) {
        int index = getIndexById(product.getId());
        products.set(index, product);
    }

    public int getNewId() {
        int max = products.get(0).getId();
        for (int i = 1; i < products.size(); i++) {
            if (products.get(i).getId() > max)
                max = products.get(i).getId();
        }
        return max + 1;
    }
}
