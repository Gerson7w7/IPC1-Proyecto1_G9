package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import main.CargaMasiva;
import static main.CargaMasiva.fechaHoraActuales;
import main.Log;

public class VentanaAñadir extends JFrame {

    public VentanaAñadir(ArrayList lista, String tipo) {
        VentanaAñadirP ventanaAñadirP = new VentanaAñadirP(lista, tipo);
        initComponents(ventanaAñadirP);
    }

    public void initComponents(VentanaAñadirP ventanaAñadirP) {
        //Inicializando la ventana y dándole dimensiones        
        this.setBounds(300, 100, 550, 320);
        this.setTitle("Editar");
        this.setVisible(true);
        this.add(ventanaAñadirP);
        this.addWindowListener(ventanaAñadirP);
    }
}

class VentanaAñadirP extends JPanel implements ActionListener, WindowListener {

    //CREACIÓN COMUNES
    JLabel titulo, nameL, idL;
    JTextField name, id;
    JButton crearU, crearP, crearI, crearC, crearF;
    boolean u, p, c, f, repeticion;
    //CREACIÓN USUARIO
    JTextField password, cPassword;
    ArrayList<Usuario> users;
    //CREACIÓN PRODUCTO
    JTextField description, cost, price;
    ArrayList<Producto> products;
    JButton crearIngrediente;
    //CREACIÓN INGREDIENTE
    JTextField quantity, units;
    ArrayList<Ingrediente> ingredients = new ArrayList<>();
    //CRECIÓN CLIENTE
    JTextField adress, phone, nit;
    ArrayList<Cliente> clients;
    //CREACIÓN FACTURA
    JTextField client, date;
    ArrayList<Factura> invoices;
    JButton aProducto;

    public VentanaAñadirP(ArrayList lista, String tipo) {
        estetica();
        if (tipo.equals("usuario")) {
            claseU(lista);
        } else if (tipo.equals("producto")) {
            claseP(lista);
        } else if (tipo.equals("ingrediente")) {
            claseI(lista);
        } else if (tipo.equals("clientes")) {
            claseC(lista);
        } else if (tipo.equals("factura")) {
            claseF(lista);
        }
    }

