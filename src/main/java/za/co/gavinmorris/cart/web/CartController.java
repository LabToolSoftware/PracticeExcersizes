package za.co.gavinmorris.cart.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;

@RestController
public class CartController {

    Cart cart;

    @RequestMapping(value = "/cart",method = RequestMethod.GET)
    public Cart getCart(){
        this.cart = new Cart(0);
        return this.cart;
    }

    @RequestMapping(value="/cart/{id}",method = RequestMethod.POST)
    public Cart addItem(){
        Item item = new Item("TestItem1","TestItem1Description",1.00);
        this.cart.addItem(item);
        return this.cart;
    }


}
