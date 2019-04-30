package za.co.gavinmorris.cart.web;

import org.springframework.web.bind.annotation.*;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/carts")
public class OrderController {

    Map<Integer,Cart> carts = new HashMap<Integer, Cart>();


    @RequestMapping(value="",method=RequestMethod.GET)
    public Map<Integer,Cart> getAllCarts(){
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
            return cart;
        }
    }

    @RequestMapping(value="/{id}/items/{sku}",method = RequestMethod.POST)
    public Cart addItemToCart(@PathVariable String id,@PathVariable String sku){
        Item item = new Item(sku,"Testname","TestItem1Description",1.00);
        Cart cart = this.getCart(id);
        cart.addItem(sku);
        return cart;
    }

    @RequestMapping(value="/{id}/items/{sku}",method = RequestMethod.DELETE)
    public Cart removeItemFromCart(@PathVariable String id,@PathVariable String sku){
        Cart cart = this.getCart(id);
        Map<String,Integer> basket = cart.getBasket();
        if(basket.containsKey(sku)){
            cart.removeItem(sku);
        }
        return cart;
    }

}
