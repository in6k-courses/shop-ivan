package com.shopApp.discounts;

import java.math.BigDecimal;

public class CouponDiscount implements Discount {

    private static BigDecimal discountAmount;

    public CouponDiscount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal calculateDiscount(BigDecimal price) {
        return discountAmount;
    }
}
