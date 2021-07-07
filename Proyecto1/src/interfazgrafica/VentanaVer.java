package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.CargaMasiva;

public class VentanaVer extends JFrame {

    public VentanaVer(ArrayList lista, int fila, String tipo) {
        VentanaVerP ventanaVerP = new VentanaVerP(lista, fila, tipo);
        initComponents(ventanaVerP, tipo);
    }

    public void initComponents(VentanaVerP ventanaVerP, String tipo) {
        //Inicializando la ventana y dándole dimensiones  
        if (tipo.equals("producto") || tipo.equals("factura")) {
            this.setBounds(300, 80, 550, 600);
        } else {
            this.setBounds(300, 100, 550, 300);
        }
        this.setTitle("Editar");
        this.setVisible(true);
        this.add(ventanaVerP);
        this.addWindowListener(ventanaVerP);
    }
}

class VentanaVerP extends JPanel implements WindowListener {

    //EDICIÓN COMUNES
    JLabel titulo, nameL, idL;
    JLabel name, id, adress, phone;
    JButton editarR, editarU, editarP, editarC;
    int fila;
    boolean r, u, p, c, f;
    //EDICIÓN USUARIO
    JLabel password;
    ArrayList<Usuario> users;
    //EDICIÓN PRODUCTO
    JLabel description, cost, price;
    ArrayList<Producto> products;
    JTable tabla;
    DefaultTableModel modelo;
    //EDICIÓN CLIENTE
    JLabel nit;
    ArrayList<Cliente> clients;
    //EDICIÓN FACTURA
    ArrayList<Factura> invoices;

    public VentanaVerP(ArrayList lista, int fila, String tipo) {
        estetica();
        if (tipo.equals("usuario")) {
            claseU(lista, fila);
        } else if (tipo.equals("producto")) {
            claseP(lista, fila);
        } else if (tipo.equals("cliente")) {
            claseC(lista, fila);
        } else if (tipo.equals("factura")) {
            claseF(lista, fila);
        }
    }

