package com.t0khyo.ecommerce.policy.shipping;

public class NoShipping implements ShippingPolicy {

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0.0;
    }
}
