
package Objetos;

import java.util.ArrayList;

public class Producto {
    private int id;
    private String name;
    private double cost;
    private double price;
    private ArrayList<Ingrediente> ingredients;

    public Producto(int id, String name, double cost, double price, ArrayList<Ingrediente> ingredients) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.ingredients = ingredients;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
