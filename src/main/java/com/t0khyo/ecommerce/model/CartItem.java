package com.t0khyo.ecommerce.model;

public class CartItem {
    private final Product product;
    private int quantity;

    // Constructor, Setters & Getters
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
