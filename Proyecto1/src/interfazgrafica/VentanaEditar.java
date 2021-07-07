package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.CargaMasiva;
import static main.CargaMasiva.fechaHoraActuales;
import main.Log;

public class VentanaEditar extends JFrame {

    public VentanaEditar(Restaurante restaurant) {
        VentanaEditarP ventanaEditarP = new VentanaEditarP(restaurant);
        initComponents(ventanaEditarP, "");
    }

    public VentanaEditar(ArrayList lista, int fila, String tipo) {
        VentanaEditarP ventanaEditarP = new VentanaEditarP(lista, fila, tipo);
        initComponents(ventanaEditarP, tipo);
    }

    public void initComponents(VentanaEditarP ventanaEditarP, String tipo) {
        //Inicializando la ventana y dándole dimensiones  
        if (tipo.equals("producto")) {
            this.setBounds(300, 80, 550, 600);
        } else {
            this.setBounds(300, 100, 550, 300);
        }
        this.setTitle("Editar");
        this.setVisible(true);
        this.add(ventanaEditarP);
        this.addWindowListener(ventanaEditarP);
    }
}

class VentanaEditarP extends JPanel implements WindowListener, ActionListener {

    //EDICIÓN COMUNES
    JLabel titulo, nameL, idL;
    JTextField name, id, adress, phone;
    JButton editarR, editarU, editarP, editarC;
    int fila;
    boolean r, u, p, c;
    //EDICIÓN RESTAURANTE
    JTextField load;
    Restaurante restaurant;
    //EDICIÓN USUARIO
    JTextField password;
    ArrayList<Usuario> users;
    //EDICIÓN PRODUCTO
    JTextField description, cost, price;
    ArrayList<Producto> products;
    JTable tabla;
    DefaultTableModel modelo;
    //EDICIÓN CLIENTE
    JTextField nit;
    ArrayList<Cliente> clients;

