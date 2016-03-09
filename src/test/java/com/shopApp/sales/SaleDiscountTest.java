package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.ShoppingCartImpl;
import com.shopApp.discounts.NoDiscount;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
        List<Product> productsWithDiscount = getProductsWithDiscount(cartProducts);
        for (Product product : productsWithDiscount) {
            assertThat(product.getPriceWithDiscount(), is(new BigDecimal(150)));
        }
    }

    private List<Product> getProductsWithDiscount(List<Product> products) {
        List<Product> productsWithDiscount = new ArrayList<>();
        for (Product product : products) {
            if (product.hasDiscount()) productsWithDiscount.add(product);
        }
        return productsWithDiscount;
    }

}
