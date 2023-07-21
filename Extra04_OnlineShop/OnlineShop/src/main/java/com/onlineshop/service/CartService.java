package com.onlineshop.service;

import com.onlineshop.model.Bill;
import com.onlineshop.model.BillDetail;
import com.onlineshop.model.Cart;
import com.onlineshop.repository.IBillDetailRepository;
import com.onlineshop.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    IBillDetailRepository iBillDetailRepository;
    @Autowired
    IBillRepository iBillRepository;

    public Cart getCart(Bill bill) {
        Cart cart = new Cart();
        List<BillDetail> billDetails = iBillDetailRepository.findByBillId(bill.getId());
        bill = iBillRepository.findById(bill.getId()).get();
        cart.setBill(bill);
        cart.setBillDetails(billDetails);
        return cart;
    }

}
