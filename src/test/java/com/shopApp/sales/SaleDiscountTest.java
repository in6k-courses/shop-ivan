package com.shopApp.sales;

import com.shopApp.Product;
import com.shopApp.ShoppingCart;
import com.shopApp.ShoppingCartFactory;
import com.shopApp.ShoppingCartImpl;
import com.shopApp.discounts.Discount;
import com.shopApp.discounts.NoDiscount;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SaleDiscountTest {

    private Sale sale;
    private List<Product> saleProducts = Collections.EMPTY_LIST;
    private int discountPercent = 10;

    public SaleDiscountTest() {
        saleProducts = ShoppingCartFactory.getSaleProducts();
        sale = new DiscountSale(saleProducts, discountPercent);
    }

    @Test
    public void testTakeParticipationInSaleDiscount() {
        ShoppingCart shoppingCart = new ShoppingCartImpl(NoDiscount.NoDiscount, NoSale.NoSale);
        shoppingCart.addProducts(ShoppingCartFactory.getProductsSet());
        shoppingCart.applySale(sale);

        List<Product> cartProducts = shoppingCart.getSelectedProducts();

        for (Product product : cartProducts) {
            if (product.hasDiscount()) {
                assertThat(product.getPriceWithDiscount(), is(calculatePriceWithDiscount(product)));
            }
        }
    }

    private BigDecimal calculatePriceWithDiscount(Product product) {
        BigDecimal discountAmount = percentFromPrice(new BigDecimal(discountPercent), product.getPrice());
        BigDecimal priceWithDiscount = product.getPrice().subtract(discountAmount);
        return priceWithDiscount;
    }

    private BigDecimal percentFromPrice(BigDecimal percent, BigDecimal price) {
        BigDecimal oneHundred = new BigDecimal(Discount.HUNDRED_PERCENT);
        BigDecimal discountAmount = (price.multiply(percent)).divide(oneHundred);
        return discountAmount;
    }

}
