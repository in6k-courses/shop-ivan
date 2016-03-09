package com.shopApp;


import com.shopApp.discounts.CouponDiscount;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.NoDiscount;
import com.shopApp.discounts.TotalCostBasedDiscount;
import com.shopApp.sales.NoSale;
import com.shopApp.sales.Sale;
import com.shopApp.sales.DiscountSale;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void createShoppingCart() {
        shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, NoSale.NoSale);
        shoppingCart.addProducts(ShoppingCartFactory.getProductsSet());
    }

    @Test
    public void testFullPriceWithoutProductsList() {
        shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, NoSale.NoSale);
        assertThat(shoppingCart.getOriginalCost(), is(BigDecimal.ZERO));
    }

    @Test
    public void testDiscountAmountWithEmptyProductsList() {
        assertThat(shoppingCart.getDiscountAmount(), is(BigDecimal.ZERO));
    }

    @Test
    public void testSetDiscountPriceUsingCouponDiscount() {
        BigDecimal discountAmount = new BigDecimal(10);
        Discount discount = new CouponDiscount(discountAmount);
        shoppingCart.applyDiscount(discount);

        assertThat(shoppingCart.getDiscountAmount(), is(discountAmount));
    }

    @Test
    public void testSetDiscountSizeWithTestCostBasedDiscount() {
        Discount discount = new TotalCostBasedDiscount();
        shoppingCart.applyDiscount(discount);

        BigDecimal discountAmount = new BigDecimal("123.9");

        assertThat(shoppingCart.getDiscountAmount(), is(discountAmount));
    }

    @Test
    public void testFinalCostWithCouponDiscount() {
        BigDecimal discountAmount = new BigDecimal(10);
        Discount discount = new CouponDiscount(discountAmount);
        shoppingCart.applyDiscount(discount);

        assertThat(shoppingCart.getDiscountAmount(), is(discountAmount));
    }

    @Test
    public void testFinalCostWithSaleDiscount() {
        Sale sale = new DiscountSale(ShoppingCartFactory.getSaleProducts());
        shoppingCart.applySale(sale);

        assertThat(shoppingCart.getFinalCost(), is(new BigDecimal(1635)));
    }

}
