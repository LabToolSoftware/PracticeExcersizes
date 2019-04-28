package za.co.gavinmorris.cart.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void addItem(Item item){
        if(this.basket.containsKey(item.getId())){
            Item existing_item = this.basket.get(item.getId());
            existing_item.setQuantity(existing_item.getQuantity()+1);
        }
        else{
            this.basket.put(item.getId(),item);
        }
        this.total = calculateTotal();
    }

    public void removeItem(int itemId){
        if(this.basket.containsKey(itemId)){
            Item existing_item = this.basket.get(itemId);
            if(existing_item.getQuantity() > 1){
                existing_item.setQuantity(existing_item.getQuantity()-1);
                this.total = calculateTotal();
            }
            else{
                this.basket.remove(itemId);
                this.total = calculateTotal();
            }
        }
    }

    public Map<Integer,Item> getBasket(){
        return this.basket;
    }
}
