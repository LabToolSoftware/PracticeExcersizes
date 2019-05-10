package za.co.gavinmorris.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.gavinmorris.cart.entity.Cart;
import za.co.gavinmorris.cart.domain.discount.Discount;
import za.co.gavinmorris.cart.domain.discount.MinimumNumberDiscount;
import za.co.gavinmorris.cart.domain.tax.TaxCalculator;
import za.co.gavinmorris.cart.service.CartService;

@RestController
public class CartController {

    private Discount discount;
    private TaxCalculator taxCalculator;
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
        this.discount = new MinimumNumberDiscount();
        this.taxCalculator = new TaxCalculator();
        this.taxCalculator.setVat(0.16);
    }

    @RequestMapping(value = "/cart/{cartID}",method = RequestMethod.PUT)
    public Cart addCart(@PathVariable String cartID){
        cartService.add(cartID);
        return cartService.get(cartID);
    }

    @RequestMapping(value = "/cart/{cartID}",method = RequestMethod.GET)
    public Cart getCart(@PathVariable String cartID){
        return cartService.get(cartID);
    }

    @RequestMapping(value="/cart/{cartID}/item/{sku}",method = RequestMethod.PUT)
    public Cart addItemToCart(@PathVariable String cartID,@PathVariable String sku){
        Long id = Long.parseLong(sku);
        return cartService.addItem(cartID,id);
    }

    @RequestMapping(value="/cart/{cartID}/item/{sku}",method = RequestMethod.DELETE)
    public Cart removeItemFromCart(@PathVariable String cartID,@PathVariable String sku){
        Long id = Long.parseLong(sku);
        return cartService.removeItem(cartID,id);
    }
}
