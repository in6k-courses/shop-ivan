package com.shopApp.discounts;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public class FixedDiscount implements Discount {

    private int DISCOUNT_VALUE = 10;

    public BigDecimal calculateDiscount(BigDecimal price) {
        return new BigDecimal(DISCOUNT_VALUE);
    }
}
