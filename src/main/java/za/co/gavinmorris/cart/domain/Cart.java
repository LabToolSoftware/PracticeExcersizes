package za.co.gavinmorris.cart.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;
import za.co.gavinmorris.cart.serializers.CartSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@JsonSerialize(using = CartSerializer.class)
public class Cart {

    private String id;
    private Map<Item, Integer> basket = new HashMap<Item, Integer>();
    private double total;
    private int numberOfItems = 0;

    public Cart(String id){
        this.id = id;
        this.total = 0.0;
    }

    public Map<Item,Integer> getBasket(){
        return this.basket;
    }

    public String getId() {
        return this.id;
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }

    public void addItem(Item item){
        if(this.basket.containsKey(item)) {
                int currentQuantity = this.basket.get(item);
                this.basket.put(item, currentQuantity+1);
                this.total += item.getCost();
                this.numberOfItems += 1;
            }
            else{
                this.numberOfItems += 1;
                this.total += item.getCost();
                this.basket.put(item,1);
        }
    }

    public void removeItem(Item item){
        if(this.basket.containsKey(item)) {
            if (this.basket.get(item) > 1) {
                int currentQuantity = this.basket.get(item);
                this.basket.put(item, currentQuantity-1);
                this.total -= item.getCost();
                this.numberOfItems -= 1;
            }
            else{
                this.total -= item.getCost();
                this.numberOfItems -= 1;
                this.basket.remove(item);
            }
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart {ID: " + id + ", Basket: " +basket+", NumberOfItems: "+numberOfItems+", Total: " +total+ " }";
    }
}
