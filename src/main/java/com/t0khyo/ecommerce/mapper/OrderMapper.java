package com.t0khyo.ecommerce.mapper;

import com.t0khyo.ecommerce.model.CartItem;
import com.t0khyo.ecommerce.model.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public OrderItem toOrderItem(CartItem cartItem) {
        return new OrderItem()
                .setProduct(cartItem.getProduct())
                .setQuantity(cartItem.getQuantity());
    }

    public List<OrderItem> toOrderItems(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(this::toOrderItem)
                .collect(Collectors.toList());
    }
}
