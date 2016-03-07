package com.shopApp.specials;

import com.shopApp.ShoppingCart;

/**
 * Created by employee on 3/4/16.
 */
public class NullSale implements Sale {

    public void acceptSaleFor(ShoppingCart shoppingCart) {
        return;
    }
}
