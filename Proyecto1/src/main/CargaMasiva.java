package main;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import Objetos.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class CargaMasiva {

    public static Restaurante restaurant;
    public static ArrayList<Usuario> users;
    public static ArrayList<Producto> products;
    public static ArrayList<Cliente> clients;
    public static ArrayList<Factura> invoices;
    public static LocalDateTime fechaHoraActuales = LocalDateTime.now();

    public CargaMasiva() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

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
    
    public void cargaDatos() {
        Gson gson = new Gson();

        String datos = getContentOfFile("config.json");
        restaurant = gson.fromJson(datos, Restaurante.class);

        datos = getContentOfFile("users.json");
        Usuario[] usuarios = gson.fromJson(datos, Usuario[].class);
        users.addAll(Arrays.asList(usuarios));

        //POSIBLE CAMBIO
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (users.get(i).getUsername().equals(users.get(j).getUsername())) {
                    String log = fechaHoraActuales
                            + "\t\tUSERNAME: El usuario " + users.get(j).getUsername() + " ya existe, se omitió el registro.\r\n";
                    Log.addToEndFile("errors.log", log);
                    System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                    users.remove(j);
                    break;
                }
            }
        }
        Log.addToEndFile("errors.log", "\r\n");

        datos = getContentOfFile("products.json");
        Producto[] productos = gson.fromJson(datos, Producto[].class);
        products.addAll(Arrays.asList(productos));
        
        repeticiones(products);

        datos = getContentOfFile("clients.json");
        Cliente[] clientes = gson.fromJson(datos, Cliente[].class);
        clients.addAll(Arrays.asList(clientes));
        
        repeticiones(clients);

        datos = getContentOfFile("invoices.json");
        Factura[] facturas = gson.fromJson(datos, Factura[].class);
        invoices.addAll(Arrays.asList(facturas));
        
        repeticiones(invoices);
    }   
    
    public void repeticiones(ArrayList lista){
        ArrayList<Objeto> listaa = lista; 
        for (int i = 0; i < listaa.size() - 1; i++) {
            for (int j = i + 1; j < listaa.size(); j++) {
                if (listaa.get(i).getId() == listaa.get(j).getId()) {
                    String log = fechaHoraActuales
                            + "\t\tINVOICES: El id " + listaa.get(j).getId() + " ya existe, se omitió el registro.\r\n";
                    Log.addToEndFile("errors.log", log);
                    System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                    listaa.remove(j);
                    break;
                }
            }
        }
        Log.addToEndFile("errors.log", "\r\n");
    }
}
