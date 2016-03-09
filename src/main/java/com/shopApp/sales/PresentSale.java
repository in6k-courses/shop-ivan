package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public class PresentSale extends AbstractSale {

    private Product present;

    public PresentSale(List<Product> saleProducts, Product present) {
        super(saleProducts);
        this.present = present;
    }

    private Product makePresent(Product product) {
        Product present = product;
        present.setPrice(BigDecimal.ZERO);
        return present;
    }

    @Override
    protected void makeSalePresent(Product product) {
        giveGift(shoppingCart);
    }

    private void giveGift(ShoppingCart shoppingCart) {
        shoppingCart.addProduct(makePresent(present));
    }
}
