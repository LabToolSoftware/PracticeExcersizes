package za.co.gavinmorris.cart.web;

import org.springframework.web.bind.annotation.*;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    Cart cart;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Cart getCart(){
        this.cart = new Cart(101);
        this.cart.setVAT(0.15);
        return this.cart;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.POST)
    public Cart addItem(@PathVariable String id){
        Item item = new Item(Integer.parseInt(id),"TestItem1","TestItem1Description",1.00);
        this.cart.addItem(item);
        return this.cart;
    }


}
