package za.co.gavinmorris.cart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.co.gavinmorris.cart.entity.Item;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{

    void delete(Item deleted);

    List<Item> findAll();

    Optional<Item> findOne(Long id);

    Item save(Item persisted);
}
