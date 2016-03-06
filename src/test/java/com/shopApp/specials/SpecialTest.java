package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class SpecialTest {
    protected Sale sale;
    protected ShoppingCart shoppingCart;
    protected List<Product> selectedProducts = new ArrayList<Product>();
    protected List<Product> saleProducts = new ArrayList<Product>();

    protected List<Product> getSaleProducts() {
        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        saleProducts.add(goalkeeperGloves);
        return saleProducts;
    }

    public SpecialTest() {
        ShoppingCartFactory shoppingCartFactory = new ShoppingCartFactory();
        shoppingCart = shoppingCartFactory.getShoppingCart();

        saleProducts = getSaleProducts();
    }
}
