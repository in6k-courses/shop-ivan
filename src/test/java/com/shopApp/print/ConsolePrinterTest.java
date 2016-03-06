package com.shopApp.print;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.printers.ConsolePrinter;
import com.shopApp.printers.Printer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 3/4/16.
 */

public class ConsolePrinterTest {

    private static final String NAME_FORMAT = "%-25s";
    private static final int DIVIDER_LENGTH = 30;

    private Printer printer;
    private ShoppingCart shoppingCart;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    public void init() {
        ShoppingCartFactory shoppingCartFactory = new ShoppingCartFactory();
        shoppingCart = shoppingCartFactory.getShoppingCart();
        printer = new ConsolePrinter(shoppingCart);
    }

    @Test
    public void testPrintCartProducts() {
        init();
        printer.print();
        assertThat(outContent.toString(), is(getCheck()));
    }

    private String getCheck() {
        String check = ""
                + "Check" + "\n"
                + getDivideLine() + "\n"
                + wrapper("Shooping Cart has:") + "\n"
                + getDivideLine() + "\n"
                + getProductList()
                + getDivideLine() + "\n"
                + getPricesList();

        return check;
    }

    private String getProductList() {
        String productList = "";
        for(Product product : shoppingCart.getSelectedProducts()) {
            productList += wrapper(product.getName()) + wrapper("" + product.getPrice()) + "\n";
        }
        return productList;
    }

    private String getPricesList() {
        String prices = ""
                + wrapper("Sum:") + wrapper("" + shoppingCart.getFullPrice()) + "\n"
                + wrapper("Discount:") + wrapper("" + shoppingCart.getDiscountSize()) + "\n"
                + wrapper("To pay: ") + wrapper("" + shoppingCart.getDiscountPrice()) + "\n";

        return prices;
    }

    private String wrapper(String line) {
        return String.format(NAME_FORMAT, line);
    }

    public String getDivideLine() {
        String divideSign = "=";
        String divideLine = "";
        for (int i = 0; i < DIVIDER_LENGTH; i++) {
            divideLine += divideSign;
        }
        return divideLine;
    }

//
//    @Test
//    public void err() {
//        System.err.print("hello again");
//        assertEquals("hello again", errContent.toString());
//    }


}
