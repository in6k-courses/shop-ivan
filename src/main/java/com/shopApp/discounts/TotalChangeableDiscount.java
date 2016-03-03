package com.shopApp.discounts;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public class TotalChangeableDiscount implements Discount {

    private final int SMALL_DISCOUNT = 3;
    private final int MIDDLE_DISCOUNT = 5;
    private final int BIG_DISCOUNT = 7;

    private int discountPercentage;

    public TotalChangeableDiscount() {
        discountPercentage = SMALL_DISCOUNT;
    }

    public BigDecimal calculateDiscount(BigDecimal price) {
        discountPercentage = calculateDiscountSize(price);
        BigDecimal discount = (price.multiply(new BigDecimal(discountPercentage))).divide(new BigDecimal(100));
        return discount;
    }

    private int calculateDiscountSize(BigDecimal price) {
        if (price.compareTo(new BigDecimal(300)) == -1) return SMALL_DISCOUNT;
        if (price.compareTo(new BigDecimal(600)) == -1) return MIDDLE_DISCOUNT;
        return BIG_DISCOUNT;
    }
}
