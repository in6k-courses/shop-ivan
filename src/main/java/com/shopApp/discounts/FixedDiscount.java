package com.shopApp.discounts;

/**
 * Created by employee on 3/3/16.
 */
public class FixedDiscount implements Discount {

    private int DISCOUNT_VALUE = 10;

    public int calculateDiscount(int price) {
        return DISCOUNT_VALUE;
    }
}
