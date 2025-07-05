package com.t0khyo.ecommerce.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super(ErrorMessage.INSUFFICIENT_BALANCE.get());
    }
}
