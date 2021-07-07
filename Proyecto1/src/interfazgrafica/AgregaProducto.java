package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.*;

public class AgregaProducto extends JFrame {

    public AgregaProducto() {
        AgregaProductoP agregaProductoP = new AgregaProductoP();
        initComponents(agregaProductoP);
    }

    public void initComponents(AgregaProductoP agregaProductoP) {
        //Inicializando la ventana y dándole dimensiones        
        this.setBounds(300, 100, 550, 400);
        this.setTitle("Editar");
        this.setVisible(true);
        this.add(agregaProductoP);
    }
}

class AgregaProductoP extends JPanel implements ActionListener, MouseListener {

    JLabel titulo;
    static DefaultTableModel modelo;
    static JTable tabla;
    Object[][] data;
    String[] columnNames = {"Id", "Nombre", "Descripción", "Costo", "Precio", "Ingredientes", "Agregar"};
    static JButton agregar;
    static ArrayList<Producto> productF;

    public AgregaProductoP() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos
        this.setBackground(new Color(204, 204, 0));
        agregar = new JButton("Agregar");
        agregar.setName("a");
        agregar.addActionListener(this);
        productF = new ArrayList<>();
        //Constructor para agregar un producto a la factura
        titulo = new JLabel("AGREGAR PRODUCTO");
        titulo.setBounds(70, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        tabla();
    }

    public void tabla() {
        tabla = new JTable();
        Object[][] data = data2D();
        tabla.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(modelo);
        tabla.setRowHeight(20);
        tabla.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(500, 250));
        JPanel panel = new JPanel();
        panel.setBounds(20, 50, 500, 250);
        panel.add(scrollPane);
        this.add(panel, BorderLayout.CENTER);
    }

    public static Object[][] data2D() {
        Object[][] data = new Object[CargaMasiva.products.size()][7];
        for (int i = 0; i < CargaMasiva.products.size(); i++) {
            data[i][0] = CargaMasiva.products.get(i).getId();
            data[i][1] = CargaMasiva.products.get(i).getName();
            data[i][2] = CargaMasiva.products.get(i).getDescription();
            data[i][3] = CargaMasiva.products.get(i).getCost();
            data[i][4] = CargaMasiva.products.get(i).getPrice();
            data[i][5] = CargaMasiva.products.get(i).getIngredients();
            data[i][6] = agregar;
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = tabla.rowAtPoint(e.getPoint());
        int columna = tabla.columnAtPoint(e.getPoint());

        if (columna == 6) {  //columna eliminar 
            System.out.println(fila + " agregar");
            productF.add(CargaMasiva.products.get(fila));
            String m = "Se ha agregado el producto :D.";
            JOptionPane.showMessageDialog(this, m, "Creación Factura", 1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
