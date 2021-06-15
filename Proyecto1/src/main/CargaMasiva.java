package main;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import Objetos.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CargaMasiva {
    private Restaurante restaurant; 
    private ArrayList<Usuario> users;
    private ArrayList<Producto> products;
    private ArrayList<Cliente> clients;
    private ArrayList<Factura> invoices;
    
    public static String getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }   

    public CargaMasiva() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }
       
    public void cargaDatos(){
        Gson gson = new Gson();
               
        String datos = getContentOfFile("config.json");
        restaurant = gson.fromJson(datos, Restaurante.class);
        
        datos = getContentOfFile("users.json");
        Usuario[] usuarios = gson.fromJson(datos, Usuario[].class);
        users.addAll(Arrays.asList(usuarios));
        
        datos = getContentOfFile("products.json");
        Producto[] productos = gson.fromJson(datos, Producto[].class);
        products.addAll(Arrays.asList(productos));
        
        datos = getContentOfFile("clients.json");
        Cliente[] clientes = gson.fromJson(datos, Cliente[].class);
        clients.addAll(Arrays.asList(clientes));
        
        datos = getContentOfFile("invoices.json");
        Factura[] facturas = gson.fromJson(datos, Factura[].class);
        invoices.addAll(Arrays.asList(facturas));
        
        System.out.println("");
         
    }
}
