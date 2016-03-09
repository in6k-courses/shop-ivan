package com.shopApp.discounts;


import java.math.BigDecimal;

public class ProductDiscount implements Discount {

    private BigDecimal discountPercent;

    public ProductDiscount(int percent) {
        this.discountPercent = new BigDecimal(percent);
    }

    public BigDecimal calculateDiscount(BigDecimal price) {
        BigDecimal oneHundredPercent = new BigDecimal(HUNDRED_PERCENT);
        BigDecimal discount = (price.multiply(discountPercent)).divide(oneHundredPercent);
        return discount;
    }
}
