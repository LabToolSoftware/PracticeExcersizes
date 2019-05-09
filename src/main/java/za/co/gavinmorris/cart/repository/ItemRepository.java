package za.co.gavinmorris.cart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.co.gavinmorris.cart.domain.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Repository
public class ItemRepository implements CrudRepository<Item,Long> {

    private Map<Long, Item> items = new HashMap<Long,Item>();

    public ItemRepository(){
        Item item1 = new Item("abcd","Item1","Item1 Description",1.00,0.00);
        Item item2 = new Item("abcde","Item2","Item2 Description",2.00,0.00);
        Item item3 = new Item("abcdef", "Item3","Item3 Description",3.00,0.00);
        Item item4 = new Item("abcdefg", "Item4","Item4 Description",4.00,0.00);
        Item item5 = new Item("abcdefgh", "Item5","Item5 Description",5.00,0.00);

        items.put(item1.getSku(),item1);
        items.put(item2.getSku(),item2);
        items.put(item3.getSku(),item3);
        items.put(item4.getSku(),item4);
        items.put(item5.getSku(),item5);
    }

    public Item find(String id) {
        if(this.items.containsKey(id)){
            return items.get(id);
        }
        else{
            return null;
        }
    }

    public void save(Item item) {
        items.put(item.getSku(),item);
    }

    public void remove(String id) {
        items.remove(id);
    }

    public <S extends Item> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    public Optional<Item> findById(Long aLong) {
        return Optional.empty();
    }

    public boolean existsById(Long aLong) {
        return false;
    }

    public Iterable<Item> findAll() {
        return null;
    }

    public Iterable<Item> findAllById(Iterable<Long> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {

    }

    public void delete(Item item) {

    }

    public void deleteAll(Iterable<? extends Item> iterable) {

    }

    public void deleteAll() {

    }
}
