package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.ShoppingCartImpl;
import com.shopApp.discounts.NoDiscount;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class SalePresentTest{

    private Sale sale;
    private List<Product> saleProducts = Collections.EMPTY_LIST;
    private Product present;

    public SalePresentTest() {
        saleProducts = ShoppingCartFactory.getSaleProducts();
        sale = new PresentSale(saleProducts, createPresent());
    }

    public Product createPresent() {
        present = ShoppingCartFactory.createProduct("football poster", 30);
        return present;
    }

    @Test
    public void testTakeParticipationInSalePresent() {
        sale = new PresentSale(saleProducts, createPresent());
        ShoppingCart shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, sale);
        shoppingCart.addProducts(ShoppingCartFactory.getProductsSet());
        shoppingCart.applySale(sale);

        assertThat(shoppingCart.getSelectedProducts(), hasItems(present));
    }

}
