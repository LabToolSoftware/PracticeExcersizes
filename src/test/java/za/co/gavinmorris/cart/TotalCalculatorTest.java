package za.co.gavinmorris.cart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;
import za.co.gavinmorris.cart.domain.TotalCalculator;

public class TotalCalculatorTest {

    private Cart cart;
    private Item item;
    private Item item2;
    private TotalCalculator calculator;
    private double delta = 0.0;

    @Before
    public void setup(){
        this.cart = new Cart(0);
        this.item = new Item("abcd","Test item1","Test item description",1.0);
        this.item2 = new Item("acbdef","Test item1","Test item description",1.0);
        this.cart.addItem(item);
        this.calculator = new TotalCalculator();
    }

    @Test
    public void shouldSetVAT(){
        double vat = 0.16;
        this.calculator.setVat(vat);
        Assert.assertEquals(this.calculator.getVat(), vat,delta);
    }

    @Test
    public void ShouldCalculateCartTotal(){
        double vat = 0.16;
        this.calculator.setVat(vat);
        this.calculator.setTotal(this.cart);
        Assert.assertEquals(this.calculator.getTotal(),1.16,this.delta);
    }
}
