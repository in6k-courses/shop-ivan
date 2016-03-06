package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
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

    @Test
    public void testProductCostAfterDiscount() {
        sale = new SaleDiscount(saleProducts);
        shoppingCart.setSale(sale);


        List<Product> cartProducts = shoppingCart.getSelectedProducts();
        Product specialProduct = findProductByName("Goalkeeper's gloves", cartProducts);

        shoppingCart.acceptSale();
        assertThat(specialProduct.getPrice(), is(new BigDecimal(150)));
    }

    private Product findProductByName(String name, List<Product> products) {
        for(Product product : products) {
            if(product.getName() == name) return product;
        }
        return null;
    }

}
