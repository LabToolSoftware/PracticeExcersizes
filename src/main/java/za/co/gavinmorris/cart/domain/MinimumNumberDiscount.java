package za.co.gavinmorris.cart.domain;

public class MinimumNumberDiscount extends Discount{

    private int thresholdNumber;
    private double discount;
    private double total;

    public MinimumNumberDiscount(int thresholdNumber,double discount) {
        this.thresholdNumber = thresholdNumber;
        this.discount = discount;
    }

    Boolean verifyDiscount(Cart cart){
        if(cart.getNumberOfItems() > this.thresholdNumber){
            return true;
        }
        else{
            return false;
        }
    }

}
