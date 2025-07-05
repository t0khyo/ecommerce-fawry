package com.t0khyo.ecommerce.policy.expiration;

public class NoExpiration implements ExpirationPolicy {
    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isExpirable() {
        return false;
    }
}
