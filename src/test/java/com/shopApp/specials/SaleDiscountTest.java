package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShopingCart;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;


/**
 * Created by employee on 3/4/16.
 */
public class SaleDiscountTest extends SpecialTest {


    @BeforeClass
    public static void initializeProductsLists() {
        initializeChoosenProducts();
        initializeProductsForSpecial();
    }

    @Test
    public void testTakeParticipation() {
        Sale present = new SaleDiscount(saleProducts);
        ShopingCart shopingCart = new ShopingCart(selectedProducts, null, present);

        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));

        assertThat(shopingCart.getSelectedProducts(), hasItems(goalkeeperGloves));
    }

    @Test
    public void testProductCostAfterDiscount() {
        Sale present = new SaleDiscount(saleProducts);
        ShopingCart shopingCart = new ShopingCart(selectedProducts, null, present);

        Product goalkeeperGlove = new Product("Goalkeeper's gloves", new BigDecimal(300));
        List<Product> cartProducts = shopingCart.getSelectedProducts();
        Product specialProduct = findProductByName("Goalkeeper's gloves", cartProducts);

        shopingCart.acceptSale();
        assertThat(specialProduct.getPrice(), is(new BigDecimal(150)));
    }

    private Product findProductByName(String name, List<Product> products) {
        for(Product product : products) {
            if(product.getName() == name) return product;
        }
        return null;
    }

}
