package com.shopApp.discounts;

import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
public enum NoDiscount implements Discount {
    NoDiscount;

    public BigDecimal calculateDiscount(BigDecimal price) {
        return BigDecimal.ZERO;
    }
}
