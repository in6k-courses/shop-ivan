package com.shopApp;

import com.shopApp.discounts.NoDiscount;
import com.shopApp.sales.NoSale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFactory {

    private List<Product> products;
    private ShoppingCart shoppingCart;

    public ShoppingCartFactory() {
        products = createProductsSet();
        shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, NoSale.NoSale);
        shoppingCart.addProducts(products);
    }

    public List<Product> getProductsSet() {
        return products;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    private List<Product> createProductsSet() {
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

    private Product createProduct(String name, double cost) {
        BigDecimal price = new BigDecimal(cost);
        Product product = new Product(name, price);
        return product;
    }

    public List<Product> getSaleProduct() {
        List<Product> saleProducts = new ArrayList<Product>();
        saleProducts.add(createProduct("soccer ball", 1100));
        saleProducts.add(createProduct("basketball ball", 250));
        return saleProducts;
    }

    public Product createProduct(String name, int price) {
        return new Product(name, new BigDecimal(price));
    }


}
