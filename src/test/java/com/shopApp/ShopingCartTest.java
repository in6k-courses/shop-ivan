package com.shopApp;


import com.shopApp.discounts.Discount;
import com.shopApp.discounts.FixedDiscount;
import com.shopApp.discounts.TotalChangeableDiscount;
import com.shopApp.printers.Printer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 3/3/16.
 */

public class ShopingCartTest {

    private static ShopingCart shopingCart;

    private static List<Product> products = new ArrayList<Product>();

    private static void createProductSet() {
        BigDecimal[] moneyValues = {new BigDecimal(100), new BigDecimal(500), new BigDecimal(600),
                new BigDecimal(1000), new BigDecimal(1200)};
        for(int i = 0; i < moneyValues.length; i++) {
            String productName = "product" + i;
            BigDecimal price = moneyValues[i];
            Product product = new Product(productName, price);
            products.add(product);
        }
    }

    @BeforeClass
    public static void init() {
        createProductSet();
        shopingCart = new ShopingCart(products);
    }

    @Test
    public void testFullPriceWithEmptyProductsList() {
        List<Product> products = new ArrayList<>();
        ShopingCart shopingCart = new ShopingCart(products);
        assertThat(shopingCart.getFullPrice(), is(new BigDecimal(0)));
    }


    @Test
    public  void testSetEndPriceWithFixedDiscount() {
        Discount fixedDiscount = new FixedDiscount();
        ShopingCart shopingCart = new ShopingCart(products, fixedDiscount, null);
        BigDecimal endPrice = (shopingCart.getFullPrice()).subtract(new BigDecimal(10));
        shopingCart.executeDiscount();
        assertThat(shopingCart.getEndPrice(), is(endPrice));
    }

//    @Test
//    public  void testSetEndPriceWithTotalChangeableDiscount() {
//        Discount fixedDiscount = new TotalChangeableDiscount();
//        ShopingCart shopingCart = new ShopingCart(products, fixedDiscount, null);
//        BigDecimal endPrice = (shopingCart.getFullPrice()).subtract(fixedDiscount.calculateDiscount(new BigDecimal(60)));
//        assertThat(shopingCart.executeDiscount(), is(endPrice));
//    }


}
