package com.onlineshop.service;

import com.onlineshop.model.BillDetail;
import com.onlineshop.model.Product;
import com.onlineshop.model.User;
import com.onlineshop.repository.IBillDetailRepository;
import com.onlineshop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IBillDetailRepository iBillDetailRepository;

    public List<Product> getProducts() {
        return iProductRepository.findAll();
    }

    public Page<Product> getProducts(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    public Product findById(int id) {
        return iProductRepository.findById(id).get();
    }

    public void save(Product product) {
        iProductRepository.save(product);
    }

    public void create(Product product, MultipartFile imgFile) {
        if (!imgFile.isEmpty()) {
            String name = imgFile.getOriginalFilename();
            try {
                imgFile.transferTo(new File("G:\\My Drive\\Study\\Codegym\\Module4\\Extra04_OnlineShop\\OnlineShop\\src\\main\\webapp\\img\\product\\" + name));
                product.setImage("/img/product/" + name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        iProductRepository.save(product);
    }

    public void edit(Product product, MultipartFile imgFile) {
        if (!imgFile.isEmpty()) {
            String name = imgFile.getOriginalFilename();
            try {
                imgFile.transferTo(new File("G:\\My Drive\\Study\\Codegym\\Module4\\Extra04_OnlineShop\\OnlineShop\\src\\main\\webapp\\img\\product\\" + name));
                product.setImage("/img/product/" + name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            product.setImage(findById(product.getId()).getImage());
        }
        iProductRepository.save(product);
    }

    public void delete(Product product) {
        iProductRepository.deleteById(product.getId());
    }

    public void increaseViews(Product product) {
        product.setViews(product.getViews() + 1);
        save(product);
    }

    public boolean isBought(Product product, User user) {
        List<BillDetail> billDetails = iBillDetailRepository.findByProductIdAndUserId(product.getId(), user.getId());
        return !billDetails.isEmpty();
    }


}
