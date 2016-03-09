package com.shopApp;

import com.shopApp.discounts.NoDiscount;
import com.shopApp.sales.NoSale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFactory {

    private static ShoppingCart shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, NoSale.NoSale);;

    public static ShoppingCart getShoppingCartWithThreeProducts() {
        return shoppingCart;
    }

    public static List<Product> getProductsSet() {
        List<Product> products = new ArrayList<Product>();

        Product soccerBall = createProduct("soccer ball", 1100);
        products.add(soccerBall);

        Product goalkeeperGloves = createProduct("Goalkeeper's gloves", 300);
        products.add(goalkeeperGloves);

        Product basketballBall = createProduct("basketball ball", 250);
        products.add(basketballBall);

        Product monopolyGame = createProduct("monopoly game", 120);
        products.add(monopolyGame);

        return products;
    }

    public static List<Product> getSaleProducts() {
        List<Product> saleProducts = new ArrayList<Product>();
        saleProducts.add(createProduct("soccer ball", 1100));
        saleProducts.add(createProduct("basketball ball", 250));
        return saleProducts;
    }

    public static Product createProduct(String name, int price) {
        return new Product(name, new BigDecimal(price));
    }


}
