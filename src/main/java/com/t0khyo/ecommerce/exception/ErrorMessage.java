package com.t0khyo.ecommerce.exception;

public enum ErrorMessage {
    CART_EMPTY("Cart is empty."),
    INSUFFICIENT_BALANCE("Customer's balance is insufficient."),
    PRODUCT_EXPIRED("Product is expired."),
    PRODUCT_OUT_OF_STOCK("Product is out of stock."),
    INVALID_QUANTITY("Requested quantity exceeds available stock."),
    INVALID_WEIGHT("Product does not provide weight."),
    BALANCE_MUST_BE_POSITIVE("Balance must be positive or zero"),
    ORDER_ITEM_QUANTITY_MUST_BE_POSITIVE("Order item quantity must be positive or zero"),
    WEIGHT_MUST_BE_POSITIVE("Weight must be positive");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
