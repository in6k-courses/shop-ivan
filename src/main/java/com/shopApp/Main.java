package com.shopApp;

import java.math.BigDecimal;

/**
 * Created by employee on 3/3/16.
 */
public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("150.3");
        BigDecimal bigDecimal2 = new BigDecimal("150.7");
        System.out.println(bigDecimal.add(bigDecimal2));
    }
}
