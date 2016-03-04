package com.shopApp.discounts;

import com.shopApp.ShopingCart;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 3/3/16.
 */
public class TotalChangeableDiscountTest {

    @Ignore
    @Test
    public void testCalculateDiscount() {
        Discount discount = new TotalChangeableDiscount();
        assertThat(discount.calculateDiscount(new BigDecimal(1000)), is(new BigDecimal(70)));
    }

    @Test
    public void testEndPriceWithDifferentAmountOfMoney() {
        BigDecimal[] moneyValues = {new BigDecimal(100), new BigDecimal(500), new BigDecimal(600),
                new BigDecimal(1000), new BigDecimal(1200)};

        BigDecimal[] discountSize = {new BigDecimal(3), new BigDecimal(25), new BigDecimal(30), new BigDecimal(70),
                new BigDecimal(84)};

        Discount changableDiscount = new TotalChangeableDiscount();
        for(int i = 0; i < discountSize.length; i++) {
            assertThat(changableDiscount.calculateDiscount(moneyValues[i]), is(discountSize[i]));
        }
    }


}
