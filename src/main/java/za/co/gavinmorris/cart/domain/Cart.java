package za.co.gavinmorris.cart.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private int id;
    private Map<String, Integer> basket = new HashMap<String, Integer>();
    private int number_of_items;

    public Cart(int id){
        this.id = id;
    }

    public Map<String,Integer> getBasket(){
        return this.basket;
    }

    public int getId() {
        return this.id;
    }

    public int getNumberOfItems(){
        int number_of_items = 0;

        for (int i : this.basket.values()){
            number_of_items += i;
        }
        return number_of_items;
    }

    public void addItem(String sku){
        if(this.basket.containsKey(sku)){
            int currentQuantity = this.basket.get(sku);
            this.basket.replace(sku,currentQuantity++);
        }
        else{
            this.basket.put(sku,1);
        }
    }

    public void removeItem(String sku){
        if(this.basket.containsKey(sku)){
            int currentQuantity = this.basket.get(sku);
            this.basket.replace(sku,currentQuantity--);
        }
        else{
            this.basket.remove(sku);
        }
    }

}
