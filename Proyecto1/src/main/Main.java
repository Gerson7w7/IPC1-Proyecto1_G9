
package main;
import Objetos.*;

public class Main {
    public static void main(String[] args) {
        CargaMasiva cargaMasiva = new CargaMasiva();
        cargaMasiva.cargaDatos();
        
        Login login = new Login();
        login.login();
    }
}
