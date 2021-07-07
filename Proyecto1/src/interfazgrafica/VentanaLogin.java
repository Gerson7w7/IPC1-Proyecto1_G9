package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaLogin extends JFrame {

    public VentanaLogin() {
        //Inicializando la ventana y dándole dimensiones
        VentanaLoginP ventanaLoginP = new VentanaLoginP();
        this.setBounds(400, 170, 350, 230);
        this.setTitle("Login");
        this.add(ventanaLoginP);
    }
}

class VentanaLoginP extends JPanel implements ActionListener {

    JLabel titulo, usuario, contraseña;
    JTextField usuarioT;
    JPasswordField contraseñaT;
    JButton aceptar;
    Login login;

    public VentanaLoginP() {
        login = new Login();
        initComponents();
        estetica();
    }

    //Inicializando los componentes y agregándolos al panel
    public void initComponents() {
        titulo = new JLabel("Bienvenido");
        this.add(titulo);

        usuario = new JLabel("Usuario: ");
        this.add(usuario);
        usuarioT = new JTextField("");
        this.add(usuarioT);

        contraseña = new JLabel("Contraseña: ");
        this.add(contraseña);
        contraseñaT = new JPasswordField("");
        this.add(contraseñaT);

        aceptar = new JButton("Aceptar");
        this.add(aceptar);
        aceptar.addActionListener(this);
        this.setBackground(new Color(255, 128, 0));

    }

    public void estetica() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos

        titulo.setBounds(100, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));

        usuario.setBounds(50, 60, 100, 25);
        usuarioT.setBounds(130, 63, 150, 18);

        contraseña.setBounds(50, 105, 100, 25);
        contraseñaT.setBounds(130, 108, 150, 18);

        aceptar.setBounds(130, 150, 100, 30);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usuarioT.getText();
        String pass = String.valueOf(contraseñaT.getPassword());

        if (username.equals("") || pass.equals("")) {
            String m = "Usuario o contraseña sin llenar :(";
            JOptionPane.showMessageDialog(this, m, "Error", 2);
        } else {          
            login.login(username, pass);
        }
    }
}
