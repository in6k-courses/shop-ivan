package com.shopApp;

import com.shopApp.discounts.Discount;
import com.shopApp.sales.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {
    private Discount discount;
    private Sale sale;

    private List<Product> selectedProducts;

    private BigDecimal originalPrice = BigDecimal.ZERO;
    private BigDecimal discountAmount = BigDecimal.ZERO;


    public ShoppingCartImpl(Discount discount, Sale sale) {
        this.discount = discount;
        this.sale = sale;
        this.selectedProducts = new ArrayList<Product>();
        calculateCost();
    }

    public void applyDiscount() {
        discountAmount = discount.calculateDiscount(originalPrice);
        calculateCost();
    }

    public void applySale() {
        sale.applySaleFor(this);
        calculateCost();
    }

    public BigDecimal getOriginalCost() {
        return originalPrice;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public BigDecimal getFinalCost() {
        return originalPrice.subtract(discountAmount);
    }

    public Discount getDiscount() {
        return discount;
    }

    public void addProduct(Product product) {
        selectedProducts.add(product);
        calculateCost();
    }

    public void addProducts(List<Product> products) {
        selectedProducts.addAll(products);
        calculateCost();
    }

    private void calculateCost() {
        originalPrice = updateOriginalCost();
        discountAmount = discount.calculateDiscount(originalPrice);
    }

    private boolean isDiscount() {
        return !(discount == null);
    }

    private BigDecimal updateOriginalCost() {
        BigDecimal sum = BigDecimal.ZERO;

        for(Product product : selectedProducts) {
            sum = sum.add(product.getPriceWithDiscount());
        }
        return sum;
    }
}
