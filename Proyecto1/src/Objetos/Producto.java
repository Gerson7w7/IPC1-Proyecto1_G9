
package Objetos;

import java.util.ArrayList;

public class Producto extends Objeto{
    private String name;
    private double cost;
    private double price;
    private ArrayList<Ingrediente> ingredients;

    public Producto(int id, String name, double cost, double price, ArrayList<Ingrediente> ingredients) {
        super(id);
        this.name = name;
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
        return "Producto: " + "\r\n" + super.toString() + 
                "Nombre: " + name + "\r\nCosto: " + cost + "\r\nPrecio: " + price 
                + "\r\nIngredientes:\r\n" + ingredients + "\r\n";
    }
    
}
