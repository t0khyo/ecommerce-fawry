package com.t0khyo.ecommerce.policy.expiration;

import java.time.LocalDate;

public class Expirable implements ExpirationPolicy {

    private final LocalDate expirationDate;

    public Expirable(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    @Override
    public boolean isExpirable() {
        return true;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
