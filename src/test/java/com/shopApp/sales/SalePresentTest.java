package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartImpl;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.NoDiscount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class SalePresentTest extends SaleTest {

    private Product present;


    public Product createPresent() {
        present = new Product("football poster", new BigDecimal(0));
        return present;
    }

    @Test
    public void testTakeParticipationInSale() {
        sale = new SalePresent(saleProducts, createPresent());
        ShoppingCart shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, sale);

        shoppingCart.applySale();

        assertThat(shoppingCart.getSelectedProducts(), hasItems(present));
    }

}
