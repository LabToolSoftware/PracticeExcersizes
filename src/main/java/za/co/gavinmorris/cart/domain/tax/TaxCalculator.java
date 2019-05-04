package za.co.gavinmorris.cart.domain.tax;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculator{

    private double tax;
    private double total;

    public double getVat() {
        return tax;
    }

    public void setVat(double tax) {
        this.tax = tax;
    }

    public double getTotalIncTax(double total){
        return total*(1+this.tax);
    }
}

