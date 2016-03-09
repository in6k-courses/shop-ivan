package com.shopApp;

import java.math.BigDecimal;

public class Product {
    private String title;
    private BigDecimal price;
    private BigDecimal discount;

    public Product(String title, BigDecimal price) {
        this.title = title;
        this.discount = BigDecimal.ZERO;
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithDiscount() {
        return price.subtract(discount);
    }

    public void setPrice(BigDecimal price) throws IllegalArgumentException {
        if (price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public boolean hasDiscount() {
        if(discount.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        }
        return false;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!title.equals(product.title)) return false;
        return price.equals(product.price);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
    
}
