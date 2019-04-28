package za.co.gavinmorris.cart.domain;

import java.util.HashMap;
import java.util.Map;

interface CalculateTotal{
    double getTotal();
    void setTotal(Cart cart);
}

public class TotalCalculator implements CalculateTotal{

    private double vat;
    private double total;
    private HashMap<String,Item> itemDb;

    public double getTotal() {
        return this.total;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    protected double calculateTotal(Cart cart){
        double total = 0.0;
        Map<String,Integer> basket = cart.getBasket();
        for(String i: basket.keySet()){
            total += i.getCost()*basket.get(i)*(1+this.vat);
        }
        return total;
    }

    public void setTotal(Cart cart){
        if (cart.getNumberOfItems() == 0) {
            this.total = 0.0;
        }
        else {
            this.total = this.calculateTotal(cart);
        }
    }
}

