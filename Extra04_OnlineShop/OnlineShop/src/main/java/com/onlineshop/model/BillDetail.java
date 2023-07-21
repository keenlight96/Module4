package com.onlineshop.model;

import javax.persistence.*;

@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Bill bill;
    @ManyToOne
    private Product product;
    private int quantity;

    public BillDetail() {
    }

    public BillDetail(int id, Bill bill, Product product, int quantity) {
        this.id = id;
        this.bill = bill;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
