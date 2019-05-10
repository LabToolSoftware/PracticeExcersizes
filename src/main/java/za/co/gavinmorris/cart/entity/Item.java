package za.co.gavinmorris.cart.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
public class Item implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private double cost;
    private double discount;

    public Item(){

    }

    public Item(String name,String description,double cost, double discount){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscountP(double discountPerc) {
        this.discount= discount;
    }

}

