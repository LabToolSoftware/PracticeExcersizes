package za.co.gavinmorris.cart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.database.ItemDB;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Order;

public class OrderTest {

    Order order;

    @Before
    public void setup(){
        this.order = new Order("test");
    }

    @Test
    public void shouldAddCartToOrder(){
        this.order.addCart("test");
        Assert.assertEquals(this.order.getCart("test").getId(),"test");
    }

    @Test
    public void shouldAddItemToCart(){
        this.order.addCart("test");
        Cart cart = this.order.addItemToCart("test","abcd");
        Assert.assertEquals(cart.getNumberOfItems(),1);
    }
}