    public VentanaEditarP(Restaurante restaurant) {
        //Constructor para editar el restaurane
        this.restaurant = restaurant;
        estetica();
        r = true;
        titulo = new JLabel("EDICIÓN DEL RESTAURANTE");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre de restaurante:");
        nameL.setBounds(30, 75, 150, 20);
        this.add(nameL);
        name = new JTextField(restaurant.getName());
        name.setBounds(180, 75, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel adressL = new JLabel("Dirección de restaurante:");
        adressL.setBounds(30, 115, 150, 20);
        this.add(adressL);
        adress = new JTextField(restaurant.getAddress());
        adress.setBounds(180, 115, 200, 20);
        adress.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(adress);

        JLabel phoneL = new JLabel("Número del restaurante:");
        phoneL.setBounds(30, 155, 150, 20);
        this.add(phoneL);
        phone = new JTextField(String.valueOf(restaurant.getPhone()));
        phone.setBounds(180, 155, 200, 20);
        phone.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(phone);

        JLabel loadL = new JLabel("Tipo de carga:");
        loadL.setBounds(30, 195, 150, 20);
        this.add(loadL);
        load = new JTextField(restaurant.getLoad());
        load.setBounds(180, 195, 200, 20);
        load.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(load);

        editarR = new JButton("Editar");
        editarR.setBounds(400, 115, 100, 30);
        this.add(editarR);
        editarR.addActionListener(this);
    }

    public VentanaEditarP(ArrayList lista, int fila, String tipo) {
        estetica();
        if (tipo.equals("usuario")) {
            claseU(lista, fila);
        } else if (tipo.equals("producto")) {
            claseP(lista, fila);
        } else if (tipo.equals("cliente")) {
            claseC(lista, fila);
        }
    }

    public void claseU(ArrayList users, int fila) {
        //Constructor para editar un usuario
        this.users = users;
        this.fila = fila;
        u = true;
        titulo = new JLabel("EDICIÓN DE USUARIOS");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre de usuario:");
        nameL.setBounds(30, 75, 150, 20);
        this.add(nameL);
        name = new JTextField(this.users.get(fila).getUsername());
        name.setBounds(180, 75, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel passwordL = new JLabel("Contraseña del usuario:");
        passwordL.setBounds(30, 115, 150, 20);
        this.add(passwordL);
        password = new JTextField(this.users.get(fila).getPassword());
        password.setBounds(180, 115, 200, 20);
        password.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(password);

        editarU = new JButton("Editar");
        editarU.setBounds(400, 115, 100, 30);
        this.add(editarU);
        editarU.addActionListener(this);
    }

    public void claseP(ArrayList products, int fila) {
        //Constructor para editar un producto
        this.products = products;
        this.fila = fila;
        p = true;
        titulo = new JLabel("EDICIÓN DE PRODUCTOS");
        titulo.setBounds(70, 50, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre del producto:");
        nameL.setBounds(30, 115, 150, 20);
        this.add(nameL);
        name = new JTextField(this.products.get(fila).getName());
        name.setBounds(180, 115, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel descriptionL = new JLabel("Descripción del producto:");
        descriptionL.setBounds(30, 155, 150, 20);
        this.add(descriptionL);
        description = new JTextField(this.products.get(fila).getDescription());
        description.setBounds(180, 155, 200, 20);
        description.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(description);

        JLabel costL = new JLabel("Costo del producto:");
        costL.setBounds(30, 195, 150, 20);
        this.add(costL);
        cost = new JTextField(String.valueOf(this.products.get(fila).getCost()));
        cost.setBounds(180, 195, 200, 20);
        cost.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(cost);

        JLabel priceL = new JLabel("Precio del producto:");
        priceL.setBounds(30, 235, 150, 20);
        this.add(priceL);
        price = new JTextField(String.valueOf(this.products.get(fila).getPrice()));
        price.setBounds(180, 235, 200, 20);
        price.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(price);

        tabla(fila);

        editarP = new JButton("Editar");
        editarP.setBounds(400, 115, 100, 30);
        this.add(editarP);
        editarP.addActionListener(this);
    }

    public void claseC(ArrayList clients, int fila) {
        //Constructor para editar un producto
        this.clients = clients;
        this.fila = fila;
        c = true;
        titulo = new JLabel("EDICIÓN DE CLIENTES");
        titulo.setBounds(70, 50, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre del cliente:");
        nameL.setBounds(30, 115, 150, 20);
        this.add(nameL);
        name = new JTextField(this.clients.get(fila).getName());
        name.setBounds(180, 115, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel adressL = new JLabel("Dirección del cliente:");
        adressL.setBounds(30, 155, 150, 20);
        this.add(adressL);
        adress = new JTextField(this.clients.get(fila).getAddress());
        adress.setBounds(180, 155, 200, 20);
        adress.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(adress);

        JLabel phoneL = new JLabel("Teléfono del cliente:");
        phoneL.setBounds(30, 195, 150, 20);
        this.add(phoneL);
        phone = new JTextField(String.valueOf(this.clients.get(fila).getPhone()));
        phone.setBounds(180, 195, 200, 20);
        phone.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(phone);

        JLabel nitL = new JLabel("Nit del cliente:");
        nitL.setBounds(30, 235, 150, 20);
        this.add(nitL);
        nit = new JTextField(String.valueOf(this.clients.get(fila).getNit()));
        nit.setBounds(180, 235, 200, 20);
        nit.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(nit);

        editarC = new JButton("Editar");
        editarC.setBounds(400, 115, 100, 30);
        this.add(editarC);
        editarC.addActionListener(this);
    }

    public void tabla(int fila) {
        String[] columnNames = {"Nombre", "Cantidad", "Unidades"};
        tabla = new JTable();
        Object[][] data = data2D(fila);
        modelo = new DefaultTableModel(data, columnNames);
        tabla.setModel(modelo);
        tabla.setRowHeight(20);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(380, 250));
        JPanel panel = new JPanel();
        panel.setBounds(20, 270, 380, 250);
        panel.add(scrollPane);
        this.add(panel, BorderLayout.CENTER);
    }

    public static Object[][] data2D(int fila) {
        Object[][] data = new Object[CargaMasiva.products.get(fila).getIngredients().size()][3];
        for (int i = 0; i < CargaMasiva.products.get(fila).getIngredients().size(); i++) {
            data[i][0] = CargaMasiva.products.get(fila).getIngredients().get(i).getName();
            data[i][1] = CargaMasiva.products.get(fila).getIngredients().get(i).getQuantity();
            data[i][2] = CargaMasiva.products.get(fila).getIngredients().get(i).getUnits();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton == editarR) {
            editarR();
        } else if (boton == editarU) {
            editarU();
        } else if (boton == editarP) {
            editarP();
        } else if (boton == editarC) {
            editarC();
        }
    }

    public void editarR() {
        try {
            restaurant.setName(name.getText());
            restaurant.setAddress(adress.getText());
            restaurant.setPhone(Integer.parseInt(phone.getText()));
            restaurant.setLoad(load.getText());
            logR();
            String m = "Se ha editado el Restaurante con éxito";
            JOptionPane.showMessageDialog(this, m, "Edición", 1);
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Edición Restaurante", 1);
        }
    }

    public void editarU() {      
        boolean repeticion = false;
        for (Usuario user : CargaMasiva.users) {
            if (name.getText().equals(user.getUsername())) {
                repeticion = true;
            }
        }
        if (repeticion == false) {
            logU();
            CargaMasiva.users.get(fila).setUsername(name.getText());
            CargaMasiva.users.get(fila).setPassword(password.getText());
            String m = "Se ha editado el Usuario con éxito";
            JOptionPane.showMessageDialog(this, m, "Edición", 1);
        } else {
            String m = "El nombre de usuario ya existe";
            JOptionPane.showMessageDialog(this, m, "Edición", 1);
        }
    }

    public void editarP() {
        try {
            logP();
            CargaMasiva.products.get(fila).setName(name.getText());
            CargaMasiva.products.get(fila).setDescription(description.getText());
            CargaMasiva.products.get(fila).setCost(Double.parseDouble(cost.getText()));
            CargaMasiva.products.get(fila).setPrice(Double.parseDouble(price.getText()));
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String name = (String) tabla.getValueAt(i, 0);
                String quantity = String.valueOf(tabla.getValueAt(i, 1));
                String units = (String) tabla.getValueAt(i, 2);
                CargaMasiva.products.get(fila).getIngredients().get(i).setName(name);
                CargaMasiva.products.get(fila).getIngredients().get(i).setQuantity(Integer.valueOf(quantity));
                CargaMasiva.products.get(fila).getIngredients().get(i).setUnits(units);
            }
            String m = "Se ha editado el Producto con éxito";
            JOptionPane.showMessageDialog(this, m, "Edición", 1);
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Edición Producto", 1);
        }
    }

    public void editarC() {
        try {
            logC();
            CargaMasiva.clients.get(fila).setName(name.getText());
            CargaMasiva.clients.get(fila).setAddress(adress.getText());
            CargaMasiva.clients.get(fila).setPhone(Integer.parseInt(phone.getText()));
            CargaMasiva.clients.get(fila).setNit(nit.getText());
            String m = "Se ha editado el Cliente con éxito";
            JOptionPane.showMessageDialog(this, m, "Edición", 1);
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Edición Cliente", 1);
        }
    }

    public void logR() {
        String log = fechaHoraActuales
                + "\t\t" + VentanaMenuP.usuarioA
                + ": Editó al restaurante.\r\n";
        Log.addToEndFile("log.log", log);
    }

    public void logU() {
        String log = fechaHoraActuales
                + "\t\t" + VentanaMenuP.usuarioA
                + ": Editó al usuario " + CargaMasiva.users.get(fila).getUsername() + ".\r\n";
        Log.addToEndFile("log.log", log);
    }

    public void logP() {
        String log = fechaHoraActuales
                + "\t\t" + VentanaMenuP.usuarioA
                + ": Editó el producto " + CargaMasiva.products.get(fila).getId() + ".\r\n";
        Log.addToEndFile("log.log", log);
    }

    public void logC() {
        String log = fechaHoraActuales
                + "\t\t" + VentanaMenuP.usuarioA
                + ": Editó el cliente " + CargaMasiva.clients.get(fila).getId() + ".\r\n";
        Log.addToEndFile("log.log", log);
    }
}
