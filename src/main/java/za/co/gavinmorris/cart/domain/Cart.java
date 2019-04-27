package za.co.gavinmorris.cart.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private int id;
    private double vat;
    private Map<Integer, Item> basket = new HashMap<Integer, Item>();
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
            total += i.getCost()*(1+this.vat)*i.getQuantity();
        }
        return total;
    }

    public double getTotal(){
        return total;
    }

    public void addItem(@org.jetbrains.annotations.NotNull Item item){
        if(this.basket.containsKey(item.getId())){
            this.basket.get(item.getId()).setQuantity(item.getQuantity()+1);
        }
        else{
            this.basket.put(item.getId(),item);
        }
        this.total = calculateTotal();
    }

    public void removeItem(String name){
        if(this.basket.containsKey(name)){
            this.basket.remove(name);
        }
    }

    public ArrayList<Item> getBasket(){
        ArrayList<Item> items = new ArrayList<Item>();
        for(Item i : this.basket.values()){
            items.add(i);
        }
        return items;
    }
}
