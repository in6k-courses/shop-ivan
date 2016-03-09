package com.shopApp.discounts;

import java.math.BigDecimal;

public class TotalCostBasedDiscount implements Discount {

    private final int SMALL_MONEY_AMOUNT_BORDER = 300;
    private final int MIDDLE_MONEY_AMOUNT_BORDER = 600;

    private final int ZERO_DISCOUNT_PERCENT = 0;
    private final int SMALL_DISCOUNT_PERCENT = 3;
    private final int MIDDLE_DISCOUNT_PERCENT = 5;
    private final int BIG_DISCOUNT_PERCENT = 7;

    private int discountPercent;

    public TotalCostBasedDiscount() {
        discountPercent = ZERO_DISCOUNT_PERCENT;
    }

    public BigDecimal calculateDiscount(BigDecimal cost) {
        discountPercent = getDiscountPercent(cost);
        BigDecimal percent = new BigDecimal(discountPercent);
        BigDecimal oneHundredPercent = new BigDecimal(HUNDRED_PERCENT);
        BigDecimal discount = (cost.multiply(percent)).divide(oneHundredPercent);
        return discount;
    }

    private int getDiscountPercent(BigDecimal cost) {
        if (lessThanBorder(cost, 0)) return ZERO_DISCOUNT_PERCENT;
        if (lessThanBorder(cost, SMALL_MONEY_AMOUNT_BORDER)) return SMALL_DISCOUNT_PERCENT;
        if (lessThanBorder(cost, MIDDLE_MONEY_AMOUNT_BORDER)) return MIDDLE_DISCOUNT_PERCENT;
        return BIG_DISCOUNT_PERCENT;
    }


    private boolean lessThanBorder(BigDecimal cost, int border) {
        BigDecimal borderOfMoney = new BigDecimal(border);
        if (cost.compareTo(borderOfMoney) <= 0) {
            return true;
        }
        return false;
    }

}
