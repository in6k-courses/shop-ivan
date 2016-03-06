package com.shopApp.print;

import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.printers.ConsolePrinter;
import com.shopApp.printers.Printer;

/**
 * Created by employee on 3/4/16.
 */

public class ConsolePrinterTest {

    private Printer printer;
    private ShoppingCart shoppingCart;
    private ShoppingCartFactory shoppingCartFactory;

    public void ConsolePrinterTest() {
        shoppingCartFactory = new ShoppingCartFactory();
        shoppingCart = new ShoppingCart(shoppingCartFactory.getProductsSet());
        printer = new ConsolePrinter(shoppingCart);
    }
}
