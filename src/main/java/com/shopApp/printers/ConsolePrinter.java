package com.shopApp.printers;

import com.shopApp.ShopingCart;

import java.io.PrintStream;

/**
 * Created by ivan on 04.03.16.
 */
public class ConsolePrinter extends Printer {

    public ConsolePrinter(ShopingCart shopingCart) {
        super(shopingCart);
    }

    public ConsolePrinter(PrintStream printStream, ShopingCart shopingCart) {
        super(printStream, shopingCart);
    }

    @Override
    protected String wrapper(String line) {
        return String.format(NAME_FORMAT, line);
    }

    @Override
    void printHeader() {
        System.out.println("Check");
        System.out.println("=======================");
    }
}
