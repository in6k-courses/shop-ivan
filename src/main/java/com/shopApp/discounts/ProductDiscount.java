package com.shopApp.discounts;

import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
public class ProductDiscount implements Discount {

    private static final int DISCOUNT_PERCENT = 50;

    public BigDecimal calculateDiscount(BigDecimal price) {
        BigDecimal percent = new BigDecimal(DISCOUNT_PERCENT);
        BigDecimal oneHundredPercent = new BigDecimal(ONE_HUNDRED_PERCENT);
        BigDecimal discount = (price.multiply(percent)).divide(oneHundredPercent);
        return discount;
    }
}
