package Objetos;

import interfazgrafica.*;
import java.util.ConcurrentModificationException;
import javax.swing.*;
import main.*;
import static main.CargaMasiva.fechaHoraActuales;
import static main.CargaMasiva.users;

public class Login {

    Menu menu;
    public static VentanaMenu ventanaMenu;
    public static int usuario;

    public Login() {
        menu = new Menu();
    }

    public void login(String username, String pass) {
        try {
            usuario = 0;
// --------------------PARA ENTRAR AL MENÚ -----------------------------------
            for (Usuario user : users) {
                if (username.equals(user.getUsername()) && pass.equals(user.getPassword())) {
                    String log = fechaHoraActuales
                            + "\t\t" + user.getUsername() + ": Inicio de sesión exitoso.\r\n";
                    Log.addToEndFile("log.log", log);
                    ventanaMenu = new VentanaMenu();
                    ventanaMenu.setVisible(true);
                    Main.login.dispose();
                    ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } else if (username.equals(user.getUsername()) && !pass.equals(user.getPassword())) {
                    String m = "Contraseña incorrecta, intente de nuevo. \r\n";
                    JOptionPane.showMessageDialog(ventanaMenu, m, "Error", 2);
                    String log = fechaHoraActuales
                            + "\t\t" + user.getUsername() + ": Inicio de sesión fallido.\r\n";
                    Log.addToEndFile("log.log", log);

                }
                usuario++;
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Para actualizar correctamente vuelva a iniciar el programa.");
        }
    }
}
