package za.co.gavinmorris.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.discount.MinimumNumberDiscount;
import za.co.gavinmorris.cart.domain.tax.TaxCalculator;
import za.co.gavinmorris.cart.repository.CartRepository;
import za.co.gavinmorris.cart.repository.ItemRepository;

@Service
public class CartService {

    @Autowired
    private TaxCalculator taxCalculator;

    @Autowired
    private MinimumNumberDiscount cartDiscount;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    public  CartService(){
    }

    public void add(String cartID) {
        Cart cart = new Cart(cartID);
        cartRepository.save(cart);
    }

    public Cart get(String cartID){
       return cartRepository.find(cartID);
    }

    public void remove(String cartID){
        cartRepository.remove(cartID);
    }

    public Cart addItem(String cartID, String itemID) {
            this.cartRepository.find(cartID).addItem(itemRepository.find(itemID));
            return this.cartRepository.find(cartID);
    }

    public Cart removeItem(String cartID, String itemID){
        this.cartRepository.find(cartID).removeItem(itemRepository.find(itemID));
        return this.cartRepository.find(cartID);
    }

    public double getTotal(String cartID){

        double total = 0.0;

        double discountedTotal = this.cartDiscount.getDiscount(cartRepository.find(cartID),5,0.2);

        total = taxCalculator.getTotalIncTax(discountedTotal);

        return total;
    }

}
