package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.ShoppingCartImpl;
import com.shopApp.discounts.NoDiscount;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SaleDiscountTest extends SaleTest {

    @Test
    public void testProductCostAfterDiscount() {
        sale = new DiscountSale(saleProducts);
        shoppingCart.applySale(sale);

        List<Product> cartProducts = shoppingCart.getSelectedProducts();
        List<Product> productsWithDiscount = getProductsWithDiscount(cartProducts);
        for (Product product : productsWithDiscount) {
            assertThat(product.getPriceWithDiscount(), is(new BigDecimal(270)));
        }
    }

    private List<Product> getProductsWithDiscount(List<Product> products) {
        List<Product> productsWithDiscount = new ArrayList<Product>();
        for (Product product : products) {
            if (product.hasDiscount()) productsWithDiscount.add(product);
        }
        return productsWithDiscount;
    }

}
