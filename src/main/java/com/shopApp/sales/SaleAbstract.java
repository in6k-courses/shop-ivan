package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.ProductDiscount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ivan on 08.03.16.
 */
public abstract class SaleAbstract implements Sale {

    protected ShoppingCart shoppingCart;
    protected List<Product> saleProducts = Collections.EMPTY_LIST;

    public SaleAbstract(List<Product> saleProducts) {
        this.saleProducts = saleProducts;
    }

    @Override
    public void applySaleFor(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        List<Product> shoppingCartProducts = new ArrayList<>(shoppingCart.getSelectedProducts());
        for (Product product : shoppingCartProducts) {
            if (isSaleProduct(product)) {
                makeSalePresent(product);
            }
        }
    }

    public Boolean isSaleProduct(Product product) {
        return saleProducts.contains(product);
    }

    protected abstract void makeSalePresent(Product product);

}
