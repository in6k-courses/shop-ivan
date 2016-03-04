package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShopingCart;
import com.shopApp.discounts.NullDiscount;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 3/4/16.
 */
public class SalePresentTest extends SpecialTest{

    private static Product present;


    public static Product createPresent() {
        present = new Product("football poster", new BigDecimal(30));
        return present;
    }

    @BeforeClass
    public static void initializeProductsLists() {
        initializeChoosenProducts();
        initializeProductsForSpecial();
        present = createPresent();
    }

    @Test
    public void testTakeParticipationInSale() {
        Sale salePresent = new SalePresent(saleProducts, present);
        ShopingCart shopingCart = new ShopingCart(selectedProducts, new NullDiscount(), salePresent);

        shopingCart.acceptSale();
        assertThat(shopingCart.getSelectedProducts(), hasItems(new Product("football poster", new BigDecimal(30))));
    }

}
