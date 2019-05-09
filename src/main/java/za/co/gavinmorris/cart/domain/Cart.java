package za.co.gavinmorris.cart.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import za.co.gavinmorris.cart.serializer.CartSerializer;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@JsonSerialize(using = CartSerializer.class)
@Entity
public class Cart {

    @Id
    private Long cartID;
    private Map<Item, Integer> basket = new HashMap<Item, Integer>();
    private double total;
    private int numberOfItems = 0;

    public Cart(Long id){
        this.cartID = id;
        this.total = 0.0;
    }

    public Map<Item,Integer> getBasket(){
        return this.basket;
    }

    public Long getId() {
        return this.cartID;
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }

    public void addItem(Item item){
        if(this.basket.containsKey(item)) {
                int currentQuantity = this.basket.get(item);
                this.basket.put(item, currentQuantity+1);
                this.total += item.getCost()*(1-item.getDiscountPerc());
                this.numberOfItems += 1;
            }
            else{
                this.numberOfItems += 1;
                this.total += item.getCost()*(1-item.getDiscountPerc());
                this.basket.put(item,1);
        }
    }

    public void removeItem(Item item){
        if (this.basket.get(item) > 1) {
            int currentQuantity = this.basket.get(item);
            this.basket.put(item, currentQuantity-1);
            this.total -= item.getCost()*(1-item.getDiscountPerc());
            this.numberOfItems -= 1;
        }
        else{
            this.total -= item.getCost()*(1-item.getDiscountPerc());
            this.numberOfItems -= 1;
            this.basket.remove(item);
            }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
