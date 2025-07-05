package com.t0khyo.ecommerce.exception;

public class ProductOutOFStockException extends RuntimeException {
    public ProductOutOFStockException() {
        super(ErrorMessage.PRODUCT_OUT_OF_STOCK.get());
    }
}
