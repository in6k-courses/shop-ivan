package com.shopApp.discounts;

import java.math.BigDecimal;

public class CouponDiscount implements Discount {

    private static int discountAmount;

    public CouponDiscount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal calculateDiscount(BigDecimal price) {
        return new BigDecimal(discountAmount);
    }
}
