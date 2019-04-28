package za.co.gavinmorris.cart.domain;


interface Discountable{
    public double applyDiscount(double total);
}
public class Discount implements Discountable{

    public double applyDiscount(double total) {
        return total;
    }
}
