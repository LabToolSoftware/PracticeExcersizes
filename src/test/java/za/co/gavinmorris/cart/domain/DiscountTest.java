package za.co.gavinmorris.cart.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.domain.*;
import za.co.gavinmorris.cart.domain.discount.Discount;
import za.co.gavinmorris.cart.domain.discount.MinimumNumberDiscount;

public class DiscountTest {


    private Cart cart;
    private Item item;
    private Discount calculator;
    private double delta = 0.01;

    @Before
    public void setup(){
        cart = new Cart("test");
        item = new Item("sku","name","description",1.00,0.0);
        cart.addItem(item);
        cart.addItem(item);
        cart.addItem(item);
        cart.addItem(item);
        cart.addItem(item);
        cart.addItem(item);

        calculator = new MinimumNumberDiscount();
    }


    @Test
    public void shouldTestDiscountVerify(){
        Assert.assertEquals(this.calculator.verifyDiscount(cart),true);
    }

    @Test
    public void shouldTestGetDiscount(){
        Assert.assertEquals(this.calculator.getDiscount(cart),4.8,delta);
    }

}

