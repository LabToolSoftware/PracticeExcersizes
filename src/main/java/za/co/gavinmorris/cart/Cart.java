package za.co.gavinmorris.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int id;
    private double vat;
    private HashMap<String, Item> basket = new HashMap<String, Item>();;
    private double total;
    private int number_of_items;

    public void Cart(int id, double vat){
        this.id = id;
        this.vat = vat;
    }

    public double getVAT() {
        return vat;
    }

    public void setVAT(double vat) {
        this.vat = vat;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfItems(HashMap<String, Item> basket){
        int number_of_items = 0;

        for (Item i : basket.values()){
            number_of_items = number_of_items + i.getQuantity();
        }

        return basket.size();
    }

    private double calculateTotal(HashMap<String, Item> basket, double vat){

        double total = 0;

        for (Item i : basket.values()){
            total = total + i.getCost()*vat;
        }
        return total;
    }

    public double getTotal(){
            if(!this.basket.isEmpty()){
                return total;
            }
            else{
                return 0;
            }
    }

    public void addItem(Item item){
        if(this.basket.containsKey(item.getName())){
            this.basket.get(item.getName()).setQuantity(item.getQuantity()+1);
        }
        else{
            this.basket.put(item.getName(),item);
        }

        this.total = calculateTotal(this.basket,this.vat);
        this.number_of_items++;
    }

    public void removeItem(String name){
        if(this.basket.containsKey(name)){
            this.basket.remove(name);
        }
    }
}
