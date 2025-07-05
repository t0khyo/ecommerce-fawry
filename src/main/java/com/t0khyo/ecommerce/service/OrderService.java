package com.t0khyo.ecommerce.service;

import com.t0khyo.ecommerce.model.Cart;
import com.t0khyo.ecommerce.model.Customer;
import com.t0khyo.ecommerce.model.Order;

public interface OrderService {
    Order checkout(Customer customer, Cart cart);
}
