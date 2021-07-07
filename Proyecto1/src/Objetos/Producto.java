package Objetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Producto extends Objeto implements Serializable {

    private String name;
    private String description;
    private double cost;
    private double price;
    private ArrayList<Ingrediente> ingredients;

    public Producto(int id, String name, String description, double cost, double price, ArrayList<Ingrediente> ingredients) {
        super(id);
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Ingrediente> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingrediente> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return name + ", precio: " + price;
    }

}
