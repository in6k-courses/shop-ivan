package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 3/4/16.
 */
public class SalePresentTest extends SpecialTest {

    private Product present;


    public Product createPresent() {
        present = new Product("football poster", new BigDecimal(0));
        return present;
    }

    @Test
    public void testTakeParticipationInSale() {
        sale = new SalePresent(saleProducts, createPresent());
        shoppingCart = new ShoppingCart(selectedProducts);
        shoppingCart.setSale(sale);
        shoppingCart.acceptSale();

        assertThat(shoppingCart.getSelectedProducts(), hasItems(new Product("football poster", new BigDecimal(0))));
    }

}
