package za.co.gavinmorris.cart;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import za.co.gavinmorris.cart.database.ItemDB;
import za.co.gavinmorris.cart.domain.Item;

public class ItemDBTest {

    private ItemDB itemDB;

    @Before
    public void setup(){
        this.itemDB = ItemDB.getInstance();
    }

    @Test
    public void shouldGetItemFromDB(){
        Item item = itemDB.getItem("abcd");
        Assert.assertEquals(item.getSku(),"abcd");
    }
}
