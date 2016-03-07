package com.shopApp;


import com.shopApp.discounts.NoDiscount;
import com.shopApp.sales.NoSale;
import com.shopApp.sales.Sale;
import com.shopApp.sales.SaleDiscount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    private ShoppingCartFactory shoppingCartFactory;

    @Before
    public void createShoppingCart() {
        ShoppingCartFactory shoppingCartFactory = new ShoppingCartFactory();
        shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, NoSale.NoSale);
        shoppingCart.addProducts(shoppingCartFactory.getProductsSet());
    }

    @Test
    public void testFullPriceWithoutProductsList() {
        assertThat(shoppingCart.getOriginalCost(), is(BigDecimal.ZERO));
    }

    @Test
    public void testDiscountSizeWithEmptyProductsList() {
        assertThat(shoppingCart.getDiscountAmount(), is(BigDecimal.ZERO));
    }

    @Test
    public void testSetDiscountPriceUsingInvariableDiscount() {
        shoppingCart.applyDiscount();
        BigDecimal discountSize = new BigDecimal(10);

        assertThat(shoppingCart.getDiscountAmount(), is(discountSize));
    }

    @Test
    public void testSetDiscountSizeWithVariableDiscount() {
        shoppingCart.applyDiscount();
        BigDecimal discountAmount = new BigDecimal("123.9");

        assertThat(shoppingCart.getDiscountAmount(), is(discountAmount));
    }

    @Test
    public void testFullPriceWithSaleDiscount() {
        Sale sale = new SaleDiscount(shoppingCartFactory.getSaleProduct());
        shoppingCart.applySale();

        assertThat(shoppingCart.getOriginalCost(), is(new BigDecimal(1095)));
    }

}
