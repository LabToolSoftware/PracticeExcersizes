package za.co.gavinmorris.cart.domain.discount;

import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.discount.Discount;

public class MinimumNumberDiscount extends Discount {

    private int thresholdNumber;
    private double discount;
    private double total;

    public MinimumNumberDiscount(int thresholdNumber,double discount) {
        this.thresholdNumber = thresholdNumber;
        this.discount = discount;
    }

    @Override
    double applyDiscount(double total) {
        double discountTotal = total * (1 - this.discount);
        return discountTotal;
    }

    @Override
    public Boolean verifyDiscount(Cart cart){
        if(cart.getNumberOfItems() > this.thresholdNumber){
            return true;
        }
        else{
            return false;
        }
    }
}
