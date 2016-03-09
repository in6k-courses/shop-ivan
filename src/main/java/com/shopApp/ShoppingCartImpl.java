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

    private BigDecimal originalCost = BigDecimal.ZERO;
    private BigDecimal discountAmount = BigDecimal.ZERO;


    public ShoppingCartImpl(Discount discount, Sale sale) {
        this.discount = discount;
        this.sale = sale;
        this.selectedProducts = new ArrayList<Product>();
        calculateCost();
    }

    public void applyDiscount(Discount discount) {
        setDiscount(discount);
        discountAmount = discount.calculateDiscount(originalCost);
        calculateCost();
    }

    public void applySale(Sale sale) {
        setSale(sale);
        sale.applySaleFor(this);
        calculateCost();
    }

    private void calculateCost() {
        originalCost = calculateOriginalCost();
        discountAmount = discount.calculateDiscount(originalCost);
    }

    private void setDiscount(Discount discount) {
        this.discount = discount;
    }

    private void setSale(Sale sale) {
        this.sale = sale;
    }

    public BigDecimal getFinalCost() {
        return originalCost.subtract(discountAmount);
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void addProduct(Product product) {
        selectedProducts.add(product);
        calculateCost();
    }

    public void addProducts(List<Product> products) {
        selectedProducts.addAll(products);
        calculateCost();
    }

    private BigDecimal calculateOriginalCost() {
        BigDecimal sum = BigDecimal.ZERO;
        for(Product product : selectedProducts) {
            sum = sum.add(product.getPriceWithDiscount());
        }
        return sum;
    }
}
