package za.co.gavinmorris.cart;

public class Item {
    String name;
    String description;
    double cost;
    int quantity;


    public void Item(String name,String description,float cost){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.quantity = 1;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}

