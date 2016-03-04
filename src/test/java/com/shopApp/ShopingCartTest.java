package com.shopApp;


import com.shopApp.discounts.Discount;
import com.shopApp.discounts.InvariableDiscount;
import com.shopApp.discounts.VariableDiscount;
import com.shopApp.specials.NullSale;
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

    private static List<Product> products;



    private static void fillProducts() {
        ShopingCartFactory shopingCartFactory = new ShopingCartFactory();
        products = shopingCartFactory.getProductsSet();
    }

    @BeforeClass
    public static void create() {
        fillProducts();
        shopingCart = new ShopingCart(products);
    }


    @Test
    public void testFullPriceWithoutProductsList() {
        List<Product> emptyProductList = new ArrayList<Product>();
        shopingCart.setSelectedProducts(emptyProductList);
        BigDecimal nullPrice = new BigDecimal(0);

        assertThat(shopingCart.getFullPrice(), is(nullPrice));
    }

    @Test
    public void testDiscountPriceWithEmptyProductsList() {
        List<Product> emptyProductList = new ArrayList<Product>();
        shopingCart.setSelectedProducts(emptyProductList);
        BigDecimal nullPrice = new BigDecimal(0);

        assertThat(shopingCart.getDiscountPrice(), is(nullPrice));
    }


    @Test
    public void testSetDiscountPriceUsingInvariableDiscount() {
        Discount invariableDiscount = new InvariableDiscount();

        ShopingCart shopingCart = new ShopingCart(products);
        shopingCart.setDiscount(invariableDiscount);

        BigDecimal endPrice = (shopingCart.getFullPrice()).subtract(new BigDecimal(10));
        shopingCart.executeDiscount();
        assertThat(shopingCart.getDiscountPrice(), is(endPrice));
    }

    @Ignore
    @Test
    public void testSetEndPriceWithVariableDiscount() {
        Discount variableDiscount = new VariableDiscount();
        ShopingCart shopingCart = new ShopingCart(products);
        shopingCart.setDiscount(variableDiscount);

        BigDecimal endPrice = (shopingCart.getFullPrice()).subtract(variableDiscount.calculateDiscount(new BigDecimal(60)));
        assertThat(shopingCart.getDiscountPrice(), is(endPrice));
    }


}
