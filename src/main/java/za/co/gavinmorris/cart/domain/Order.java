package za.co.gavinmorris.cart.domain;

import za.co.gavinmorris.cart.database.ItemDB;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Order {

    private String id;
    private TotalCalculator totalCalculator;
    private ItemDB itemDB;
    private Map<String,Cart> trolley = new HashMap<String, Cart>();


    public Order(String id) {
        this.id = id;
        this.itemDB = ItemDB.getInstance();
    }

    public Map<Cart,Double> getOrder(){
        Map<Cart, Double> order = new HashMap<Cart, Double>();
        for(Cart cart: this.trolley.values()){
            this.totalCalculator.setTotal(cart);
            double total = totalCalculator.getTotal();
            order.put(cart,total);
        }
        return order;
    }

    public void addCart(String cartID) {
        if(!this.trolley.containsKey(cartID)){
            this.trolley.put(cartID,new Cart(cartID));
        }
    }

    public Cart getCart(String cartID){
        if(this.trolley.containsKey(cartID)){
            return this.trolley.get(cartID);
        }
        else{
            return null;
        }
    }

    public Cart addItemToCart(String cartID, String itemID) {
        if (this.trolley.containsKey(cartID) & this.itemDB.getItem(itemID) != null) {
            this.trolley.get(cartID).addItem(itemDB.getItem(itemID));
            return this.trolley.get(cartID);
        } else {
            return null;
        }
    }

    public Cart removeItemFromCart(String cartID, String itemID){
            if (this.trolley.containsKey(cartID) & this.itemDB.getItem(itemID) != null) {
                this.trolley.get(cartID).removeItem(itemDB.getItem(itemID));
                return this.trolley.get(cartID);
            }
            else {
                return null;
            }
        }
}

