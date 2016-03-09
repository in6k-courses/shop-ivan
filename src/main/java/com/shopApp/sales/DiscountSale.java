package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.ProductDiscount;

import java.math.BigDecimal;
import java.util.List;

public class DiscountSale extends AbstractSale {

    private Discount productDiscount = new ProductDiscount();

    public DiscountSale(List<Product> saleProducts) {
        super(saleProducts);
    }

    @Override
    protected void makeSalePresent(Product product) {
        makeSaleDiscount(product);
    }

    protected void makeSaleDiscount(Product product) {
        BigDecimal price = product.getPrice();
        BigDecimal salePrice = productDiscount.calculateDiscount(price);
        product.setDiscount(salePrice);
    }

}
