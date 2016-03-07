package com.shopApp.discounts;

import org.hamcrest.Matcher;

import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
public class NullDiscount implements Discount {

    public BigDecimal calculateDiscount(BigDecimal price) {
        return new BigDecimal(0);
    }
}
