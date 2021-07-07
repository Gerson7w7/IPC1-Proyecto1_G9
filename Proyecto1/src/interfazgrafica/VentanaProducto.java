package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.CargaMasiva;
import static main.CargaMasiva.fechaHoraActuales;
import main.Log;

public class VentanaProducto extends JFrame {

    public VentanaProducto() {
        //Inicializando la ventana y dándole dimensiones
        VentanaProductoP ventanaProductoP = new VentanaProductoP();
        this.setBounds(300, 100, 630, 450);
        this.setTitle("Menú usuario");
        this.setVisible(true);
        this.add(ventanaProductoP);
        this.addWindowListener(ventanaProductoP);
    }
}

class VentanaProductoP extends JPanel implements ActionListener, WindowListener, MouseListener {

    static DefaultTableModel modelo;
    static JTable tabla;
    Object[][] data;
    String[] columnNames = {"Id", "Nombre", "Descripción", "Costo", "Precio", "Ingredientes", "Editar", "Eliminar", "Ver"};
    JLabel titulo;
    JButton crear;
    static JButton editar, eliminar, ver;

    public VentanaProductoP() {
        initComponents();
        tabla();
    }

    public void initComponents() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos
        this.setBackground(new Color(204, 204, 0));

        titulo = new JLabel("Menú Producto");
        titulo.setBounds(180, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        crear = new JButton("Crear Producto");
        crear.setBounds(50, 370, 150, 30);
        this.add(crear);
        crear.addActionListener(this);

        editar = new JButton("Editar");
        editar.setName("m");
        editar.addActionListener(this);
        eliminar = new JButton("Eliminar");
        eliminar.setName("e");
        eliminar.addActionListener(this);
        ver = new JButton("Ver");
        ver.setName("v");
        ver.addActionListener(this);

    }

    public void tabla() {
        tabla = new JTable();
        data = data2D();
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
        scrollPane.setPreferredSize(new Dimension(570, 280));
        JPanel panel = new JPanel();
        panel.setBounds(20, 70, 570, 280);
        panel.add(scrollPane);
        this.add(panel, BorderLayout.CENTER);
    }

    public static Object[][] data2D() {
        Object[][] data = new Object[CargaMasiva.products.size()][9];
        for (int i = 0; i < CargaMasiva.products.size(); i++) {
            data[i][0] = CargaMasiva.products.get(i).getId();
            data[i][1] = CargaMasiva.products.get(i).getName();
            data[i][2] = CargaMasiva.products.get(i).getDescription();
            data[i][3] = CargaMasiva.products.get(i).getCost();
            data[i][4] = CargaMasiva.products.get(i).getPrice();
            data[i][5] = CargaMasiva.products.get(i).getIngredients();
            data[i][6] = editar;
            data[i][7] = eliminar;
            data[i][8] = ver;
        }
        if (modelo != null) {
            modelo = (DefaultTableModel) tabla.getModel();
            tabla.setModel(modelo);
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crear) {
            System.out.println("crear");
            VentanaAñadir ventanaAñadir = new VentanaAñadir(CargaMasiva.products, "producto");
            VentanaMenuP.ventanaProducto.setVisible(false);
            ventanaAñadir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = tabla.rowAtPoint(e.getPoint());
        int columna = tabla.columnAtPoint(e.getPoint());

        if (columna == 8) { //columna editar
            System.out.println(fila + " ver");
            VentanaVer ventanaVer = new VentanaVer(CargaMasiva.products, fila, "producto");
            VentanaMenuP.ventanaProducto.setVisible(false);
            ventanaVer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (columna == 7) {  //columna eliminar 
            String m = "¿Está seguro de elimnar este producto?";
            int confirm = JOptionPane.showConfirmDialog(null, m, "Confirmar Eliminación", JOptionPane.CANCEL_OPTION);
            if (confirm == 0) {
                System.out.println(fila + " eliminar");
                logEliminacionP(fila);
                CargaMasiva.products.remove(fila);
                VentanaMenuP.ventanaProducto.setVisible(false);
                VentanaMenuP.ventanaProducto = new VentanaProducto();
                VentanaMenuP.ventanaProducto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (columna == 6) { //columna editar
            System.out.println(fila + " editar");
            VentanaEditar ventanaEditar = new VentanaEditar(CargaMasiva.products, fila, "producto");
            VentanaMenuP.ventanaProducto.setVisible(false);
            ventanaEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    public void logEliminacionP(int fila) {
        String log = fechaHoraActuales
                + "\t\t" + VentanaMenuP.usuarioA
                + ": Eliminó el producto " + CargaMasiva.products.get(fila).getId() + ".\r\n";
        Log.addToEndFile("log.log", log);
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
