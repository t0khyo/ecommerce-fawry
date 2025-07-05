package com.t0khyo.ecommerce.model;

import com.t0khyo.ecommerce.exception.ErrorMessage;

public class OrderItem {
    private Product product;
    private int quantity;

    // Constructor, Setters & Getters
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderItem() {
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderItem setProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrderItem setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ITEM_QUANTITY_MUST_BE_POSITIVE.get());
        }

        this.quantity = quantity;
        return this;
    }

}