    public void claseU(ArrayList users) {
        //Constructor para añadir un usuario
        this.users = users;
        u = true;
        titulo = new JLabel("CREACIÓN DE USUARIOS");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre de usuario:");
        nameL.setBounds(30, 75, 150, 20);
        this.add(nameL);
        name = new JTextField("");
        name.setBounds(180, 75, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel passwordL = new JLabel("Contraseña de usuario:");
        passwordL.setBounds(30, 115, 150, 20);
        this.add(passwordL);
        password = new JTextField("");
        password.setBounds(180, 115, 200, 20);
        password.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(password);

        JLabel cPasswordL = new JLabel("Confirmar contraseña:");
        cPasswordL.setBounds(30, 155, 150, 20);
        this.add(cPasswordL);
        cPassword = new JTextField("");
        cPassword.setBounds(180, 155, 200, 20);
        cPassword.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(cPassword);

        crearU = new JButton("Crear");
        crearU.setBounds(400, 115, 100, 30);
        this.add(crearU);
        crearU.addActionListener(this);
    }

    public void claseP(ArrayList products) {
        //Constructor para añadir un producto
        this.products = products;
        p = true;
        titulo = new JLabel("CREACIÓN DE PRODUCTOS");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        idL = new JLabel("Id del producto:");
        idL.setBounds(30, 75, 150, 20);
        this.add(idL);
        id = new JTextField("");
        id.setBounds(180, 75, 200, 20);
        id.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(id);

        nameL = new JLabel("Nombre del producto:");
        nameL.setBounds(30, 115, 150, 20);
        this.add(nameL);
        name = new JTextField("");
        name.setBounds(180, 115, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel descriptionL = new JLabel("Descripción del producto:");
        descriptionL.setBounds(30, 155, 150, 20);
        this.add(descriptionL);
        description = new JTextField("");
        description.setBounds(180, 155, 200, 20);
        description.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(description);

        JLabel costL = new JLabel("Costo del producto:");
        costL.setBounds(30, 195, 150, 20);
        this.add(costL);
        cost = new JTextField("");
        cost.setBounds(180, 195, 200, 20);
        cost.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(cost);

        JLabel priceL = new JLabel("Precio del producto:");
        priceL.setBounds(30, 235, 150, 20);
        this.add(priceL);
        price = new JTextField("");
        price.setBounds(180, 235, 200, 20);
        price.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(price);

        crearIngrediente = new JButton("Añadir Ingrediente");
        crearIngrediente.setBounds(390, 100, 140, 30);
        this.add(crearIngrediente);
        crearIngrediente.addActionListener(this);

        crearP = new JButton("Crear");
        crearP.setBounds(400, 150, 100, 30);
        this.add(crearP);
        crearP.addActionListener(this);

    }

    public void claseI(ArrayList ingredients) {
        //Constructor para añadir un producto
        this.ingredients = ingredients;
        titulo = new JLabel("CREACIÓN DE INGREDIENTES");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        nameL = new JLabel("Nombre del ingrediente:");
        nameL.setBounds(30, 75, 150, 20);
        this.add(nameL);
        name = new JTextField("");
        name.setBounds(180, 75, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel quantityL = new JLabel("Cantidad del ingrediente:");
        quantityL.setBounds(30, 115, 150, 20);
        this.add(quantityL);
        quantity = new JTextField("");
        quantity.setBounds(180, 115, 200, 20);
        quantity.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(quantity);

        JLabel unitsL = new JLabel("Unidades:");
        unitsL.setBounds(30, 155, 150, 20);
        this.add(unitsL);
        units = new JTextField("");
        units.setBounds(180, 155, 200, 20);
        units.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(units);

        crearI = new JButton("Crear");
        crearI.setBounds(400, 150, 100, 30);
        this.add(crearI);
        crearI.addActionListener(this);
    }

    public void claseC(ArrayList clients) {
        //Constructor para añadir un cliente
        this.clients = clients;
        c = true;
        titulo = new JLabel("CREACIÓN DE CLIENTES");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        idL = new JLabel("Id del Cliente:");
        idL.setBounds(30, 75, 150, 20);
        this.add(idL);
        id = new JTextField("");
        id.setBounds(180, 75, 200, 20);
        id.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(id);

        nameL = new JLabel("Nombre del cliente:");
        nameL.setBounds(30, 115, 150, 20);
        this.add(nameL);
        name = new JTextField("");
        name.setBounds(180, 115, 200, 20);
        name.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(name);

        JLabel adressL = new JLabel("Dirección del cliente:");
        adressL.setBounds(30, 155, 150, 20);
        this.add(adressL);
        adress = new JTextField("");
        adress.setBounds(180, 155, 200, 20);
        adress.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(adress);

        JLabel phoneL = new JLabel("Teléfono del cliente:");
        phoneL.setBounds(30, 195, 150, 20);
        this.add(phoneL);
        phone = new JTextField("");
        phone.setBounds(180, 195, 200, 20);
        phone.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(phone);

        JLabel nitL = new JLabel("Nit del cliente:");
        nitL.setBounds(30, 235, 150, 20);
        this.add(nitL);
        nit = new JTextField("");
        nit.setBounds(180, 235, 200, 20);
        nit.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(nit);

        crearC = new JButton("Crear");
        crearC.setBounds(400, 115, 100, 30);
        this.add(crearC);
        crearC.addActionListener(this);
    }

    public void claseF(ArrayList invoices) {
        //Constructor para añadir un producto
        this.invoices = invoices;
        f = true;
        titulo = new JLabel("CREACIÓN DE FACTURAS");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        idL = new JLabel("Id de la factura:");
        idL.setBounds(30, 75, 150, 20);
        this.add(idL);
        id = new JTextField("");
        id.setBounds(180, 75, 200, 20);
        id.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(id);

        JLabel clientL = new JLabel("Cliente:");
        clientL.setBounds(30, 115, 150, 20);
        this.add(clientL);
        client = new JTextField("");
        client.setBounds(180, 115, 200, 20);
        client.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(client);

        JLabel dateL = new JLabel("Fecha:");
        dateL.setBounds(30, 155, 150, 20);
        this.add(dateL);
        date = new JTextField("");
        date.setBounds(180, 155, 200, 20);
        date.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 15));
        this.add(date);

        aProducto = new JButton("Añadir Producto");
        aProducto.setBounds(390, 100, 140, 30);
        this.add(aProducto);
        aProducto.addActionListener(this);

        crearF = new JButton("Crear");
        crearF.setBounds(400, 150, 100, 30);
        this.add(crearF);
        crearF.addActionListener(this);
    }

    public void estetica() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos
        this.setBackground(new Color(204, 204, 0));
        u = false;
        p = false;
        c = false;
        f = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonP = (JButton) e.getSource();
        if (botonP == crearU) {
            añadirU();
        } else if (botonP == crearIngrediente) {
            System.out.println("crear");
            VentanaAñadir ventanaAñadir = new VentanaAñadir(ingredients, "ingrediente");
            ventanaAñadir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (botonP == crearI) {
            añadirI();
        } else if (botonP == crearP) {
            añadirP();
        } else if (botonP == crearC) {
            añadirC();
        } else if (botonP == aProducto) {
            System.out.println("crear");
            AgregaProducto agregaProducto = new AgregaProducto();
            agregaProducto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (botonP == crearF) {
            añadirF();
        }
    }

    public void añadirU() {
        try {
            repeticion = false;
            if (password.getText().equals(cPassword.getText())) {
                Usuario usuarioN = new Usuario(name.getText(), password.getText());
                for (int i = 0; i < CargaMasiva.users.size(); i++) {
                    if (usuarioN.getUsername().equals(CargaMasiva.users.get(i).getUsername())) {
                        repeticion = true;
                    }
                }
                if (repeticion == false) {
                    CargaMasiva.users.add(usuarioN);
                    log(usuarioN, "usuario");
                    String m = "Se ha creado el usuario con éxito :D";
                    JOptionPane.showMessageDialog(this, m, "Creación Usuario", 1);
                } else {
                    String m = "Este usuario ya existe, intente otro.";
                    JOptionPane.showMessageDialog(this, m, "Creación Usuario", 1);
                }
            } else {
                String m = "Las contraseñas no coinciden";
                JOptionPane.showMessageDialog(this, m, "Creación Usuario", 2);
            }
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Creación Usuario", 1);
        }
    }

    public void añadirP() {
        repeticion = false;
        try {
            Producto productN = new Producto(Integer.parseInt(id.getText()), name.getText(), description.getText(),
                    Double.parseDouble(cost.getText()), Double.parseDouble(price.getText()), ingredients);
            for (Producto producto : CargaMasiva.products) {
                if (productN.getId() == producto.getId()) {
                    repeticion = true;
                }
            }
            if (repeticion == false) {
                CargaMasiva.products.add(productN);
                log(productN, "producto");
                String m = "Se ha creado el producto con éxito :D";
                JOptionPane.showMessageDialog(this, m, "Creación Producto", 1);
            } else {
                String m = "Este id ya existe, intente otro.";
                JOptionPane.showMessageDialog(this, m, "Creación Producto", 1);
            }
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Creación Producto", 1);
        }
    }

    public void añadirI() {
        try {
            Ingrediente ingredientN = new Ingrediente(name.getText(),
                    Integer.parseInt(quantity.getText()), units.getText());
            ingredients.add(ingredientN);
            log(ingredientN, "ingrediente");
            String m = "Se ha agregado el ingrediente al producto";
            JOptionPane.showMessageDialog(this, m, "Creación Ingrediente", 1);
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Creación Ingrediente", 1);
        }
    }

    public void añadirC() {
        repeticion = false;
        try {
            Cliente clientN = new Cliente(Integer.parseInt(id.getText()),
                    name.getText(), adress.getText(), Integer.parseInt(phone.getText()),
                    nit.getText());
            for (Cliente cliente : CargaMasiva.clients) {
                if (clientN.getId() == cliente.getId()) {
                    repeticion = true;
                }
            }
            if (repeticion == false) {
                CargaMasiva.clients.add(clientN);
                log(clientN, "cliente");
                String m = "Se ha creado el cliente con éxito :D";
                JOptionPane.showMessageDialog(this, m, "Creación Cliente", 1);
            } else {
                String m = "Este id ya existe, intente otro.";
                JOptionPane.showMessageDialog(this, m, "Creación Prodcuto", 1);
            }
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Creación Cliente", 1);
        }
    }

    public void añadirF() {
        repeticion = false;
        try {
            Factura facturaN = new Factura(Integer.parseInt(id.getText()),
                    Integer.parseInt(client.getText()), date.getText(), AgregaProductoP.productF);
            for (Factura factura : CargaMasiva.invoices) {
                if (facturaN.getId() == factura.getId()) {
                    repeticion = true;
                }
            }
            if (repeticion == false) {
                CargaMasiva.invoices.add(facturaN);
                log(facturaN, "factura");
                String m = "Se ha creado la factura con éxito :D";
                JOptionPane.showMessageDialog(this, m, "Creación Factura", 1);
            } else {
                String m = "Este id ya existe, intente otro.";
                JOptionPane.showMessageDialog(this, m, "Creación Prodcuto", 1);
            }
        } catch (NumberFormatException e) {
            String m = "Se ha introducido una letra donde debería ir un número.";
            JOptionPane.showMessageDialog(this, m, "Creación Factura", 1);
        }
    }

    public void log(Object object, String tipo) {
        if (tipo.equals("usuario")) {
            Usuario user = (Usuario) object;
            String log = fechaHoraActuales
                    + "\t\t" + VentanaMenuP.usuarioA
                    + ": Añadió al usuario " + user.getUsername() + ".\r\n";
            Log.addToEndFile("log.log", log);
        } else if (tipo.equals("producto")) {
            Producto product = (Producto) object;
            String log = fechaHoraActuales
                    + "\t\t" + VentanaMenuP.usuarioA
                    + ": Añadió un producto con id " + product.getId() + ".\r\n";
            Log.addToEndFile("log.log", log);
        } else if (tipo.equals("ingrediente")) {
            Ingrediente ingredient = (Ingrediente) object;
            String log = fechaHoraActuales
                    + "\t\t" + VentanaMenuP.usuarioA
                    + ": Añadió un ingrediente de " + ingredient.getName() + ".\r\n";
            Log.addToEndFile("log.log", log);
        } else if (tipo.equals("cliente")) {
            Cliente client = (Cliente) object;
            String log = fechaHoraActuales
                    + "\t\t" + VentanaMenuP.usuarioA
                    + ": Añadió un cliente con id " + client.getId() + ".\r\n";
            Log.addToEndFile("log.log", log);
        } else if (tipo.equals("factura")) {
            Factura invoice = (Factura) object;
            String log = fechaHoraActuales
                    + "\t\t" + VentanaMenuP.usuarioA
                    + ": Añadió una factura con id " + invoice.getId() + ".\r\n";
            Log.addToEndFile("log.log", log);
        }
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
        if (u == true) {
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
