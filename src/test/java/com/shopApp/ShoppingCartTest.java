package com.shopApp;


import com.shopApp.discounts.Discount;
import com.shopApp.discounts.InvariableDiscount;
import com.shopApp.discounts.VariableDiscount;
import com.shopApp.specials.Sale;
import com.shopApp.specials.SaleDiscount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 3/3/16.
 */

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void createShoppingCart() {
        ShoppingCartFactory shoppingCartFactory = new ShoppingCartFactory();
        shoppingCart = shoppingCartFactory.getShoppingCart();
    }


    @Test
    public void testFullPriceWithoutProductsList() {
        List<Product> emptyProductList = new ArrayList<Product>();
        shoppingCart.setSelectedProducts(emptyProductList);
        BigDecimal nullPrice = BigDecimal.ZERO;

        assertThat(shoppingCart.getFullPrice(), is(nullPrice));
    }

    @Test
    public void testDiscountSizeWithEmptyProductsList() {
        List<Product> emptyProductList = new ArrayList<Product>();
        shoppingCart = new ShoppingCart(emptyProductList);
        BigDecimal nullPrice = BigDecimal.ZERO;

        assertThat(shoppingCart.getDiscountSize(), is(nullPrice));
    }


    private void performDiscount(Discount discountType) {
        Discount discount = discountType;
        shoppingCart.setDiscount(discount);
        shoppingCart.acceptDiscount();
    }

    @Test
    public void testSetDiscountPriceUsingInvariableDiscount() {
        performDiscount(new InvariableDiscount());
        BigDecimal discountSize = new BigDecimal(10);

        assertThat(shoppingCart.getDiscountSize(), is(discountSize));
    }


    @Test
    public void testSetDiscountSizeWithVariableDiscount() {
        performDiscount(new VariableDiscount());
        BigDecimal discountSize = new BigDecimal("123.9");

        assertThat(shoppingCart.getDiscountSize(), is(discountSize));
    }

    @Test
    public void testFullPriceWithSaleDiscount() {
        Sale sale = new SaleDiscount(getSaleProduct());
        shoppingCart.setSale(sale);
        shoppingCart.acceptSale();
        BigDecimal fullPrice = new BigDecimal(1095);

        assertThat(shoppingCart.getFullPrice(), is(fullPrice));
    }

    private List<Product> getSaleProduct() {

        List<Product> saleProducts = new ArrayList<>();
        saleProducts.add(createProduct("soccer ball", 1100));
        saleProducts.add(createProduct("basketball ball", 250));
        return saleProducts;
    }

    private Product createProduct(String productName, int productPrice) {
        String name = productName;
        BigDecimal price = new BigDecimal(productPrice);
        return new Product(name, price);
    }


}
