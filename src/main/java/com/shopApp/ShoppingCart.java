package com.shopApp;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by employee on 3/3/16.
 */
public interface ShoppingCart {

    void addProduct(Product product);

    void addProducts(List<Product> products);

    List<Product> getSelectedProducts();

    void applyDiscount();

    void applySale();

    BigDecimal getOriginalCost();

    BigDecimal getFinalCost();

    BigDecimal getDiscountAmount();
}
