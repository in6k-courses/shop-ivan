package com.shopApp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class ShopingCartFactory {

    private  List<Product> products;

    public ShopingCartFactory() {
        products = new ArrayList<Product>();
    }

    public List<Product> getProductsSet() {
        return products;
    }

    private List<Product> createProductsSet() {
        Product soccerBall = createProduct("soccer ball", 1100);
        products.add(soccerBall);

        Product goalkeeperGloves = createProduct("Goalkeeper's gloves", 300);
        products.add(goalkeeperGloves);

        Product basketballBall = createProduct("basketball ball", 250);
        products.add(basketballBall);

        Product monopolyGame = createProduct("monopoly game", 120);
        products.add(basketballBall);

        return products;
    }

    private Product createProduct(String  name, double cost) {
        BigDecimal price = new BigDecimal(cost);
        Product product = new Product(name, price);
        return product;
    }


}
