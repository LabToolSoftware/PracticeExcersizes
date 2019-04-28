package za.co.gavinmorris.cart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;


public class CartTest {

    private Cart cart;
    private Item item;
    private Item item2;
    int id = 0;
    double initVat = 0.15;
    double delta = 0.0001;


    @Before
    public void setup(){
        this.cart = new Cart(this.id);
        this.item = new Item("abcd","Test item1","Test item description",1.0);
        this.item2 = new Item("abcdef","Test item1","Test item description",1.0);

    }

    @Test
    public void shouldCalculateNumberOfItems(){
        this.cart.addItem(this.item);
        this.cart.addItem(this.item);
        this.cart.addItem(this.item);
        this.cart.addItem(this.item2);
        Assert.assertEquals(this.cart.getNumberOfItems(),4);
    }

    @Test
    public void shouldRemoveItem(){
        this.cart.addItem(this.item);
        this.cart.addItem(this.item);

        this.cart.removeItem(this.item.getSku());
        Assert.assertEquals(this.cart.getNumberOfItems(),1);
    }

}
