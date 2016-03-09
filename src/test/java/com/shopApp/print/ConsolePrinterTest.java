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

public class ConsolePrinterTest {

    private static final String NAME_FORMAT = "%-25s";
    private static final int DIVIDER_LENGTH = 30;

    private Printer printer;
    private ShoppingCart shoppingCart;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private void setPrinterObject() {
        ShoppingCartFactory shoppingCartFactory = new ShoppingCartFactory();
        shoppingCart = shoppingCartFactory.getFilledShoppingCart();
        printer = new ConsolePrinter(shoppingCart);
    }

    private void setUpSteams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setObjects() {
        setUpSteams();
        setPrinterObject();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Test
    public void testPrintCartProducts() {
        printer.print();
        assertThat(outContent.toString(), is(getCheck()));
    }

    private String getCheck() {
        String check = ""
                + "Check" + "\n"
                + getDivisionLine() + "\n"
                + wrapper("Shopping Cart has:") + "\n"
                + getDivisionLine() + "\n"
                + getProductList()
                + getDivisionLine() + "\n"
                + getPricesList();

        return check;
    }

    private String getProductList() {
        String productList = "";
        for (Product product : shoppingCart.getSelectedProducts()) {
            productList += wrapper(product.getTitle()) + wrapper("" + product.getPrice()) + "\n";
        }
        return productList;
    }

    private String getPricesList() {
        String prices = ""
                + wrapper("Sum:") + wrapper("" + shoppingCart.getOriginalCost()) + "\n"
                + wrapper("Discount:") + wrapper("" + shoppingCart.getDiscountAmount()) + "\n"
                + wrapper("To pay: ") + wrapper("" + shoppingCart.getFinalCost()) + "\n";

        return prices;
    }

    private String wrapper(String line) {
        return String.format(NAME_FORMAT, line);
    }

    public String getDivisionLine() {
        String divisionSign = "=";
        String divisionLine = "";
        for (int i = 0; i < DIVIDER_LENGTH; i++) {
            divisionLine += divisionSign;
        }
        return divisionLine;
    }

}
