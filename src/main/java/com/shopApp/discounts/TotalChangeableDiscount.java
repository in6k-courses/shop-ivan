package com.shopApp.discounts;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public class TotalChangeableDiscount implements Discount {

    private final int SMALL_AMOUNT_OF_MONEY = 300;
    private final int MIDDLE_AMOUNT_OF_MONEY = 600;
    private final int BIG_AMOUNT_OF_MONAY = 1000;

    private final int SMALL_DISCOUNT_PERCENT = 3;
    private final int MIDDLE_DISCOUNT_PERCENT = 5;
    private final int BIG_DISCOUNT_PERCENT = 7;

    private int discountPercent;

    public TotalChangeableDiscount() {
        discountPercent = SMALL_DISCOUNT_PERCENT;
    }

    public BigDecimal calculateDiscount(BigDecimal price) {
        discountPercent = getDiscountPercent(price);
        BigDecimal percent = new BigDecimal(discountPercent);
        BigDecimal oneHundredPercent = new BigDecimal(ONE_HUNDRED_PERCENT);
        BigDecimal discount = (price.multiply(percent)).divide(oneHundredPercent);
        return discount;
    }

    private int getDiscountPercent(BigDecimal price) {
        if (isSmallMoney(price)) return SMALL_DISCOUNT_PERCENT;
        if (isMiddleMoney(price)) return MIDDLE_DISCOUNT_PERCENT;
        return BIG_DISCOUNT_PERCENT;
    }

    private boolean isSmallMoney(BigDecimal amount) {
        BigDecimal smallMoney = new BigDecimal(SMALL_AMOUNT_OF_MONEY);
        boolean isSmallAmount = (amount.compareTo(smallMoney) > 0) ? false : true;
        return isSmallAmount;
    }

    private boolean isMiddleMoney(BigDecimal amount) {
        BigDecimal middleMoney = new BigDecimal(MIDDLE_AMOUNT_OF_MONEY);
        boolean isMiddleAmount = (amount.compareTo(middleMoney) > 0) ? false : true;
        return isMiddleAmount;
    }
}
