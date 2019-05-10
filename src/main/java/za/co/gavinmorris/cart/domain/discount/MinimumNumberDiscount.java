package za.co.gavinmorris.cart.domain.discount;

import org.springframework.stereotype.Component;
import za.co.gavinmorris.cart.entity.Cart;

@Component
public class MinimumNumberDiscount extends Discount {

    public MinimumNumberDiscount() {
    }

    double applyDiscount(double total, double discount) {
        double discountTotal = total * (1 - discount);
        return discountTotal;
    }

    public Boolean verifyDiscount(Cart cart, int minimumItems){
        if(cart.getNumberOfItems() > minimumItems){
            return true;
        }
        else{
            return false;
        }
    }

    public double getDiscount(Cart cart, int minimumItems, double discount) {
        double total = 0.0;

        if (cart.getNumberOfItems() > 0) {
            if (verifyDiscount(cart)) {
                total = applyDiscount(cart.getTotal(), discount);

                return total;
            } else {
                return cart.getTotal();
            }
        } else {
            return cart.getTotal();
        }
    }
}
