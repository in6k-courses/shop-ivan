package com.shopApp.printers;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;


import java.io.PrintStream;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public abstract class Printer {

    protected static final String NAME_FORMAT = "%-25s";

    private PrintStream printStream = System.out;
    private ShoppingCart shoppingCart;

    public Printer(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Printer(PrintStream printStream, ShoppingCart shoppingCart) {
        this(shoppingCart);
        this.printStream = printStream;
    }

    protected abstract String wrapper(String line) ;

    abstract void printHeader();

    public void print() {
        printHeader();
        printCartProducts(shoppingCart.getSelectedProducts());

        printFooter();
    };

    void printFooter() {
        printStream.print("Sum = ");
        printStream.print(shoppingCart.getFullPrice() + "\n");
        printStream.print("Discount = ");
        printStream.print(shoppingCart.getDiscountSize() + "\n");
    };

    public void printCartProducts(List<Product> products) {
        printStream.println("Shooping Cart has:");
        for(Product product : products) {
            printStream.print(wrapper(product.getName()));
            printStream.print(product.getPrice() + "\n");
        }
        System.out.println("=========================");
    };
}
