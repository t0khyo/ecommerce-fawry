package com.t0khyo.ecommerce.service.impl;

import com.t0khyo.ecommerce.model.CartItem;
import com.t0khyo.ecommerce.model.Product;
import com.t0khyo.ecommerce.service.ShippingService;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {

    @Override
    public double calculateShipping(List<CartItem> cartItems) {
        double totalWeight = 0;

        System.out.println("\n- * Shipment notice **\n");

        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            if (product.isShippable()) {
                double itemWeight = product.getWeight() * item.getQuantity();
                totalWeight += itemWeight;

                String line = String.format("%dx %-15s %.0fg", item.getQuantity(), product.getName(), itemWeight);
                System.out.println(line);
            }
        }

        if (totalWeight > 0) {
            String summary = String.format("%nTotal package weight %.1fkg", totalWeight / 1000.0);
            System.out.println(summary);
        }

        return totalWeight;
    }
}
