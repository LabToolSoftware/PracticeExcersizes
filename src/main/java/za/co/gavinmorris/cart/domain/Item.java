package za.co.gavinmorris.cart.domain;

public class Item {
    private String sku;
    private String name;
    private String description;
    private double cost;
    private double discountPerc;

    public Item(String sku,String name,String description,double cost, double discountPerc){
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.discountPerc = discountPerc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku= sku;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(double discountPerc) {
        this.discountPerc = discountPerc;
    }

    @Override
    public String toString() {
        return getSku();
    }
}

