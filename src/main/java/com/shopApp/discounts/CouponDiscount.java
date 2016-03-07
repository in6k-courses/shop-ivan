package com.shopApp.discounts;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public class CouponDiscount implements Discount {

    private static final int DISCOUNT_VALUE = 10;
    private int discountAmount;

    public void CouponDiscount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal calculateDiscount(BigDecimal price) {
        return new BigDecimal(DISCOUNT_VALUE);
    }
}
