package za.co.gavinmorris.cart.domain;

import za.co.gavinmorris.cart.database.ItemDB;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Order {

    private String id;
    private TaxCalculator taxCalculator;
    private ItemDB itemDB;
    private Map<String,Cart> trolley = new HashMap<String, Cart>();

    public Order(String id) {
        this.id = id;
        this.itemDB = ItemDB.getInstance();
    }

    public Map<Cart,Double> getOrderTotal(){
        Map<Cart, Double> order = new HashMap<Cart, Double>();
        for(Cart cart: this.trolley.values()){
            this.taxCalculator.setTotal(cart);
            double total = taxCalculator.getTotal();
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
            this.addCart(cartID);
            return this.trolley.get(cartID);
        }
    }

    public Cart addItemToCart(String cartID, String itemID) {
        if (this.itemDB.getItem(itemID) != null) {
            this.getCart(cartID).addItem(itemDB.getItem(itemID));
            return this.getCart(cartID);
        } else {
            return null;
        }
    }

    public Cart removeItemFromCart(String cartID, String itemID){
        if (this.itemDB.getItem(itemID) != null) {
            this.getCart(cartID).removeItem(itemDB.getItem(itemID));
            return this.getCart(cartID);
        } else {
            return this.getCart(cartID);
        }
    }

    public Map<String, Cart> getTrolley() {
        return trolley;
    }

}

