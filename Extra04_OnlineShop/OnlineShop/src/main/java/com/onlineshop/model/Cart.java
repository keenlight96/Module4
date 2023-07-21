package com.onlineshop.model;

import java.util.List;

public class Cart {
    private int id;
    private Bill bill;
    private List<BillDetail> billDetails;

    public Cart() {
    }

    public Cart(int id, Bill bill, List<BillDetail> billDetails) {
        this.id = id;
        this.bill = bill;
        this.billDetails = billDetails;
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

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}
