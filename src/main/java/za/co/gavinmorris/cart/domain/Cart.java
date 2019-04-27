package za.co.gavinmorris.cart.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private int id;
    private double vat;
    private Map<String, Item> basket = new HashMap<String, Item>();
    private double total;
    private int number_of_items;

    public Cart(int id){
        this.id = id;
        this.vat = 0.0;
    }

    public double getVAT() {
        return vat;
    }

    public void setVAT(double vat) {
        this.vat = vat;
    }

    public int getId() {
        return this.id;
    }

    public int getNumberOfItems(){
        int number_of_items = 0;

        for (Item i : this.basket.values()){
            number_of_items += i.getQuantity();
        }
        return number_of_items;
    }

    private double calculateTotal(){

        double total = 0;

        for (Item i : this.basket.values()){
            total += i.getCost()*(1+this.vat);
        }
        return total;
    }

    public double getTotal(){
        return total;
    }

    public void addItem(@org.jetbrains.annotations.NotNull Item item){
        if(this.basket.containsKey(item.getName())){
            this.basket.get(item.getName()).setQuantity(item.getQuantity()+1);
        }
        else{
            this.basket.put(item.getName(),item);
        }
        this.total = calculateTotal();
    }

    public void removeItem(String name){
        if(this.basket.containsKey(name)){
            this.basket.remove(name);
        }
    }
}
