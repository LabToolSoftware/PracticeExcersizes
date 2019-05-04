package za.co.gavinmorris.cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.gavinmorris.cart.database.ItemDB;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.discount.Discount;
import za.co.gavinmorris.cart.domain.discount.MinimumNumberDiscount;
import za.co.gavinmorris.cart.domain.tax.TaxCalculator;
import za.co.gavinmorris.cart.repository.CartRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private TaxCalculator taxCalculator;

    @Autowired
    private MinimumNumberDiscount cartDiscount;

    @Autowired
    private CartRepository carts;

    @Autowired
    private ItemDB itemDB;

    public  CartService(){
    }

    public void add(String cartID) {
        Cart cart = new Cart(cartID);
        carts.save(cart);
    }

    public Cart get(String cartID){
       return carts.find(cartID);
    }

    public void remove(String cartID){
        carts.remove(cartID);
    }

    public Cart addItem(String cartID, String itemID) {
        if (this.itemDB.getItem(itemID) != null) {
            this.get(cartID).addItem(itemDB.getItem(itemID));
            return this.get(cartID);
        } else {
            return null;
        }
    }

    public Cart removeItem(String cartID, String itemID){
        if (this.itemDB.getItem(itemID) != null) {
            this.get(cartID).removeItem(itemDB.getItem(itemID));
            return this.get(cartID);
        } else {
            return this.get(cartID);
        }
    }

    public double getTotal(String cartID){
        double total = 0.0;
            double discountedTotal = this.cartDiscount.getDiscount(carts.find(cartID),5,0.2);
            total += taxCalculator.getTotalIncTax(discountedTotal);
        return total;
    }

}
