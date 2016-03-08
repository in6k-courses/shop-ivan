package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.ShoppingCartImpl;
import com.shopApp.discounts.NoDiscount;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SaleDiscountTest extends SaleTest {

    @Test
    public void testProductCostAfterDiscount() {
        sale = new SaleDiscount(saleProducts);
        shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, sale);
        shoppingCart.addProducts(ShoppingCartFactory.getProductsSet());
        shoppingCart.applySale();


        List<Product> cartProducts = shoppingCart.getSelectedProducts();
        Product specialProduct = findProductByName("Goalkeeper's gloves", cartProducts);

        assertThat(specialProduct.getPriceWithDiscount(), is(new BigDecimal(150)));
    }

    private Product findProductByName(String title, List<Product> products) {
        for (Product product : products) {
            if (product.getTitle() == title) return product;
        }
        return null;
    }

}
