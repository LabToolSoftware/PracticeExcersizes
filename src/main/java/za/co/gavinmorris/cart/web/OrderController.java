package za.co.gavinmorris.cart.web;

import org.springframework.web.bind.annotation.*;
import za.co.gavinmorris.cart.domain.*;

import java.util.Map;

@RestController

public class OrderController {

    private Discount discount;
    private TaxCalculator taxCalculator;
    private Order order = new Order("order1");

    public OrderController(){
        this.discount = new MinimumNumberDiscount(5,0.2);
        this.taxCalculator = new TaxCalculator();
        this.taxCalculator.setVat(0.16);
        this.order.setCartDiscount(discount);
        this.order.setTaxCalculator(taxCalculator);
    }

    @RequestMapping(value="/carts",method=RequestMethod.GET)
    public Map<String,Cart> getAllCarts(){
        return order.getTrolley();
    }

    @RequestMapping(value = "/carts/{cartID}",method = RequestMethod.GET)
    public Cart getCart(@PathVariable String cartID){
        return order.getCart(cartID);
    }

    @RequestMapping(value="/carts/{cartID}/items/{sku}",method = RequestMethod.POST)
    public Cart addItemToCart(@PathVariable String cartID,@PathVariable String sku){
        return order.addItemToCart(cartID,sku);
    }

    @RequestMapping(value="/carts/{cartID}/items/{sku}",method = RequestMethod.DELETE)
    public Cart removeItemFromCart(@PathVariable String cartID,@PathVariable String sku){
        return order.removeItemFromCart(cartID,sku);
    }

    @RequestMapping(value="/order",method = RequestMethod.GET)
    public Order removeItemFromCart(){
        return order;
    }
}
