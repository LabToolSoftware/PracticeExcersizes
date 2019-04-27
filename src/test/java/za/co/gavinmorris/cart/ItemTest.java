package za.co.gavinmorris.cart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.gavinmorris.cart.domain.Item;

public class ItemTest {

    int newQuantity = 2;
    Item item;

    @Before
    public void setup(){
        this.item = new Item(0,"Test item1","Test item description",1.0);
    }

    @Test
    public void ShouldSetQuantity(){
        this.item.setQuantity(this.newQuantity);
        Assert.assertEquals(this.item.getQuantity(),this.newQuantity);
    }

}
