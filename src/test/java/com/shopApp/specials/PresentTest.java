package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShopingCart;
import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 3/4/16.
 */
public class PresentTest extends SpecialTest{

    private static List<Product> presents = new ArrayList<Product>();


    public static List<Product> createPresents() {
        List<Product> presents = new ArrayList<Product>();
        Product poster = new Product("football poster", new BigDecimal(30));
        presents.add(poster);
        return presents;
    }

    @BeforeClass
    public static void initializeProductsLists() {
        initializeChoosenProducts();
        initializeProductsForSpecial();
        presents = createPresents();
    }

    @Test
    public void testTakeParticipation() {
        Special present = new Present(productsForSpecial, presents);
        ShopingCart shopingCart = new ShopingCart(choosenProducts, null, present);

        shopingCart.executeSpecial();
        assertThat(shopingCart.getProducts(), hasItems(new Product("football poster", new BigDecimal(30))));
    }

}
