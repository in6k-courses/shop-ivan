package com.shopApp.discounts;

import java.math.BigDecimal;

public enum NoDiscount implements Discount {
    NoDiscount;

    public BigDecimal calculateDiscount(BigDecimal price) {
        return BigDecimal.ZERO;
    }
}
