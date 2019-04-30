package za.co.gavinmorris.cart.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;


public abstract class DiscountCalculator extends TotalCalculator{

    private double discount;
    private double total;

    private double applyDiscount(double total) {
        double discountTotal = total*(1-this.discount);
        return discountTotal;
    }

    abstract Boolean verifyDiscount(Cart cart);

    public void setTotal(Cart cart){
        double total = 0.0;

        if (cart.getNumberOfItems() == 0) {
            this.total = total;
        }
        else{
            total = this.calculateTotal(cart);
            if(this.verifyDiscount(cart)){
                this.total = this.applyDiscount(total);
            }
            else{
                this.total = total;
            }
        }
    }
}

