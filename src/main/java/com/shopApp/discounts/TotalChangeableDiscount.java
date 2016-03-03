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

    public int calculateDiscount(BigDecimal price) {
        discountPercentage = calculateDiscountSize(price);
        int discount = (price * discountPercentage) / 100;
        return discount;
    }

    private int calculateDiscountSize(BigDecimal price) {
        if (price < 300) return SMALL_DISCOUNT;
        if (price < 600) return MIDDLE_DISCOUNT;
        return BIG_DISCOUNT;
    }
}
