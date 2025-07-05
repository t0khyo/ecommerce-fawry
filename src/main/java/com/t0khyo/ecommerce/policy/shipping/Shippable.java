package com.t0khyo.ecommerce.policy.shipping;

import com.t0khyo.ecommerce.exception.ErrorMessage;

public class Shippable implements ShippingPolicy {

    private double weight;

    public Shippable(double weight) {
        if (weight <= 0) throw new IllegalArgumentException(ErrorMessage.WEIGHT_MUST_BE_POSITIVE.get());
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
