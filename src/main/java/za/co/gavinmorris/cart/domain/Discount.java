package za.co.gavinmorris.cart.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;

interface CalculateDiscount{
    double getDiscountTotal(Cart cart);
}

public abstract class Discount implements CalculateDiscount{

    private double discount;
    private double total;

    double applyDiscount(double total) {
        double discountTotal = total * (1 - this.discount);
        return discountTotal;
    }

    abstract Boolean verifyDiscount(Cart cart);

    public double getDiscountTotal(Cart cart) {
        double total = 0.0;

        if (cart.getNumberOfItems() > 0) {
            if (this.verifyDiscount(cart)) {
                this.total = this.applyDiscount(cart.getTotal());
                return total;
            } else {
                return cart.getTotal();
            }
        } else {
            return total;
        }
    }
}

