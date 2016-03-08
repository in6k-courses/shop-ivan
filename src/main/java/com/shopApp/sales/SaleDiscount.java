package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.ProductDiscount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaleDiscount extends SaleAbstract {

    public SaleDiscount(List<Product> saleProducts) {
        super(saleProducts);
    }

    @Override
    protected void makeSalePresent(Product product) {
        BigDecimal price = product.getPrice();
        BigDecimal salePrice = productDiscount.calculateDiscount(price);
        product.setDiscount(salePrice);
    }

}
