package interfazgrafica;

import Objetos.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.CargaMasiva;
import static main.CargaMasiva.fechaHoraActuales;
import main.Log;

public class VentanaUsuario extends JFrame {

    public VentanaUsuario() {
        //Inicializando la ventana y dándole dimensiones
        VentanaUsuarioP ventanaUsuarioP = new VentanaUsuarioP();
        this.setBounds(300, 100, 500, 450);
        this.setTitle("Menú usuario");
        this.setVisible(true);
        this.add(ventanaUsuarioP);
        this.addWindowListener(ventanaUsuarioP);
    }
}

class VentanaUsuarioP extends JPanel implements ActionListener, WindowListener, MouseListener {

    static DefaultTableModel modelo;
    static JTable tabla;
    Object[][] data;
    String[] columnNames = {"Usuario", "Contraseña", "Editar", "Eliminar", "Ver"};
    JLabel titulo;
    JButton crear;
    static JButton editar, eliminar, ver;

    public VentanaUsuarioP() {
        initComponents();
        tabla();
    }

    public void initComponents() {
        this.setLayout(null); //layout null para poder poner los componentes donde queramos
        this.setBackground(new Color(204, 204, 0));

        titulo = new JLabel("Menú Usuario");
        titulo.setBounds(120, 10, 500, 35);
        titulo.setFont(new Font("Bienvenido", Font.ROMAN_BASELINE, 30));
        this.add(titulo);

        crear = new JButton("Crear usuario");
        crear.setBounds(50, 370, 120, 30);
        this.add(crear);
        crear.addActionListener(this);

        editar = new JButton("Editar");
        editar.setName("m");
        editar.addActionListener(this);
        eliminar = new JButton("Eliminar");
        eliminar.setName("e");
        eliminar.addActionListener(this);
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
        scrollPane.setPreferredSize(new Dimension(380, 280));
        JPanel panel = new JPanel();
        panel.setBounds(20, 70, 430, 280);
        panel.add(scrollPane);
        this.add(panel, BorderLayout.CENTER);
    }

    public static Object[][] data2D() {
        Object[][] data = new Object[CargaMasiva.users.size()][5];
        for (int i = 0; i < CargaMasiva.users.size(); i++) {
            data[i][0] = CargaMasiva.users.get(i).getUsername();
            data[i][1] = CargaMasiva.users.get(i).getPassword();
            data[i][2] = editar;
            data[i][3] = eliminar;
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
        JButton botonP = (JButton) e.getSource();
        if (botonP == crear) {
            System.out.println("crear");
            VentanaAñadir ventanaAñadir = new VentanaAñadir(CargaMasiva.users, "usuario");
            VentanaMenuP.ventanaUsuario.setVisible(false);
            ventanaAñadir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = tabla.rowAtPoint(e.getPoint());
        int columna = tabla.columnAtPoint(e.getPoint());

        if (columna == 4) { //columna editar
            System.out.println(fila + " ver");
            VentanaVer ventanaVer = new VentanaVer(CargaMasiva.users, fila, "usuario");
            VentanaMenuP.ventanaUsuario.setVisible(false);
            ventanaVer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (columna == 3) {  //columna eliminar 
            String m = "¿Está seguro de elimnar este usuario?";
            int confirm = JOptionPane.showConfirmDialog(null, m, "Confirmar Eliminación", JOptionPane.CANCEL_OPTION);
            if (confirm == 0) {
                System.out.println(fila + " eliminar");
                logEliminacionU(fila);
                CargaMasiva.users.remove(fila);
                VentanaMenuP.ventanaUsuario.setVisible(false);
                VentanaMenuP.ventanaUsuario = new VentanaUsuario();
                VentanaMenuP.ventanaUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (columna == 2) { //columna editar
            System.out.println(fila + " editar");
            VentanaEditar ventanaEditar = new VentanaEditar(CargaMasiva.users, fila, "usuario");
            VentanaMenuP.ventanaUsuario.setVisible(false);
            ventanaEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

    public void logEliminacionU(int fila) {
        String log = fechaHoraActuales
                + "\t\t" + VentanaMenuP.usuarioA
                + ": Eliminó al usuario " + CargaMasiva.users.get(fila).getUsername() + ".\r\n";
        Log.addToEndFile("log.log", log);
    }
}
