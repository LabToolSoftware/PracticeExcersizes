package za.co.gavinmorris.cart.domain.tax;

interface CalculateTotal{
    double getTotalIncTax(double total);
}

public class TaxCalculator implements CalculateTotal{

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

