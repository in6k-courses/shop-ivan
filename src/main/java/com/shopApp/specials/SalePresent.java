package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/3/16.
 */
public class SalePresent implements Sale {

    private List<Product> saleProducts = new ArrayList<Product>();

    private Product present;

    public SalePresent(List<Product> saleProducts, Product present) {
        this.saleProducts = saleProducts;
        this.present = makePresent(present);
    }

    public void acceptSaleFor(ShoppingCart shoppingCart) {
        addPresentTo(shoppingCart);
    }

    private void addPresentTo(ShoppingCart shoppingCart) {
        for(Product product : shoppingCart.getSelectedProducts()) {
            if(isSaleProduct(product)) {
                shoppingCart.addProduct(present);
                return;
            }
        }

    }

    private Product makePresent(Product product) {
        product.setPrice(BigDecimal.ZERO);
        return product;
    }

    private Boolean isSaleProduct(Product product) {
        return saleProducts.contains(product);
    }
}
