package com.t0khyo.ecommerce.service;

import com.t0khyo.ecommerce.model.CartItem;

import java.util.List;

public interface ShippingService {
    /**
     * 1. Calculates the total package weight of shippable items in the cart.
     * 2. Print shipping notice>
     *
     * @return total weight in grams, or 0 if no shippable items
     */
    double calculateShipping(List<CartItem> cartItems);
}
