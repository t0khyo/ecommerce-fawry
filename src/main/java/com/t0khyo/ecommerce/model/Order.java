package com.t0khyo.ecommerce.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private BigDecimal subtotal;
    private BigDecimal shippingFees;
    private BigDecimal total;
    private double packageWeight;

    public void addItem(OrderItem item) {
        item.getProduct().decreaseQuantity(item.getQuantity());
        items.add(item);
    }

    // Constructor, Setters & Getters
    public Order setItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    public Order setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public Order setShippingFees(BigDecimal shippingFees) {
        this.shippingFees = shippingFees;
        return this;
    }

    public Order setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public Order setPackageWeight(double packageWeight) {
        this.packageWeight = packageWeight;
        return this;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getShippingFees() {
        return shippingFees;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public double getPackageWeight() {
        return packageWeight;
    }
}
