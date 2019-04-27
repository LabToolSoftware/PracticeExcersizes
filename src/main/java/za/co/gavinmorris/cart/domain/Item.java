package za.co.gavinmorris.cart.domain;

public class Item {
    private int id;
    private String name;
    private String description;
    private double cost;
    private int quantity;


    public Item(int id,String name,String description,double cost){
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.quantity = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCost(double cost) {
        this.cost = cost;
    }
}

