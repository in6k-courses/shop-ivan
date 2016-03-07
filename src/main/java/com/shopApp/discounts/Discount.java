package com.shopApp.discounts;

import org.hamcrest.Matcher;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public interface Discount {

    int ONE_HUNDRED_PERCENT = 100;

    BigDecimal calculateDiscount(BigDecimal price);
}
