package com.t0khyo.ecommerce.model;

import com.t0khyo.ecommerce.policy.expiration.ExpirationPolicy;
import com.t0khyo.ecommerce.policy.shipping.ShippingPolicy;

public class Product {
    private String name;
    private double price;
    private ExpirationPolicy expirationPolicy;
    private ShippingPolicy shippingPolicy;
    private int quantity;

    public void decreaseQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("No enough stock");
        }

        quantity -= amount;
    }

    // Constructor, Setters & Getters
    public Product(String name, double price, int quantity, ExpirationPolicy expirationPolicy, ShippingPolicy shippingPolicy) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationPolicy = expirationPolicy;
        this.shippingPolicy = shippingPolicy;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public boolean isExpired() {
        return expirationPolicy.isExpired();
    }

    public boolean isShippable() {
        return shippingPolicy.isShippable();
    }

    public double getWeight() {
        return shippingPolicy.getWeight();
    }

    public ExpirationPolicy getExpirationPolicy() {
        return expirationPolicy;
    }

    public Product setExpirationPolicy(ExpirationPolicy expirationPolicy) {
        this.expirationPolicy = expirationPolicy;
        return this;
    }

    public ShippingPolicy getShippingPolicy() {
        return shippingPolicy;
    }

    public Product setShippingPolicy(ShippingPolicy shippingPolicy) {
        this.shippingPolicy = shippingPolicy;
        return this;
    }
}
