package com.shopApp.discounts;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 3/3/16.
 */
public class TotalChangeableDiscountTest {

    @Test
    public void testcalculateDiscount() {
        Discount discount = new TotalChangeableDiscount();
        assertThat(discount.calculateDiscount(new BigDecimal(1000)), is(new BigDecimal(70)));
    }


}
