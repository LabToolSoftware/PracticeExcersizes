package za.co.gavinmorris.cart.repository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.gavinmorris.cart.entity.Item;
import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{
    List<Item> findByName(String name);
}
