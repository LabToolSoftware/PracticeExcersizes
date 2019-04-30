package za.co.gavinmorris.cart.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private String id;
    private Map<Item, Integer> basket = new HashMap<Item, Integer>();
    private int number_of_items;

    public Cart(String id){
        this.id = id;
    }

    public Map<Item,Integer> getBasket(){
        return this.basket;
    }

    public String getId() {
        return this.id;
    }

    public int getNumberOfItems(){
        int number_of_items = 0;

        for (int i : this.basket.values()){
            number_of_items += i;
        }
        return number_of_items;
    }

    public void addItem(Item item){
        if(this.basket.containsKey(item)){
            int currentQuantity = this.basket.get(item);
            this.basket.replace(item,currentQuantity++);
        }
        else{
            this.basket.put(item,1);
        }
    }

    public void removeItem(Item item){
        if(this.basket.containsKey(item)){
            int currentQuantity = this.basket.get(item);
            this.basket.replace(item,currentQuantity--);
        }
        else{
            this.basket.remove(item);
        }
    }

}
