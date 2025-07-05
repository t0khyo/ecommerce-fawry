package com.t0khyo.ecommerce.policy.expiration;

public interface ExpirationPolicy {
    boolean isExpired();

    boolean isExpirable();
}
