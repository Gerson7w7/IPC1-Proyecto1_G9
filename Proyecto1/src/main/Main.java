
package main;
import Objetos.*;

public class Main {
    public static void main(String[] args) {       
        CargaMasiva cargaMasiva = new CargaMasiva();
        Login login = new Login();
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
        login.login();
    }
}
