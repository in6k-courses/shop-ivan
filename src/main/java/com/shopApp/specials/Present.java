package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShopingCart;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.ProductDiscount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/3/16.
 */
public class Present implements Special {

    private List<Product> productsForSpecial = new ArrayList<Product>();
    private List<Product> choosenProducts = new ArrayList<Product>();

    private List<Product> presents;

    public Present(List<Product> productsForSpecial, List<Product> presents) {
        this.productsForSpecial = productsForSpecial;
        this.presents = presents;
    }

    public void takeParticipation(List<Product> choosenProducts) {

        for(Product choosenProduct : choosenProducts) {
            for(Product specialProduct : productsForSpecial) {
                if(choosenProduct.equals(specialProduct)) {
                    choosenProducts.addAll(presents);
                    return;
                }
            }
        }
    }


}
