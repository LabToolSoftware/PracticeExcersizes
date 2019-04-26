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
    float vat = 0.15;

    @Before
    public void setup(){
        cart = new Cart();
        item = new Item();
    }

    @Test
    public void shouldSetVAT(){
        cart.setVAT(this.vat);
        Assert.assertEquals(cart.getVAT(), this.vat);
    }
}
