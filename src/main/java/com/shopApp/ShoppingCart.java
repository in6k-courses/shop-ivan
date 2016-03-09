package com.shopApp;

import com.shopApp.discounts.Discount;
import com.shopApp.sales.Sale;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCart {

    void addProduct(Product product);

    void addProducts(List<Product> products);

    List<Product> getSelectedProducts();

    void applyDiscount(Discount discount);

    void applySale(Sale sale);

    BigDecimal getOriginalCost();

    BigDecimal getFinalCost();

    BigDecimal getDiscountAmount();
}
