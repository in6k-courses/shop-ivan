package com.shopApp;


import com.shopApp.discounts.Discount;
import com.shopApp.discounts.InvariableDiscount;
import com.shopApp.discounts.VariableDiscount;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 3/3/16.
 */

public class ShopingCartTest {

    private static ShopingCart shopingCart;

    private static List<Product> products = new ArrayList<Product>();

    private final static BigDecimal[] moneyValues = {new BigDecimal(100), new BigDecimal(500), new BigDecimal(600),
            new BigDecimal(1000), new BigDecimal(1200)};

    private static void fillProducts() {
        for (int i = 0; i < 5; i++) {
            products.add(new Product("product", moneyValues[i]));
        }
    }

    @BeforeClass
    public static void create() {
        fillProducts();
        shopingCart = new ShopingCart(products);
    }


    @Test
    public void testFullPriceWithoutProducts() {
        shopingCart.setSelectedProducts(new ArrayList<Product>());
        BigDecimal empty = new BigDecimal(0);
        assertThat(shopingCart.getFullPrice(), is(empty));
    }

    @Test
    public void testEndPriceWithEmptyProductsList() {
        shopingCart.setSelectedProducts(new ArrayList<Product>());
        BigDecimal empty = new BigDecimal(0);
        assertThat(shopingCart.getDiscountPrice(), is(empty));
    }


    @Test
    public void testSetEndPriceWithFixedDiscount() {
        Discount fixedDiscount = new InvariableDiscount();
        ShopingCart shopingCart = new ShopingCart(products, fixedDiscount, null);
        BigDecimal endPrice = (shopingCart.getFullPrice()).subtract(new BigDecimal(10));
        shopingCart.executeDiscount();
        assertThat(shopingCart.getDiscountPrice(), is(endPrice));
    }

    @Ignore
    @Test
    public void testSetEndPriceWithTotalChangeableDiscount() {
        Discount fixedDiscount = new VariableDiscount();
        ShopingCart shopingCart = new ShopingCart(products, fixedDiscount, null);
        BigDecimal endPrice = (shopingCart.getFullPrice()).subtract(fixedDiscount.calculateDiscount(new BigDecimal(60)));
        assertThat(shopingCart.getDiscountPrice(), is(endPrice));
    }


}
