package com.t0khyo.ecommerce.exception;

public class ProductExpiredException extends RuntimeException {
    public ProductExpiredException(String productName) {
        super(ErrorMessage.PRODUCT_EXPIRED.getMessage(productName));
    }
}
