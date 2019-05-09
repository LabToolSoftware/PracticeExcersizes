package za.co.gavinmorris.cart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.co.gavinmorris.cart.domain.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
@Repository
public class CartRepository implements CrudRepository<Cart,Long> {

    Map<Long, Cart> carts = new HashMap<Long, Cart>();

    public <S extends Cart> S save(S s) {
        return null;
    }

    public <S extends Cart> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    public Optional<Cart> findById(Long aLong) {
        return Optional.empty();
    }

    public boolean existsById(Long aLong) {
        return false;
    }

    public Iterable<Cart> findAll() {
        return null;
    }

    public Iterable<Cart> findAllById(Iterable<Long> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {

    }

    public void delete(Cart cart) {

    }

    public void deleteAll(Iterable<? extends Cart> iterable) {

    }

    public void deleteAll() {

    }
}
