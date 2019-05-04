package za.co.gavinmorris.cart.database;

import org.springframework.stereotype.Component;
import za.co.gavinmorris.cart.domain.Item;

import java.util.HashMap;
import java.util.Map;

@Component
public class ItemDB{

    private Map<String, Item> items = new HashMap<String,Item>();

    public ItemDB(){
        Item item1 = new Item("abcd","Item1","Item1 Description",1.00,0.00);
        Item item2 = new Item("abcde","Item2","Item2 Description",2.00,0.00);
        Item item3 = new Item("abcdef", "Item3","Item3 Description",3.00,0.00);
        Item item4 = new Item("abcdefg", "Item4","Item4 Description",4.00,0.00);
        Item item5 = new Item("abcdefgh", "Item5","Item5 Description",5.00,0.00);

        items.put(item1.getSku(),item1);
        items.put(item2.getSku(),item2);
        items.put(item3.getSku(),item3);
        items.put(item4.getSku(),item4);
        items.put(item5.getSku(),item5);
    }

    public Item getItem(String itemID) {
        if(this.items.containsKey(itemID)){
            return items.get(itemID);
        }
        else{
            return null;
        }
    }
}
