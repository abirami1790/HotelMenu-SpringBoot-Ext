package com.tw.hotelmenu.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;

    private double price;
    private int quantity;
    private double totalPrice;

    private Long menuId;
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }


    public Cart(String name, double price) {
        this.Name = name;
        this.price = price;
    }

    public Cart() {

    }

    public Cart(long i, String name, double price,int quantity,double totalPrice,long menuId) {
        this.id = i;
        this.Name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.menuId= menuId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice1) {
        this.totalPrice = totalPrice;
    }

    public double calculateItemQuantity() {
        return quantity;
    }

    public double calculateItemPrice() {
        return 0.0;
    }

    public double calculateTotalPrice() {
        return 0.0;
    }
}
