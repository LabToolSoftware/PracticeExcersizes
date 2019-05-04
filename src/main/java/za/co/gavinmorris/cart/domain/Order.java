package za.co.gavinmorris.cart.domain;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import za.co.gavinmorris.cart.database.ItemDB;
import za.co.gavinmorris.cart.domain.discount.Discount;
import za.co.gavinmorris.cart.domain.tax.TaxCalculator;
import za.co.gavinmorris.cart.serializers.OrderSerializer;

import java.util.HashMap;
import java.util.Map;

@JsonSerialize(using = OrderSerializer.class)
public class Order {

    private String id;
    private TaxCalculator taxCalculator;
    private Discount cartDiscount;
    private ItemDB itemDB;
    private Map<String,Cart> trolley = new HashMap<String, Cart>();
    Map<Cart, Double> order = new HashMap<Cart, Double>();

    public Order(String id) {
        this.id = id;
        this.itemDB = ItemDB.getInstance();
    }

    public String getId() {
        return id;
    }

    public TaxCalculator getTaxCalculator() {
        return taxCalculator;
    }

    public void setTaxCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public Discount getCartDiscount() {
        return cartDiscount;
    }

    public void setCartDiscount(Discount cartDiscount) {
        this.cartDiscount = cartDiscount;
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

    public double getOrderTotal(){
        double orderTotal = 0.0;
        for(Cart cart: this.trolley.values()){
            double discountedTotal = this.cartDiscount.getDiscount(cart);
            orderTotal += taxCalculator.getTotalIncTax(discountedTotal);
        }
        return orderTotal;
    }
}

