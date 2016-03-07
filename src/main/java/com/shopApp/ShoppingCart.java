package com.shopApp;

import java.math.BigDecimal;
import java.util.List;

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
