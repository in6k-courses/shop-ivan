package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalePresent extends SaleAbstract {

    private Product present;

    public SalePresent(List<Product> saleProducts, Product present) {
        super(saleProducts);
        this.present = makePresent(present);
    }

    private Product makePresent(Product product) {
        product.setPrice(BigDecimal.ZERO);
        return product;
    }

    @Override
    protected void makeSalePresent(Product product) {

    }
}
