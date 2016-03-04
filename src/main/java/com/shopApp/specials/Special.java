package com.shopApp.specials;

import com.shopApp.ShopingCart;

/**
 * Created by employee on 3/3/16.
 */
public interface Special {
    void hasProductsForParticipation(ShopingCart shopingCart);
    void takeParticipation();
}
