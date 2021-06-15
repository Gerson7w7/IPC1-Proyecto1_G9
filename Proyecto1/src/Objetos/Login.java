package Objetos;

import java.io.Console;
import main.*;
import static main.CargaMasiva.fechaHoraActuales;

public class Login {

    Menu menu;

    public Login() {
        this.menu = new Menu();
    }

    public void login() {
        while (true) {
//-----------------------------------PARA CMD------------------------------------------

//            Console console = System.console();
//            System.out.println("============================== LOGIN ============================");
//            System.out.println("Ingrese su usuario ");
//            String username = console.readLine();
//            System.out.println("Ingrese su contraseña: ");
//            char[] password = console.readPassword();
//            String pass = String.valueOf(password);
//      --------------------- PARA IDE ------------------------------------
            System.out.println("============================== LOGIN ============================");
            System.out.println("Si desea cerrar el programa ingrese un cero (0) en usuario y contraseña");
            System.out.println("Ingrese su usuario: ");
            String username = Menu.scanner.nextLine();
            System.out.println("Ingrese su contraseña: ");
            String pass = Menu.scanner.nextLine();

// --------------------PARA ENTRAR AL MENÚ -----------------------------------
            if (username.equals("0") && pass.equals("0")) {
                System.exit(0);
            } else {
                for (Usuario user : CargaMasiva.users) {
                    if (username.equals(user.getUsername()) && pass.equals(user.getPassword())) {                       
                        String log = fechaHoraActuales
                                + "\t\t" + user.getUsername() + ": Inicio de sesión exitoso.\r\n";
                        Log.addToEndFile("log.log", log);
                        menu.menu();
                        
                    } else if (username.equals(user.getUsername()) && !pass.equals(user.getPassword())) {
                        System.out.println("Contraseña incorrecta, intente de nuevo. \r\n");
                        String log = fechaHoraActuales
                                + "\t\t" + user.getUsername() + ": Inicio de sesión fallido.\r\n";
                        Log.addToEndFile("log.log", log);                     
                    } 
                }
            }
        }
    }
}
