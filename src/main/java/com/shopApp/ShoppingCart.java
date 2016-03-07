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
public class ShoppingCart {

    private Discount discount;
    private Sale sale;

    private List<Product> selectedProducts = new ArrayList<Product>();

    private BigDecimal fullPrice = BigDecimal.ZERO;
    private BigDecimal discountSize = BigDecimal.ZERO;


    public ShoppingCart(List<Product> selectedProducts) {
        this.discount = new NullDiscount();
        this.sale = new NullSale();
        this.selectedProducts = selectedProducts;
        changePrices();
    }

    public void acceptDiscount() {
        discountSize = discount.calculateDiscount(fullPrice);
        changePrices();
    }

    public void acceptSale() {
        sale.acceptSaleFor(this);
        changePrices();
    }

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public BigDecimal getDiscountSize() {
        return discountSize;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public BigDecimal getDiscountPrice() {
        return fullPrice.subtract(discountSize);
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
        changePrices();
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
        changePrices();
    }

    public void addProduct(Product product) {
        selectedProducts.add(product);
        changePrices();
    }

    private void changePrices() {
        fullPrice = sumOfProductPrices();
        if(isDiscountExist()) {
            discountSize = discount.calculateDiscount(fullPrice);
        }
    }

    private boolean isDiscountExist() {
        return !(discount instanceof NullDiscount);
    }

    private BigDecimal sumOfProductPrices() {
        BigDecimal sum = BigDecimal.ZERO;

        for(Product product : selectedProducts) {
            sum = sum.add(product.getPrice());
        }

        return sum;
    }

}
