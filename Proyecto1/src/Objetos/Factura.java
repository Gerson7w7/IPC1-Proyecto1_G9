
package Objetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura extends Objeto implements Serializable{
    private int client;
    private String date;
    private ArrayList<Producto> products;

    public Factura(int id, int client, String date, ArrayList<Producto> products) {
        super(id);
        this.client = client;
        this.date = date;
        this.products = products;
    }   

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Producto> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Producto> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Factura: " + "\r\n" + super.toString() + 
                "Cliente: " + client + "\r\nFecha: " + date + 
                "\r\nProductos: " + products + "\r\n";
    }
        
}
