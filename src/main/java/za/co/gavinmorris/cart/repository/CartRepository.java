package za.co.gavinmorris.cart.repository;

import org.springframework.stereotype.Component;
import za.co.gavinmorris.cart.entity.Cart;

import java.util.HashMap;
import java.util.Map;


@Component
public class CartRepository implements CustomRepository<Cart> {

    Map<String, Cart> carts = new HashMap<String, Cart>();


    public Cart find(String id) {
        return carts.get(id);
    }

    public void save(Cart cart) {
        carts.put(cart.getId(), cart);
    }

    public void remove(String id) {
        carts.remove(id);
    }
}
