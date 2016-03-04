package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShopingCart;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.ProductDiscount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class SpecialDiscount implements Special {
    private List<Product> productsForSpecial = new ArrayList<Product>();
    private List<Product> choosenProducts = new ArrayList<Product>();

    public SpecialDiscount(List<Product> productsForSpecial) {
        this.productsForSpecial = productsForSpecial;
    }

    public void takeParticipation(List<Product> choosenProducts) {
        Discount discount = new ProductDiscount();

        for(Product choosenProduct : choosenProducts) {
            for(Product specialProduct : productsForSpecial) {
                if(choosenProduct.equals(specialProduct)) {
                    BigDecimal oldPrice = choosenProduct.getCost();
                    BigDecimal newPrice = discount.calculateDiscount(oldPrice);
                    choosenProduct.setCost(newPrice);
                }
            }
        }
    }

}
