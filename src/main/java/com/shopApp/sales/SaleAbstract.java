package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.ProductDiscount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 08.03.16.
 */
public abstract class SaleAbstract implements Sale {

    protected List<Product> saleProducts = new ArrayList<Product>();
    protected Discount productDiscount = new ProductDiscount();

    public SaleAbstract(List<Product> saleProducts) {
        this.saleProducts = saleProducts;
    }

    @Override
    public void applySaleFor(ShoppingCart shoppingCart) {
        for (Product product : shoppingCart.getSelectedProducts()) {
            if (isSaleProduct(product)) {
                makeSalePresent(product);
                return;
            }
        }
    }

    private Boolean isSaleProduct(Product product) {
        return saleProducts.contains(product);
    }

    protected abstract void makeSalePresent(Product product);

}
