package com.shopApp.printers;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;

import java.io.PrintStream;
import java.util.List;

public abstract class Printer {

    protected PrintStream printStream;
    private ShoppingCart shoppingCart;

    public Printer(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Printer(PrintStream printStream, ShoppingCart shoppingCart) {
        this(shoppingCart);
        this.printStream = printStream;
    }

    abstract String wrapper(String line);

    abstract void printDivideLine();

    public void print() {
        printHeader();
        printDivideLine();
        printCartProducts(shoppingCart.getSelectedProducts());
        printDivideLine();
        printFooter();
    }

    public void printHeader() {
        printStream.println("Check");
    }

    private void printCartProducts(List<Product> products) {
        printStream.println(wrapper("Shopping Cart has:"));
        printDivideLine();
        for (Product product : products) {
            printStream.print(wrapper(product.getTitle()));
            printStream.print(wrapper(product.getPrice().toString()) + "\n");
        }
    }

    private void printFooter() {
        printStream.println(getSumLine());
        printStream.println(getDiscountSize());
        printStream.println(getDiscountPrice());
    }

    private String getSumLine() {
        String title = wrapper("Sum: ");
        String value = wrapper(shoppingCart.getOriginalCost().toString());
        return title + value;
    }

    private String getDiscountSize() {
        String title = wrapper("Discount: ");
        String value = wrapper(shoppingCart.getDiscountAmount().toString());
        return title + value;
    }

    private String getDiscountPrice() {
        String title = wrapper("To pay: ");
        String value = wrapper(shoppingCart.getFinalCost().toString());
        return title + value;
    }
}
