package za.co.gavinmorris.cart.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.domain.Cart;

public class CartServiceTest {

    CartService cartService;
    Cart cart;

    @Before
    public void setup(){
        this.cartService = new CartService();
        this.cartService.add("test");
        this.cartService.addItem("test","test");
    }

    @Test
    public void shouldAddCartToRepository(){
        Assert.assertEquals(this.cartService.get("test").getId(),"test");
    }

    @Test
    public void shouldAddItemToCart(){
        Cart cart = this.cartService.addItem("test","abcd");
        Assert.assertEquals(cart.getNumberOfItems(),1);
    }
}
