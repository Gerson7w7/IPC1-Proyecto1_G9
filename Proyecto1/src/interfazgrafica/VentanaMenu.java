package interfazgrafica;

import Objetos.*;
import com.google.gson.JsonIOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import main.CargaMasiva;

public class VentanaMenu extends JFrame {

    public VentanaMenu() {
        //Inicializando la ventana y dándole dimensiones
        VentanaMenuP ventanaMenuP = new VentanaMenuP();
        this.setBounds(300, 100, 750, 450);
        this.setTitle("Menú principal");
        this.add(ventanaMenuP);
    }
}

class VentanaMenuP extends JPanel implements ActionListener {

    JLabel titulo;
    JButton infoRest, usuario, producto, cliente, factura, gCambios;
    public static VentanaInfoRestaurante ventanaInfoRestaurante;
    public static VentanaUsuario ventanaUsuario;
    public static VentanaProducto ventanaProducto;
    public static VentanaClientes ventanaClientes;
    public static VentanaFactura ventanaFactura;
    public static JLabel name, adress, phone, load;
    public static String usuarioA = CargaMasiva.users.get(Login.usuario).getUsername();

    public VentanaMenuP() {
        initComponents();
        estetica();
    }

    public void initComponents() {
        titulo = new JLabel("¿Qué deseas hacer hoy "
                + usuarioA + "?");
        this.add(titulo);

        infoRest = new JButton("Información del restaurante");
        this.add(infoRest);
        infoRest.addActionListener(this);

        usuario = new JButton("Menú Usuarios");
        this.add(usuario);
        usuario.addActionListener(this);

        producto = new JButton("Menú Productos");
        this.add(producto);
        producto.addActionListener(this);

        cliente = new JButton("Menú Clientes");
        this.add(cliente);
        cliente.addActionListener(this);

        factura = new JButton("Menú Facturas");
        this.add(factura);
        factura.addActionListener(this);

        gCambios = new JButton("Guardar Cambios");
        this.add(gCambios);
        gCambios.addActionListener(this);

        //datos del restaurante
        name = new JLabel("");
        this.add(name);
        adress = new JLabel("");
        this.add(adress);
        phone = new JLabel("");
        this.add(phone);
        load = new JLabel("");
        this.add(load);

        ventanaInfoRestaurante = new VentanaInfoRestaurante();
    }

    private void estetica() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos

        titulo.setBounds(110, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));

        infoRest.setBounds(30, 90, 200, 35);
        usuario.setBounds(260, 90, 200, 35);
        producto.setBounds(490, 90, 200, 35);

        cliente.setBounds(30, 170, 200, 35);
        factura.setBounds(260, 170, 200, 35);
        gCambios.setBounds(490, 170, 200, 35);
        name.setBounds(100, 250, 400, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        adress.setBounds(100, 280, 400, 20);
        adress.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        phone.setBounds(100, 310, 400, 20);
        phone.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        load.setBounds(100, 340, 400, 20);
        load.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));

        this.setBackground(new Color(153, 153, 255));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonP = (JButton) e.getSource();

        if (botonP == infoRest) {
            ventanaInfoRestaurante.setVisible(true);
            Login.ventanaMenu.dispose();
            ventanaInfoRestaurante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } else if (botonP == usuario) {
            ventanaUsuario = new VentanaUsuario();
            Login.ventanaMenu.dispose();
            ventanaUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } else if (botonP == producto) {
            ventanaProducto = new VentanaProducto();
            Login.ventanaMenu.dispose();
            ventanaProducto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (botonP == cliente) {
            ventanaClientes = new VentanaClientes();
            Login.ventanaMenu.dispose();
            ventanaClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (botonP == factura) {
            ventanaFactura = new VentanaFactura();
            Login.ventanaMenu.dispose();
            ventanaFactura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (botonP == gCambios) {
            try {
                CargaMasiva.guardarDatosJson();
                String m = "Se han guardado los cambios con éxito :D.";
                JOptionPane.showMessageDialog(this, m, "Guardar Cambios", 1);
            } catch (JsonIOException ex) {
                String m = "Ocurrió un error. :(";
                JOptionPane.showMessageDialog(this, m, "Guardar Cambios", 1);
            }
        }
    }

}
