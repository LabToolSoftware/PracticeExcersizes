package za.co.gavinmorris.cart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.domain.*;

public class DiscountCalculatorTest {


    private Cart cart;
    private Item item;
    private DiscountCalculator calculator;
    private double delta = 0.0;

    @Before
    public void setup(){
        this.cart = new Cart(0);
        this.item = new Item("abcd","Test item1","Test item description",1.0);
        this.calculator = new MinimumNumberDiscount(2,0.2);
    }

    @Test
    public void ShouldSetVat(){
        double vat = 0.16;
        this.calculator.setVat(vat);
        Assert.assertEquals(this.calculator.getVat(),vat,delta);
    }

    @Test
    public void ShouldCalculateDiscountCartTotal(){
        this.cart.addItem(item);
        this.cart.addItem(item);
        this.cart.addItem(item);
        this.cart.addItem(item);
        this.cart.addItem(item);

        double vat = 0.16;
        this.calculator.setVat(vat);
        this.calculator.setTotal(this.cart);

        Assert.assertEquals(this.calculator.getTotal(),4.0,this.delta);
    }
}
