package com.t0khyo.ecommerce.service.impl;

import com.t0khyo.ecommerce.exception.CartEmptyException;
import com.t0khyo.ecommerce.mapper.OrderMapper;
import com.t0khyo.ecommerce.model.*;
import com.t0khyo.ecommerce.service.OrderService;
import com.t0khyo.ecommerce.service.ShippingService;
import com.t0khyo.ecommerce.util.OrderUtils;

import java.math.BigDecimal;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderUtils orderUtils = new OrderUtils();
    private final OrderMapper orderMapper = new OrderMapper();
    private final ShippingService shippingService = new ShippingServiceImpl();

    @Override
    public Order checkout(Customer customer, Cart cart) {
        // 1. validate cart items
        if (cart.isEmpty()) {
            throw new CartEmptyException();
        }

        final List<CartItem> cartItems = cart.getItems();
        orderUtils.validateCartItems(cartItems);

        // 2. calculate shipping
        double shippingPackageWeight = shippingService.calculateShipping(cartItems);

        // 3. order summary
        final BigDecimal subtotal = orderUtils.calculateSubtotal(cartItems);
        final BigDecimal shippingFee = orderUtils.calculateShippingFee(shippingPackageWeight);
        final BigDecimal total = orderUtils.calculateTotal(subtotal, shippingFee);

        // 4. validate customer balance
        orderUtils.validateCustomerBalance(total, customer);

        // 5. place order, update product stock, update customer balance
        List<OrderItem> orderItems = orderMapper.toOrderItems(cart.getItems());
        customer.pay(total);

        Order order = new Order()
                .setItems(orderItems)
                .setPackageWeight(shippingPackageWeight)
                .setSubtotal(subtotal)
                .setShippingFees(shippingFee)
                .setTotal(total);

        // 6. print recite
        orderUtils.printOrder(order);

        // 7. empty cart
        cart.empty();

        return order;
    }

}
