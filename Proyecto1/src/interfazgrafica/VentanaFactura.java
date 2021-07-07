package interfazgrafica;

import Objetos.Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.*;

public class VentanaFactura extends JFrame {

    public VentanaFactura() {
        //Inicializando la ventana y dándole dimensiones
        VentanaFacturaP ventanaFacturaP = new VentanaFacturaP();
        this.setBounds(300, 100, 750, 450);
        this.setTitle("Menú Factura");
        this.setVisible(true);
        this.add(ventanaFacturaP);
        this.addWindowListener(ventanaFacturaP);
    }
}

class VentanaFacturaP extends JPanel implements ActionListener, WindowListener, MouseListener {

    static DefaultTableModel modelo;
    static JTable tabla;
    Object[][] data;
    String[] columnNames = {"Id", "Cliente", "Fecha", "Productos", "Ver"};
    JLabel titulo;
    JButton crear;
    static JButton ver;

    public VentanaFacturaP() {
        initComponents();
        tabla();
    }

    public void initComponents() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos
        this.setBackground(new Color(204, 204, 0));

        titulo = new JLabel("Menú Facturas");
        titulo.setBounds(180, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        crear = new JButton("Crear Factura");
        crear.setBounds(50, 370, 150, 30);
        this.add(crear);
        crear.addActionListener(this);

        ver = new JButton("ver");
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
        scrollPane.setPreferredSize(new Dimension(700, 280));
        JPanel panel = new JPanel();
        panel.setBounds(20, 70, 700, 280);
        panel.add(scrollPane);
        this.add(panel, BorderLayout.CENTER);
    }

    public static Object[][] data2D() {
        Object[][] data = new Object[CargaMasiva.invoices.size()][5];
        for (int i = 0; i < CargaMasiva.invoices.size(); i++) {
            data[i][0] = CargaMasiva.invoices.get(i).getId();
            data[i][1] = CargaMasiva.invoices.get(i).getClient();
            data[i][2] = CargaMasiva.invoices.get(i).getDate();
            data[i][3] = CargaMasiva.invoices.get(i).getProducts();
            data[i][4] = ver;
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
            VentanaAñadir ventanaAñadir = new VentanaAñadir(CargaMasiva.invoices, "factura");
            VentanaMenuP.ventanaFactura.setVisible(false);
            ventanaAñadir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    public void mouseClicked(MouseEvent e) {
        int fila = tabla.rowAtPoint(e.getPoint());
        int columna = tabla.columnAtPoint(e.getPoint());

        if (columna == 4) { //columna editar
            System.out.println(fila + " ver");
            VentanaVer ventanaVer = new VentanaVer(CargaMasiva.invoices, fila, "factura");
            VentanaMenuP.ventanaFactura.setVisible(false);
            ventanaVer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {}

}
