package com.shopApp;

import com.shopApp.discounts.Discount;
import com.shopApp.specials.Special;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/3/16.
 */
public class ShopingCart {
    private Discount discount;
    private Special special;

    private List<Product> products = new ArrayList<Product>();

    private BigDecimal fullPrice;
    private BigDecimal endPrice;

    public ShopingCart(List<Product> products, Discount discount, Special special) {
        this(products);
        this.discount = discount;
        this.special = special;
    }

    public ShopingCart(List<Product> products) {
        this.products = products;
        setFullPrice();
    }

    public void executeDiscount() {
        BigDecimal discountFromPrice = discount.calculateDiscount(fullPrice);
        endPrice = fullPrice.subtract(discountFromPrice);
    }

    private void setFullPrice() {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < products.size(); i++) {
            sum = sum.add(products.get(i).getCost());
        }
        fullPrice = sum;
    }


    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public BigDecimal getEndPrice() {
        return endPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void addProduct(Product product) {
        products.add(product);
        setFullPrice();
    }
}
