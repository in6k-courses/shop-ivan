package com.shopApp;

import com.shopApp.discounts.Discount;
import com.shopApp.discounts.VariableDiscount;
import com.shopApp.printers.ConsolePrinter;
import com.shopApp.printers.Printer;
import com.shopApp.specials.SaleDiscount;
import com.shopApp.specials.SalePresent;
import com.shopApp.specials.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class Main {
    private static List<Product> selectedProducts = new ArrayList<Product>();
    private static List<Product> saleProducts = new ArrayList<Product>();


    protected static void createSaleProducts() {
        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        saleProducts.add(goalkeeperGloves);
    }

    protected static void selectSelectedProduct() {

        Product soccerBall = new Product("soccer ball", new BigDecimal(1100));
        selectedProducts.add(soccerBall);

        Product goalkeeperGloves = new Product("Goalkeeper's gloves", new BigDecimal(300));
        selectedProducts.add(goalkeeperGloves);

        Product basketballBall = new Product("basketball ball", new BigDecimal(250));
        selectedProducts.add(basketballBall);

        Product monopolyGame = new Product("monopoly game", new BigDecimal(120));
        selectedProducts.add(monopolyGame);

    }

    public static void main(String[] args) {
        createSaleProducts();
        selectSelectedProduct();

        Product prize = new Product("football poster", new BigDecimal(52));

        Discount variableDiscount = new VariableDiscount();

        Sale salePresent = new SalePresent(saleProducts, prize);
        Sale saleDiscount = new SaleDiscount(saleProducts);

        ShoppingCart shoppingCart = new ShoppingCart(selectedProducts);
        shoppingCart.setDiscount(variableDiscount);
        shoppingCart.setSale(salePresent);
        shoppingCart.executeDiscount();
        shoppingCart.acceptSale();


        Printer printer = new ConsolePrinter(System.out, shoppingCart);
        printer.print();
    }
}
