package com.shopApp;

import com.shopApp.discounts.Discount;
import com.shopApp.discounts.NoDiscount;
import com.shopApp.sales.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {
    private Discount discount;
    private Sale sale;

    private List<Product> selectedProducts;

    private BigDecimal fullPrice = BigDecimal.ZERO;
    private BigDecimal discountAmount = BigDecimal.ZERO;


    public ShoppingCartImpl(Discount discount, Sale sale) {
        this.discount = discount;
        this.sale = sale;
        this.selectedProducts = new ArrayList<Product>();
    }

    public void applyDiscount() {
        discountAmount = discount.calculateDiscount(fullPrice);
        calculateCost();
    }

    public void applySale() {
        sale.applySaleFor(this);
        calculateCost();
    }

    public BigDecimal getOriginalCost() {
        return fullPrice;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public BigDecimal getFinalCost() {
        return fullPrice.subtract(discountAmount);
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
        calculateCost();
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
        fullPrice = sumOfProductPrices();
        if(isDiscountExist()) {
            discountAmount = discount.calculateDiscount(fullPrice);
        }
    }

    private boolean isDiscountExist() {
        return !(discount instanceof NoDiscount);
    }

    private BigDecimal sumOfProductPrices() {
        BigDecimal sum = BigDecimal.ZERO;

        for(Product product : selectedProducts) {
            sum = sum.add(product.getPrice());
        }

        return sum;
    }
}
