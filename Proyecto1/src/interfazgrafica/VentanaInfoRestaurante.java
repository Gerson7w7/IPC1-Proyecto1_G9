package interfazgrafica;

import Objetos.Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.CargaMasiva;

public class VentanaInfoRestaurante extends JFrame {

    public VentanaInfoRestaurante() {
        //Inicializando la ventana y dándole dimensiones
        VentanaInfoRestauranteP ventanaInfoRestaurante = new VentanaInfoRestauranteP();
        this.setBounds(300, 100, 500, 200);
        this.setTitle("Restaurante");
        this.add(ventanaInfoRestaurante);
        this.addWindowListener(ventanaInfoRestaurante);
    }
}

class VentanaInfoRestauranteP extends JPanel implements WindowListener, ActionListener {

    JLabel titulo;
    JButton editar, mostrar;

    public VentanaInfoRestauranteP() {
        initComponents();
        estetica();
    }

    public void initComponents() {
        titulo = new JLabel("Información del Restaurante");
        this.add(titulo);

        editar = new JButton("Editar");
        this.add(editar);
        editar.addActionListener(this);

        mostrar = new JButton("Mostrar datos");
        this.add(mostrar);
        mostrar.addActionListener(this);

    }

    public void estetica() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos

        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));

        editar.setBounds(100, 60, 100, 35);
        mostrar.setBounds(250, 60, 150, 35);

        this.setBackground(new Color(204, 204, 0));
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //Aquí volvemos a mostrar la ventana anterior que se cerró
        Login.ventanaMenu.setVisible(true);
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editar) {
            VentanaEditar ventanaEditar = new VentanaEditar(CargaMasiva.restaurant);
            VentanaMenuP.ventanaInfoRestaurante.setVisible(false);
            ventanaEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            VentanaMenuP.name.setText("Nombre del Restaurante: " + CargaMasiva.restaurant.getName());
            VentanaMenuP.adress.setText("Dirección del Restaurante: " + CargaMasiva.restaurant.getAddress());
            VentanaMenuP.phone.setText("Teléfono del Restaurante: " + String.valueOf(CargaMasiva.restaurant.getPhone()));
            VentanaMenuP.load.setText("Tipo de carga: " + CargaMasiva.restaurant.getLoad());
            String m = "Datos mostrados con éxito :D";
            JOptionPane.showMessageDialog(this, m, "Mostrar", 1);
        }
    }
}
