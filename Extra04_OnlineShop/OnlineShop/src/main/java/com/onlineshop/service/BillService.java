package com.onlineshop.service;

import com.onlineshop.model.Bill;
import com.onlineshop.model.BillDetail;
import com.onlineshop.model.Product;
import com.onlineshop.model.User;
import com.onlineshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Service
public class BillService {
    @Autowired
    IBillDetailRepository iBillDetailRepository;
    @Autowired
    IBillRepository iBillRepository;
    @Autowired
    IProductRepository iProductRepository;

    public Bill create(User user) {
        Bill bill = new Bill();
        bill.setUser(user);
        iBillRepository.save(bill);
        return bill;
    }

    public void add(Bill bill, int productId) {
        Product product = iProductRepository.findById(productId).get();
        BillDetail billDetail = new BillDetail();
        billDetail.setBill(bill);
        billDetail.setProduct(product);
        billDetail.setQuantity(1);

        iBillDetailRepository.save(billDetail);
    }

    public void add(Bill bill, Product product) {
        // Increase quantity if product is present in Bill
        List<BillDetail> billDetails = iBillDetailRepository.findByBillId(bill.getId());
        for (BillDetail bd :
                billDetails) {
            if (bd.getProduct().getId() == product.getId()) {
                bd.setQuantity(bd.getQuantity() + 1);
                iBillDetailRepository.save(bd);
                return;
            }
        }

        // Add product to bill if there is not that product in Bill
        BillDetail billDetail = new BillDetail();
        billDetail.setBill(bill);
        billDetail.setProduct(product);
        billDetail.setQuantity(1);
        iBillDetailRepository.save(billDetail);
    }

    public Bill updateBill(Bill bill, HttpServletRequest request) {
        List<BillDetail> billDetails = iBillDetailRepository.findByBillId(bill.getId());
        for (BillDetail bd :
                billDetails) {
            int newQuantity = Integer.parseInt(request.getParameter("prodQty" + String.valueOf(bd.getId())));
            bd.setQuantity(newQuantity);
            iBillDetailRepository.save(bd);
        }
        return iBillRepository.findById(bill.getId()).get();
    }

    public Bill getCurrentBillByUser(User user) {
        return iBillRepository.findByUserAndStatus(user, 0);
    }

    public void pay(Bill bill) {
        User user = bill.getUser();
        bill.setStatus(1);
        iBillRepository.save(bill);

        create(user);
    }

    public void mustHaveBill(User user) {
        if (iBillRepository.findByUserAndStatus(user, 0) == null) {
            create(user);
        }
    }
}
