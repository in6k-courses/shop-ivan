package com.shopApp.discounts;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CouponDiscountTest {

    private static final int DISCOUNT_VALUE = 10;

    @Test
    public void testFixedDiscountCalculation() {
        Discount fixedDiscount = new CouponDiscount();
        BigDecimal discount = new BigDecimal(DISCOUNT_VALUE);

        BigDecimal[] moneyValues = {new BigDecimal(100), new BigDecimal(500), new BigDecimal(1000)};

        for (int i = 0; i < moneyValues.length; i++) {
            assertThat(fixedDiscount.calculateDiscount(moneyValues[i]), is(discount));
        }
    }
}
