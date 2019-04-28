package za.co.gavinmorris.cart.web;

import org.springframework.web.bind.annotation.*;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    HashMap<Integer,Cart> carts = new HashMap<Integer, Cart>();

    @RequestMapping(value="",method=RequestMethod.GET)
    public HashMap<Integer,Cart> getAllCarts(){
        return carts;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Cart getCart(@PathVariable String id){
        int parsedId = Integer.parseInt(id);

        if(carts.containsKey(parsedId)){
            return carts.get(parsedId);
        }
        else{
            Cart cart = new Cart(parsedId);
            carts.put(parsedId,cart);
            cart.setVAT(0.15);
            return cart;
        }
    }

    @RequestMapping(value="/{id}/items/{item_id}",method = RequestMethod.POST)
    public Cart addItemToCart(@PathVariable String id,@PathVariable String item_id){
        Item item = new Item(Integer.parseInt(item_id),"Testname","TestItem1Description",1.00);
        Cart cart = this.getCart(id);
        cart.addItem(item);
        return cart;
    }

    @RequestMapping(value="/{id}/items/{item_id}",method = RequestMethod.DELETE)
    public Cart removeItemFromCart(@PathVariable String id,@PathVariable String item_id){
        Cart cart = this.getCart(id);
        Map<Integer,Item> basket = cart.getBasket();
        if(basket.containsKey(Integer.parseInt(item_id))){
            cart.removeItem(Integer.parseInt(item_id));
        }
        return cart;
    }

}
