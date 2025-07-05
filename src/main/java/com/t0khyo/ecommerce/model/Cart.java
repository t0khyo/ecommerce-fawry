package com.t0khyo.ecommerce.model;

import com.t0khyo.ecommerce.exception.ProductOutOFStockException;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new ProductOutOFStockException();
        }

        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void empty() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
