package com.t0khyo.ecommerce.exception;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException() {
        super(ErrorMessage.CART_EMPTY.get());
    }
}
