package za.co.gavinmorris.cart.repository;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import za.co.gavinmorris.cart.domain.Item;

public class ItemRepositoryTest {

    private ItemRepository itemRepository;

    @Before
    public void setup(){
        this.itemRepository = new ItemRepository();
    }

    @Test
    public void shouldGetItemFromDB(){
        Item item = itemRepository.find("abcd");
        Assert.assertEquals(item.getSku(),"abcd");
    }
}
