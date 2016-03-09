package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.ShoppingCartImpl;
import com.shopApp.discounts.NoDiscount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaleTest {
    protected Sale sale;
    protected ShoppingCart shoppingCart;
    protected List<Product> saleProducts = new ArrayList<Product>();

    protected List<Product> getSaleProducts() {
        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        saleProducts.add(goalkeeperGloves);
        return saleProducts;
    }

    public SaleTest() {
        shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, sale);

        saleProducts = getSaleProducts();
    }
}
