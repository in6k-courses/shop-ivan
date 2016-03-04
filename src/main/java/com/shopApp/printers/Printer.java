package com.shopApp.printers;

import com.shopApp.Product;
import com.shopApp.ShopingCart;
import com.shopApp.discounts.Discount;
import com.shopApp.specials.Special;


import java.io.PrintStream;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public abstract class Printer {

    protected static final String NAME_FORMAT = "%-25s";

    private PrintStream printStream = System.out;
    private ShopingCart shopingCart;

    public Printer(ShopingCart shopingCart) {
        this.shopingCart = shopingCart;
    }

    public Printer(PrintStream printStream, ShopingCart shopingCart) {
        this(shopingCart);
        this.printStream = printStream;
    }

    protected abstract String wrapper(String line) ;

    abstract void printHeader();

    public void print() {
        printHeader();
        printCartProducts(shopingCart.getProducts());
        printFooter();
    };

    void printFooter() {
        printStream.print("Sum = ");
        printStream.print(shopingCart.getFullPrice() + "\n");
        printStream.print("Discount = ");
        printStream.print(shopingCart.discountSize() + "\n");
    };

    public void printCartProducts(List<Product> products) {
        printStream.println("Shooping Cart has:");
        for(Product product : products) {
            printStream.print(wrapper(product.getName()));
            printStream.print(product.getCost() + "\n");
        }
        System.out.println("=========================");
    };
}
