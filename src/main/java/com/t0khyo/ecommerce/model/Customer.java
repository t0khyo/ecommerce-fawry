package com.t0khyo.ecommerce.model;

import com.t0khyo.ecommerce.exception.ErrorMessage;
import com.t0khyo.ecommerce.exception.InsufficientBalanceException;

import java.math.BigDecimal;

public class Customer {
    private final Cart cart = new Cart();
    private String name;
    private BigDecimal balance;

    public void pay(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }

        balance = balance.subtract(amount);
    }

    // Constructor, Setters & Getters
    public Customer(String name, BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(ErrorMessage.BALANCE_MUST_BE_POSITIVE.get());
        }

        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
