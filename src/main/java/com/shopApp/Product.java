package com.shopApp;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public class Product {
    private String name;
    private BigDecimal cost;

    public Product(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
