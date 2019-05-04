package za.co.gavinmorris.cart.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.database.ItemDB;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.services.CartService;

public class CartServiceTest {

    CartService order;

    @Before
    public void setup(){
        this.order = new CartService();
    }

    @Test
    public void shouldAddCartToOrder(){
        this.order.add("test");
        Assert.assertEquals(this.order.get("test").getId(),"test");
    }

    @Test
    public void shouldAddItemToCart(){
        this.order.add("test");
        Cart cart = this.order.addItem("test","abcd");
        Assert.assertEquals(cart.getNumberOfItems(),1);
    }
}
