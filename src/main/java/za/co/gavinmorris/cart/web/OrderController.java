package za.co.gavinmorris.cart.web;

import org.springframework.web.bind.annotation.*;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;
import za.co.gavinmorris.cart.domain.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/carts")
public class OrderController {

    private Order order = new Order("order1");

    @RequestMapping(value="",method=RequestMethod.GET)
    public Map<String,Cart> getAllCarts(){
        return order.getTrolley();
    }

    @RequestMapping(value = "/{cartID}",method = RequestMethod.GET)
    public Cart getCart(@PathVariable String cartID){
        return order.getCart(cartID);
    }

    @RequestMapping(value="/{cartID}/items/{sku}",method = RequestMethod.POST)
    public Cart addItemToCart(@PathVariable String cartID,@PathVariable String sku){
        return order.addItemToCart(cartID,sku);
    }

    @RequestMapping(value="/{cartID}/items/{sku}",method = RequestMethod.DELETE)
    public Cart removeItemFromCart(@PathVariable String cartID,@PathVariable String sku){
        return order.removeItemFromCart(cartID,sku);
    }

}
