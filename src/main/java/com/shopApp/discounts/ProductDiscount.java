package com.shopApp.discounts;

import org.hamcrest.Matcher;

import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
public class ProductDiscount implements Discount {

    private static final int DISCOUNT_PROCENT = 50;

    public BigDecimal calculateDiscount(BigDecimal price) {
        BigDecimal percent = new BigDecimal(DISCOUNT_PROCENT);
        BigDecimal oneHundredPercent = new BigDecimal(ONE_HUNDRED_PERCENT);
        BigDecimal discount = (price.multiply(percent)).divide(oneHundredPercent);
        return discount;
    }
}
