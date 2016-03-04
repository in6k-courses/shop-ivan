package com.shopApp.specials;

import com.shopApp.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/3/16.
 */
public class Present implements Sale {

    private List<Product> saleProducts = new ArrayList<Product>();
    private List<Product> choosenProducts = new ArrayList<Product>();

    private Product present;

    public Present(List<Product> saleProducts, Product present) {
        this.saleProducts = saleProducts;
        this.present = present;
    }

    public void takeParticipation(List<Product> cartProducts) {

        for(Product cartProduct : cartProducts) {
            for(Product saleProduct : saleProducts) {
                if(cartProduct.equals(saleProduct)) {
                    present.setPrice(new BigDecimal(0));
                    cartProducts.add(present);
                    return;
                }
            }
        }
    }


}
