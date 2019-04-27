package za.co.gavinmorris.cart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.Cart;

import java.util.Arrays;
import java.util.List;


public class CartTest {

    private Cart cart;
    private Item item;
    int id = 0;
    double initVat = 0.15;
    double delta = 0.0001;


    @Before
    public void setup(){
        this.cart = new Cart(this.id,this.initVat);
        this.item = new Item("Test item1","Test item description",1.0);
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
}