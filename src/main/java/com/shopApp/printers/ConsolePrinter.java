package com.shopApp.printers;

import com.shopApp.ShoppingCart;

import java.io.PrintStream;

public class ConsolePrinter extends Printer {

    private static final String NAME_FORMAT = "%-25s";
    private static final int DIVIDER_LENGTH = 30;

    public ConsolePrinter(ShoppingCart shoppingCart) {
        super(System.out, shoppingCart);
    }

    @Override
    protected String wrapper(String line) {
        return String.format(NAME_FORMAT, line);
    }

    public void printDivideLine() {
        String divideSign = "=";
        String divideLine = "";
        for (int i = 0; i < DIVIDER_LENGTH; i++) {
            divideLine += divideSign;
        }
        printStream.println(divideLine);
    }
}
