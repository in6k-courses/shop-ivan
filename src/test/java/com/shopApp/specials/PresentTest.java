package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShopingCart;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 3/4/16.
 */
public class PresentTest extends SpecialTest{

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
    public void testTakeParticipation() {
        Sale prize = new Present(saleProducts, present);
        ShopingCart shopingCart = new ShopingCart(selectedProducts, null, prize);

        shopingCart.acceptSale();
        assertThat(shopingCart.getSelectedProducts(), hasItems(new Product("football poster", new BigDecimal(30))));
    }

}
