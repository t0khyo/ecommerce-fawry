package com.t0khyo.ecommerce.util;

import com.t0khyo.ecommerce.exception.ErrorMessage;
import com.t0khyo.ecommerce.exception.InsufficientBalanceException;
import com.t0khyo.ecommerce.exception.ProductExpiredException;
import com.t0khyo.ecommerce.exception.ProductOutOFStockException;
import com.t0khyo.ecommerce.model.*;

import java.math.BigDecimal;
import java.util.List;

public class OrderUtils {

    private static final BigDecimal DEFAULT_SHIPPING_FEE = BigDecimal.valueOf(30);

    public OrderUtils() {
    }

    public void printOrder(Order order) {
        System.out.println("\n- * Checkout receipt **\n");

        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            double totalItemPrice = product.getPrice() * item.getQuantity();

            String line = String.format("%dx %-15s %.0f", item.getQuantity(), product.getName(), totalItemPrice);
            System.out.println(line);
        }

        System.out.println("\n- ---------------------");

        System.out.printf("Subtotal         %.0f%n", order.getSubtotal());
        System.out.printf("Shipping         %.0f%n", order.getShippingFees());
        System.out.printf("Amount           %.0f%n", order.getTotal());
    }

    public BigDecimal calculateSubtotal(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(item ->
                        BigDecimal.valueOf(item.getProduct().getPrice())
                                .multiply(BigDecimal.valueOf(item.getQuantity()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateShippingFee(double packageWeightGrams) {
        return packageWeightGrams > 0 ? DEFAULT_SHIPPING_FEE : BigDecimal.ZERO;
    }

    public BigDecimal calculateTotal(BigDecimal subtotal, BigDecimal shippingFee) {
        return subtotal.add(shippingFee);
    }

    public void validateCartItems(List<CartItem> cartItems) {
        for (CartItem item : cartItems) {
            Product product = item.getProduct();

            if (product.isExpired()) {
                throw new ProductExpiredException(product.getName());
            }

            if (item.getQuantity() > product.getQuantity()) {
                throw new ProductOutOFStockException();
            }
        }
    }

    public void validateCustomerBalance(BigDecimal total, Customer customer) {
        if (customer.getBalance().compareTo(total) < 0) {
            throw new InsufficientBalanceException();
        }
    }

}
