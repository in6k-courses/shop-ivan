package com.shopApp.specials;

import com.shopApp.Product;
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

    public SaleDiscount(List<Product> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public void takeParticipation(List<Product> cartProducts) {
        Discount productDiscount = new ProductDiscount();

        for (Product cartProduct : cartProducts) {
            for (Product saleProduct : saleProducts) {
                if (cartProduct.equals(saleProduct)) {
                    BigDecimal productPrice = cartProduct.getPrice();
                    BigDecimal salePrice = productDiscount.calculateDiscount(productPrice);
                    cartProduct.setPrice(salePrice);
                }
            }
        }
    }

}
