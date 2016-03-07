package com.shopApp.discounts;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 3/3/16.
 */
public class VariableDiscountTest {

    private int ONE_HUNDRED_PERCENT = 100;
    private Discount variableDiscount;

    @Before
    public void initDiscount() {
        variableDiscount = new VariableDiscount();
    }

    @Test
    public void testDiscountSizeWithDifferentAmountOfMoney() {
        BigDecimal[] moneyValues = {new BigDecimal(100), new BigDecimal(500), new BigDecimal(600),
                new BigDecimal(1000), new BigDecimal(1200)};

        BigDecimal[] discountSize = {new BigDecimal(3), new BigDecimal(25), new BigDecimal(30), new BigDecimal(70),
                new BigDecimal(84)};

        for (int i = 0; i < discountSize.length; i++) {
            assertThat(variableDiscount.calculateDiscount(moneyValues[i]), is(discountSize[i]));
        }
    }

    @Test
    public void testSmallDiscount() {
        BigDecimal middlePercent = new BigDecimal("3");
        BigDecimal price = new BigDecimal(300);
        BigDecimal discountSize = testDiscount(middlePercent, price);

        assertThat(variableDiscount.calculateDiscount(price), is(discountSize));
    }


    @Test
    public void testMiddleDiscount() {
        BigDecimal middlePercent = new BigDecimal("5");
        BigDecimal price = new BigDecimal(500);
        BigDecimal discountSize = testDiscount(middlePercent, price);

        assertThat(variableDiscount.calculateDiscount(price), is(discountSize));
    }

    @Test
    public void testBigDiscount() {
        BigDecimal middlePercent = new BigDecimal("7");
        BigDecimal price = new BigDecimal(1000);
        BigDecimal discountSize = testDiscount(middlePercent, price);

        assertThat(variableDiscount.calculateDiscount(price), is(discountSize));
    }

    private BigDecimal testDiscount(BigDecimal percent, BigDecimal price) {
        BigDecimal oneHundred = new BigDecimal(ONE_HUNDRED_PERCENT);
        BigDecimal discountSize = (price.multiply(percent)).divide(oneHundred);
        return discountSize;
    }

    @Test
    public void testDiscountSizeWithNegativeAmountOfMoney() {
        BigDecimal negativePrice = new BigDecimal(-500);

        assertThat(variableDiscount.calculateDiscount(negativePrice), is(BigDecimal.ZERO));
    }


}
