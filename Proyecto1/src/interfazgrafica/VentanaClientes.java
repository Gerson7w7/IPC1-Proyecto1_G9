package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.*;
import static main.CargaMasiva.fechaHoraActuales;

public class VentanaClientes extends JFrame {

    public VentanaClientes() {
        //Inicializando la ventana y dándole dimensiones
        VentanaClientesP ventanaClientesP = new VentanaClientesP();
        this.setBounds(300, 100, 630, 450);
        this.setTitle("Menú usuario");
        this.setVisible(true);
        this.add(ventanaClientesP);
        this.addWindowListener(ventanaClientesP);
    }
}

class VentanaClientesP extends JPanel implements ActionListener, MouseListener, WindowListener {

    static DefaultTableModel modelo;
    static JTable tabla;
    Object[][] data;
    String[] columnNames = {"Id", "Nombre", "Dirección", "Teléfono", "NIT", "Editar", "Eliminar", "Ver"};
    JLabel titulo;
    JButton crear;
    static JButton editar, eliminar, ver;

    public VentanaClientesP() {
        initComponents();
        tabla();
    }

    public void initComponents() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos
        this.setBackground(new Color(204, 204, 0));

        titulo = new JLabel("Menú Clientes");
        titulo.setBounds(180, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        crear = new JButton("Crear Cliente");
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
        Object[][] data = new Object[CargaMasiva.clients.size()][8];
        for (int i = 0; i < CargaMasiva.clients.size(); i++) {
            data[i][0] = CargaMasiva.clients.get(i).getId();
            data[i][1] = CargaMasiva.clients.get(i).getName();
            data[i][2] = CargaMasiva.clients.get(i).getAddress();
            data[i][3] = CargaMasiva.clients.get(i).getPhone();
            data[i][4] = CargaMasiva.clients.get(i).getNit();
            data[i][5] = editar;
            data[i][6] = eliminar;
            data[i][7] = ver;
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
            VentanaAñadir ventanaAñadir = new VentanaAñadir(CargaMasiva.clients, "clientes");
            VentanaMenuP.ventanaClientes.setVisible(false);
            ventanaAñadir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = tabla.rowAtPoint(e.getPoint());
        int columna = tabla.columnAtPoint(e.getPoint());

        if (columna == 7) { //columna editar
            System.out.println(fila + " ver");
            VentanaVer ventanaVer = new VentanaVer(CargaMasiva.clients, fila, "cliente");
            VentanaMenuP.ventanaClientes.setVisible(false);
            ventanaVer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (columna == 6) {  //columna eliminar 
            String m = "¿Está seguro de elimnar este cliente?";
            int confirm = JOptionPane.showConfirmDialog(null, m, "Confirmar Eliminación", JOptionPane.CANCEL_OPTION);
            if (confirm == 0) {
                System.out.println(fila + " eliminar");
                logEliminacionC(fila);
                CargaMasiva.clients.remove(fila);
                VentanaMenuP.ventanaClientes.setVisible(false);
                VentanaMenuP.ventanaClientes = new VentanaClientes();
                VentanaMenuP.ventanaClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (columna == 5) { //columna editar
            System.out.println(fila + " editar");
            VentanaEditar ventanaEditar = new VentanaEditar(CargaMasiva.clients, fila, "cliente");
            VentanaMenuP.ventanaClientes.setVisible(false);
            ventanaEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    public void logEliminacionC(int fila) {
        String log = fechaHoraActuales
                + "\t\t" + VentanaMenuP.usuarioA
                + ": Eliminó el cliente " + CargaMasiva.clients.get(fila).getId() + ".\r\n";
        Log.addToEndFile("log.log", log);
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

}
