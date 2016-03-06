package com.shopApp;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ivan on 06.03.16.
 */
public class ProductTest {
    private Product product;

    @Before
    private void createProduct() {
        BigDecimal price = new BigDecimal(50);
        product = new Product("ball for child", price);
    }

    @Test
    public void testProductName() {
        assertThat(product.getName(), is("ball for child"));
    }

    @Test
    public void testNegativePriceUsingSetMethod() {
        BigDecimal price = new BigDecimal(-25);
        product.setPrice(price);

        assertThat(product.getPrice(), is(BigDecimal.ZERO));
    }

    @Test
    public void testNegativePriceUsingConstructor() {
        BigDecimal price = new BigDecimal(-25);
        Product product = new Product("ball for child", price);

        assertThat(product.getPrice(), is(BigDecimal.ZERO));
    }

}
