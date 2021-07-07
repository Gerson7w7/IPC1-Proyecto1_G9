package main;

import interfazgrafica.*;
import javax.swing.JFrame;

public class Main {

    public static VentanaLogin login;

    public static void main(String[] args) {
        CargaMasiva cargaMasiva = new CargaMasiva();
        login = new VentanaLogin();

        cargaMasiva.cargaConfig();
        switch (CargaMasiva.restaurant.getLoad()) {
            case "bin":
                cargaMasiva.cargaDatosBin();
                break;
            case "json":
                cargaMasiva.cargaDatosJson();
                break;
            default:
                System.out.println("No se han podido cargar los datos, verifique que la configuración sea correcta.");
                break;
        }

        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
