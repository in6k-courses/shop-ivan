package com.shopApp;


import org.junit.Before;
import org.junit.BeforeClass;
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

    private static void createProductSet() {
        for(int i = 0; i < 5; i++) {
            String productName = "product" + i;
            int price = i + 10;
            Product product = new Product(productName, new BigDecimal(price));
            products.add(product);
        }
    }

    @BeforeClass
    public static void init() {
        createProductSet();
        shopingCart = new ShopingCart(products);
    }

    @Test
    public void testSetFullPrice() {
        assertThat(shopingCart.getFullPrice(), is(equalTo(new BigDecimal(60))));
    }



}
