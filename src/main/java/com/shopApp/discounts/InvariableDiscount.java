package com.shopApp.discounts;

import org.hamcrest.Matcher;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public class InvariableDiscount implements Discount {

    private static final int DISCOUNT_VALUE = 10;

    public BigDecimal calculateDiscount(BigDecimal price) {
        return new BigDecimal(DISCOUNT_VALUE);
    }
}
