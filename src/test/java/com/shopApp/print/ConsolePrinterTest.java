package com.shopApp.print;

import com.shopApp.ShopingCart;
import com.shopApp.ShopingCartFactory;
import com.shopApp.printers.ConsolePrinter;
import com.shopApp.printers.Printer;

/**
 * Created by employee on 3/4/16.
 */

public class ConsolePrinterTest {

    private Printer printer;
    private ShopingCart shopingCart;
    private ShopingCartFactory shopingCartFactory;

    public void ConsolePrinterTest() {
        shopingCartFactory = new ShopingCartFactory();
        shopingCart = new ShopingCart(shopingCartFactory.getProductsSet());
        printer = new ConsolePrinter(shopingCart);
    }
}
