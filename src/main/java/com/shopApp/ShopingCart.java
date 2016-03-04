package com.shopApp;

import com.shopApp.discounts.Discount;
import com.shopApp.discounts.NullDiscount;
import com.shopApp.specials.NullSale;
import com.shopApp.specials.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/3/16.
 */
public class ShopingCart {

    private Discount discount;
    private Sale sale;

    private List<Product> selectedProducts = new ArrayList<Product>();

    private BigDecimal fullPrice;
    private BigDecimal discountPrice;


    public ShopingCart(List<Product> selectedProducts) {
        discount = new NullDiscount();
        sale = new NullSale();
        this.selectedProducts = selectedProducts;
        setFullPrice();
    }

    public void executeDiscount() {
        BigDecimal discountFromPrice = discount.calculateDiscount(fullPrice);
        discountPrice = fullPrice.subtract(discountFromPrice);
    }

    public void acceptSale() {
        sale.acceptSale(selectedProducts);
    }

    private void setFullPrice() {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < selectedProducts.size(); i++) {
            sum = sum.add(selectedProducts.get(i).getPrice());
        }
        fullPrice = sum;
        discountPrice = fullPrice;
    }


    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public BigDecimal discountSize() {
        return fullPrice.subtract(discountPrice);
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
        setFullPrice();
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
        setFullPrice();
    }

    public void addProduct(Product product) {
        selectedProducts.add(product);
        setFullPrice();
    }
}
