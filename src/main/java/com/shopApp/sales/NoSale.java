package com.shopApp.sales;

import com.shopApp.ShoppingCart;

public enum NoSale implements Sale {
    NoSale;

    public void applySaleFor(ShoppingCart shoppingCart) {
        return;
    }
}
