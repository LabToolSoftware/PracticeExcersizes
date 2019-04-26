import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private int id;
    private float vat;
    private List<Item> basket;
    private float total;
    private int number_of_items;
    Currency currency;

    public void Cart(int id, float vat){
        this.id = id;
        this.vat = vat;
        this.basket = new ArrayList<Item>();
    }

    public int getId() {
        return id;
    }

    public int numberOfItems(List<Item> items){
        int number_of_items = 0;

        for (int i =0; i < items.size();i++){
            number_of_items = number_of_items + items.get(i).getQuantity();
        }

        return basket.size();
    }

    private float calculateTotal(List<Item> items, float vat){

        float total = 0;

        for(int i = 0; i < items.size(); i++){
            total = total + items.get(i).getCost()*vat;
        }
        return total;
    }

    public float getTotal(){
            if(!this.basket.isEmpty()){
                return total;
            }
            else{
                return 0;
            }
    }

    public void addItem(Item item){
        this.basket.add(item);
        this.total = calculateTotal(this.basket,this.vat);
        this.number_of_items++;
    }
}

enum Currency{
    USD,GBP,ZAR
}