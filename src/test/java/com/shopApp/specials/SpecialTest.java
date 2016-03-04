package com.shopApp.specials;

import com.shopApp.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class SpecialTest {
    protected static List<Product> selectedProducts = new ArrayList<Product>();
    protected static List<Product> saleProducts = new ArrayList<Product>();

    protected static void initializeProductsForSpecial() {
        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        saleProducts.add(goalkeeperGloves);
    }

    protected static void initializeChoosenProducts() {

        Product soccerBall = new Product("soccer ball", new BigDecimal(300));
        selectedProducts.add(soccerBall);

        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        selectedProducts.add(goalkeeperGloves);

        Product basketballBall = new Product("basketball ball", new BigDecimal(250));
        selectedProducts.add(basketballBall);

        Product monopolyGame = new Product("monopoly game", new BigDecimal(120));
        selectedProducts.add(basketballBall);

    }
    public SpecialTest() {
        initializeChoosenProducts();

    }
}
