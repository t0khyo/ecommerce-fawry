package com.t0khyo.ecommerce.policy.shipping;

public interface ShippingPolicy {
    boolean isShippable();

    double getWeight();
}
