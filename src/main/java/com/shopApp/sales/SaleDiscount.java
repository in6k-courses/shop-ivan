package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.ProductDiscount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class SaleDiscount implements Sale {

    private List<Product> saleProducts = new ArrayList<Product>();
    private Discount productDiscount = new ProductDiscount();

    public SaleDiscount(List<Product> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public void applySaleFor(ShoppingCart shoppingCart) {
        List<Product> cartProducts = shoppingCart.getSelectedProducts();
        applyDiscount(cartProducts);
    }

    private void applyDiscount(List<Product> cartProducts) {
        for (Product product : cartProducts) {
            if (isSaleProduct(product)) {
                makeDiscountFor(product);
            }
        }
    }

    private void makeDiscountFor(Product product) {
        BigDecimal productPrice = product.getPrice();
        BigDecimal salePrice = productDiscount.calculateDiscount(productPrice);
        product.setPrice(salePrice);
    }

    private Boolean isSaleProduct(Product product) {
        return saleProducts.contains(product);
    }

}