    public void claseU(ArrayList users, int fila) {
        //Constructor para editar un usuario
        this.users = users;
        this.fila = fila;
        u = true;
        titulo = new JLabel("VER USUARIOS");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre de usuario:");
        nameL.setBounds(30, 75, 150, 20);
        this.add(nameL);
        name = new JLabel(this.users.get(fila).getUsername());
        name.setBounds(180, 75, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel passwordL = new JLabel("Contraseña del usuario:");
        passwordL.setBounds(30, 115, 150, 20);
        this.add(passwordL);
        password = new JLabel(this.users.get(fila).getPassword());
        password.setBounds(180, 115, 200, 20);
        password.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(password);
    }

    public void claseP(ArrayList products, int fila) {
        //Constructor para editar un producto
        this.products = products;
        this.fila = fila;
        p = true;
        titulo = new JLabel("VER PRODUCTOS");
        titulo.setBounds(70, 50, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre del producto:");
        nameL.setBounds(30, 115, 150, 20);
        this.add(nameL);
        name = new JLabel(this.products.get(fila).getName());
        name.setBounds(180, 115, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel descriptionL = new JLabel("Descripción del producto:");
        descriptionL.setBounds(30, 155, 150, 20);
        this.add(descriptionL);
        description = new JLabel(this.products.get(fila).getDescription());
        description.setBounds(180, 155, 200, 20);
        description.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(description);

        JLabel costL = new JLabel("Costo del producto:");
        costL.setBounds(30, 195, 150, 20);
        this.add(costL);
        cost = new JLabel(String.valueOf(this.products.get(fila).getCost()));
        cost.setBounds(180, 195, 200, 20);
        cost.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(cost);

        JLabel priceL = new JLabel("Precio del producto:");
        priceL.setBounds(30, 235, 150, 20);
        this.add(priceL);
        price = new JLabel(String.valueOf(this.products.get(fila).getPrice()));
        price.setBounds(180, 235, 200, 20);
        price.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(price);

        tabla(fila, "producto");
    }

    public void claseC(ArrayList clients, int fila) {
        //Constructor para editar un producto
        this.clients = clients;
        this.fila = fila;
        c = true;
        titulo = new JLabel("VER CLIENTES");
        titulo.setBounds(70, 50, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre del cliente:");
        nameL.setBounds(30, 115, 150, 20);
        this.add(nameL);
        name = new JLabel(this.clients.get(fila).getName());
        name.setBounds(180, 115, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel adressL = new JLabel("Dirección del cliente:");
        adressL.setBounds(30, 155, 150, 20);
        this.add(adressL);
        adress = new JLabel(this.clients.get(fila).getAddress());
        adress.setBounds(180, 155, 200, 20);
        adress.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(adress);

        JLabel phoneL = new JLabel("Teléfono del cliente:");
        phoneL.setBounds(30, 195, 150, 20);
        this.add(phoneL);
        phone = new JLabel(String.valueOf(this.clients.get(fila).getPhone()));
        phone.setBounds(180, 195, 200, 20);
        phone.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(phone);

        JLabel nitL = new JLabel("Nit del cliente:");
        nitL.setBounds(30, 235, 150, 20);
        this.add(nitL);
        nit = new JLabel(String.valueOf(this.clients.get(fila).getNit()));
        nit.setBounds(180, 235, 200, 20);
        nit.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(nit);
    }

    public void claseF(ArrayList invoices, int fila) {
        //Constructor para editar un producto
        this.invoices = invoices;
        this.fila = fila;
        f = true;
        titulo = new JLabel("VER FACTURAS");
        titulo.setBounds(70, 50, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Cliente:");
        nameL.setBounds(30, 115, 150, 20);
        this.add(nameL);
        name = new JLabel(String.valueOf(this.invoices.get(fila).getClient()));
        name.setBounds(180, 115, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel descriptionL = new JLabel("Fecha:");
        descriptionL.setBounds(30, 155, 150, 20);
        this.add(descriptionL);
        description = new JLabel(this.invoices.get(fila).getDate());
        description.setBounds(180, 155, 200, 20);
        description.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(description);

        tabla(fila, "factura");
    }

    public void tabla(int fila, String tipo) {

        if (tipo.equals("producto")) {
            String[] columnNames = {"Nombre", "Cantidad", "Unidades"};
            tabla = new JTable();
            Object[][] data = data2D1(fila);
            modelo = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        } else if (tipo.equals("factura")) {
            String[] columnNames = {"Nombre", "Precio"};
            tabla = new JTable();
            Object[][] data = data2D2(fila);
            modelo = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }
        tabla.setModel(modelo);
        tabla.setRowHeight(20);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(380, 250));
        JPanel panel = new JPanel();
        panel.setBounds(20, 270, 380, 250);
        panel.add(scrollPane);
        this.add(panel, BorderLayout.CENTER);

    }

    public static Object[][] data2D1(int fila) {
        Object[][] data = new Object[CargaMasiva.products.get(fila).getIngredients().size()][3];
        for (int i = 0; i < CargaMasiva.products.get(fila).getIngredients().size(); i++) {
            data[i][0] = CargaMasiva.products.get(fila).getIngredients().get(i).getName();
            data[i][1] = CargaMasiva.products.get(fila).getIngredients().get(i).getQuantity();
            data[i][2] = CargaMasiva.products.get(fila).getIngredients().get(i).getUnits();
        }
        return data;
    }

    public static Object[][] data2D2(int fila) {
        Object[][] data = new Object[CargaMasiva.invoices.get(fila).getProducts().size()][2];
        for (int i = 0; i < CargaMasiva.invoices.get(fila).getProducts().size(); i++) {
            data[i][0] = CargaMasiva.invoices.get(fila).getProducts().get(i).getName();
            data[i][1] = CargaMasiva.invoices.get(fila).getProducts().get(i).getPrice();
        }
        return data;
    }

    public void estetica() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos
        this.setBackground(new Color(204, 204, 0));
        r = false;
        u = false;
        p = false;
        c = false;
        f = false;
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
        if (r == true) {
            VentanaMenuP.ventanaInfoRestaurante.setVisible(true);
        } else if (u == true) {
            VentanaMenuP.ventanaUsuario = new VentanaUsuario();
            VentanaMenuP.ventanaUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (p == true) {
            VentanaMenuP.ventanaProducto = new VentanaProducto();
            VentanaMenuP.ventanaProducto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (c == true) {
            VentanaMenuP.ventanaClientes = new VentanaClientes();
            VentanaMenuP.ventanaClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (f == true) {
            VentanaMenuP.ventanaFactura = new VentanaFactura();
            VentanaMenuP.ventanaFactura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
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
}
