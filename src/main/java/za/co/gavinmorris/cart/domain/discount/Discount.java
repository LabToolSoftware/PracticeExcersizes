package za.co.gavinmorris.cart.domain.discount;

import com.sun.org.apache.xpath.internal.operations.Bool;
import za.co.gavinmorris.cart.domain.Cart;

public abstract class Discount{

    private double discount;

    double applyDiscount(double total) {
        double discountTotal = total * (1 - this.discount);
        return discountTotal;
    }

    public Boolean verifyDiscount(Cart cart){
        return false;
    };

    public double getDiscount(Cart cart) {
        double total = 0.0;

        if (cart.getNumberOfItems() > 0) {
            if (verifyDiscount(cart)) {
                total = applyDiscount(cart.getTotal());

                return total;
            } else {
                return cart.getTotal();
            }
        } else {
            return cart.getTotal();
        }
    }
}

