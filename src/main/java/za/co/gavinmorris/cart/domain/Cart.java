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
    private HashMap<Integer, Discountable> discountCalculators;
    private Integer discount;

    public Cart(int id){
        this.id = id;
        this.vat = 0.0;
    }

    public Map<Integer,Item> getBasket(){
        return this.basket;
    }

    public Integer getDiscount() {
        return discount;
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

    public double getTotal(){
        return total;
    }

    public double getVAT() {
        return vat;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setVAT(double vat) {
        this.vat = vat;
    }

    private double calculateTotal(){

        double total = 0;

        for (Item i : this.basket.values()){
            total += i.getCost()*(1+this.vat)*i.getQuantity();
        }
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

}
