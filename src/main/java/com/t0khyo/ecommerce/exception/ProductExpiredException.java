package com.t0khyo.ecommerce.exception;

public class ProductExpiredException extends RuntimeException {
    public ProductExpiredException() {
        super(ErrorMessage.PRODUCT_OUT_OF_STOCK.get());
    }
}
