package com.shopApp.specials;

import com.shopApp.Product;
import com.shopApp.ShopingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/3/16.
 */
public interface Sale {

    void takeParticipation(List<Product> choosenProducts);

}
