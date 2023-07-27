package com.onlineshop.model;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    private String content;
    private Date date;

    public Comment() {
    }

    public Comment(int id, User user, Product product, String content) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.content = content;
        date = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCurrentDate() {
        this.date = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
    }

    public String getFormatDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }
}
