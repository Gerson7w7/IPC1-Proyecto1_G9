package main;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import Objetos.*;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class CargaMasiva {

    public static Restaurante restaurant;
    public static ArrayList<Usuario> users;
    public static ArrayList<Producto> products;
    public static ArrayList<Cliente> clients;
    public static ArrayList<Factura> invoices;
    public static LocalDateTime fechaHoraActuales = LocalDateTime.now();
    public static Gson gson = new Gson();
    public static Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
    public Serializacion serializar;

    public CargaMasiva() {
        CargaMasiva.users = new ArrayList<>();
        CargaMasiva.products = new ArrayList<>();
        CargaMasiva.clients = new ArrayList<>();
        CargaMasiva.invoices = new ArrayList<>();
        this.serializar = new Serializacion();
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

    public static void createFile(String pathname, String data) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(pathname, false); // True indica que se va a agregar datos al final
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            // Escribe los datos en el archivo
            bfwriter.write(data);
            bfwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cargaConfig() {
        String datos = getContentOfFile("config.json");
        restaurant = gson.fromJson(datos, Restaurante.class);
    }

    public void cargaDatosJson() {
        try {
            String datos = getContentOfFile("users.json");
            Usuario[] usuarios = gson.fromJson(datos, Usuario[].class);
            users.addAll(Arrays.asList(usuarios));

            for (int i = 0; i < users.size() - 1; i++) {
                for (int j = i + 1; j < users.size(); j++) {
                    if (users.get(i).getUsername().equals(users.get(j).getUsername())) {
                        String log = fechaHoraActuales
                                + "\t\tUSERNAME: El usuario " + users.get(j).getUsername() + " ya existe, se omitió el registro.\r\n";
                        Log.addToEndFile("errors.log", log);
                        users.remove(j);
                        break;
                    }
                }
            }
            Log.addToEndFile("errors.log", "\r\n");

            datos = getContentOfFile("products.json");
            Producto[] productos = gson.fromJson(datos, Producto[].class);
            products.addAll(Arrays.asList(productos));

            repeticiones(products, 0);

            datos = getContentOfFile("clients.json");
            Cliente[] clientes = gson.fromJson(datos, Cliente[].class);
            clients.addAll(Arrays.asList(clientes));

            repeticiones(clients, 1);

            datos = getContentOfFile("invoices.json");
            Factura[] facturas = gson.fromJson(datos, Factura[].class);
            invoices.addAll(Arrays.asList(facturas));

            repeticiones(invoices, 2);

            System.out.println("");
        } catch (JsonSyntaxException e) {
            System.out.println("Ocurrió un problema en la carga de archivos:(");
        }
    }

    public void cargaDatosBin() {
        try {
            users = (ArrayList<Usuario>) serializar.deserialize("Usuarios.ipcrm");
            products = (ArrayList<Producto>) serializar.deserialize("Productos.ipcrm");
            clients = (ArrayList<Cliente>) serializar.deserialize("Clientes.ipcrm");
            invoices = (ArrayList<Factura>) serializar.deserialize("Facturas.ipcrm");
            System.out.println("");
        } catch (Exception e) {

        }
    }

    public void repeticiones(ArrayList lista, int t) {
        ArrayList<Objeto> listaa = lista;
        for (int i = 0; i < listaa.size() - 1; i++) {
            for (int j = i + 1; j < listaa.size(); j++) {
                if (listaa.get(i).getId() == listaa.get(j).getId()) {
                    String log = "";
                    switch (t) {
                        case 0:
                            log = fechaHoraActuales
                                    + "\t\tPRODUCTS: El id " + listaa.get(j).getId()
                                    + " ya existe, se omitió el registro.\r\n";
                            break;
                        case 1:
                            log = fechaHoraActuales
                                    + "\t\tCLIENTS: El id " + listaa.get(j).getId()
                                    + " ya existe, se omitió el registro.\r\n";
                            break;
                        case 2:
                            log = fechaHoraActuales
                                    + "\t\tINVOICES: El id " + listaa.get(j).getId()
                                    + " ya existe, se omitió el registro.\r\n";
                            break;
                    }
                    Log.addToEndFile("errors.log", log);
                    listaa.remove(j);
                    break;
                }
            }
        }
        Log.addToEndFile("errors.log", "\r\n");
    }

    public static void guardarDatosJson() throws JsonIOException {
        String datos = prettyGson.toJson(users);
        createFile("users.json", datos);

        datos = prettyGson.toJson(products);
        createFile("products.json", datos);

        datos = prettyGson.toJson(clients);
        createFile("clients.json", datos);

        datos = prettyGson.toJson(invoices);
        createFile("invoices.json", datos);
    }

    public void guardarDatosBin() {
        try {
            serializar.serialize("Usuarios.ipcrm", users); //serialización de usuarios
            serializar.serialize("Productos.ipcrm", products); //serialización de productos
            serializar.serialize("Clientes.ipcrm", clients); //serialización de clientes
            serializar.serialize("Facturas.ipcrm", invoices); //serialización de facturas
            System.out.println("Se han guardado los cambios! :D");
        } catch (Exception e) {
            System.out.println("Ocurrió un error. :(");
        }
    }

}
