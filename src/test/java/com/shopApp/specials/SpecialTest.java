package com.shopApp.specials;

import com.shopApp.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class SpecialTest {
    protected static List<Product> choosenProducts = new ArrayList<Product>();
    protected static List<Product> productsForSpecial = new ArrayList<Product>();

    protected static void initializeProductsForSpecial() {
        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        productsForSpecial.add(goalkeeperGloves);
    }

    protected static void initializeChoosenProducts() {

        Product soccerBall = new Product("soccer ball", new BigDecimal(300));
        choosenProducts.add(soccerBall);

        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        choosenProducts.add(goalkeeperGloves);

        Product basketballBall = new Product("basketball ball", new BigDecimal(250));
        choosenProducts.add(basketballBall);

        Product monopolyGame = new Product("monopoly game", new BigDecimal(120));
        choosenProducts.add(basketballBall);

    }
}
