package com.shopApp;

import com.shopApp.discounts.Discount;
import com.shopApp.discounts.TotalChangeableDiscount;
import com.shopApp.printers.ConsolePrinter;
import com.shopApp.printers.Printer;
import com.shopApp.specials.Present;
import com.shopApp.specials.Special;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class Main {
    private static List<Product> choosenProducts = new ArrayList<Product>();
    private static List<Product> productsForSpecial = new ArrayList<Product>();


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

    public static void main(String[] args) {
        initializeProductsForSpecial();
        initializeChoosenProducts();

        Product prize = new Product("football poster", new BigDecimal(0));
        Discount discount = new TotalChangeableDiscount();
        Special special = new Present(productsForSpecial, prize);
        ShopingCart shopingCart = new ShopingCart(choosenProducts, discount, special);
//        shopingCart.executeDiscount();
        shopingCart.executeSpecial();

        Printer printer = new ConsolePrinter(System.out, shopingCart);
        printer.print();
    }
}
