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
        this.cart.setVAT(this.initVat);
        this.item = new Item(0,"Test item1","Test item description",1.0);
        this.item2 = new Item(1,"Test item1","Test item description",1.0);

    }

    @Test
    public void shouldSetVAT(){
        double newVat = 0.16;
        cart.setVAT(newVat);
        Assert.assertEquals(cart.getVAT(), newVat,delta);
    }

    @Test
    public void ShouldAddItemToCart(){
        this.cart.addItem(this.item);
        this.cart.addItem(this.item);

        Assert.assertEquals(this.cart.getNumberOfItems(),2);
    }

    @Test
    public void ShouldCalculateCartTotal(){
        this.cart.addItem(this.item);
        Assert.assertEquals(this.cart.getTotal(),1.15,this.delta);
    }

    @Test
    public void shouldCalculateNumberOfItems(){
        this.cart.addItem(this.item);
        this.cart.addItem(this.item);
        this.cart.addItem(this.item2);
        Assert.assertEquals(this.cart.getNumberOfItems(),3);
    }
}
