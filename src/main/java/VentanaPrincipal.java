import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private listaClientes listaClientes;
    private ListaReservas listaReservas;
    private JTabbedPane tabbedPane;
    
    public VentanaPrincipal() {
        // Inicializar las listas Clientes y Reservas
        listaClientes = new listaClientes();
        listaReservas = new ListaReservas();
        
        // Configurar la ventana principal Title, Size, Close Operation y Location
        setTitle("Sistema de Gestión de Hotel");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel de pestañas
        tabbedPane = new JTabbedPane();
        
        // Agregar las pestañas (Inicio, Clientes, Habitaciones, Reservas)
        tabbedPane.addTab("Inicio", crearPanelInicio());
        tabbedPane.addTab("Clientes", new PanelClientes(listaClientes));
        tabbedPane.addTab("Habitaciones", new PanelHabitaciones(listaReservas));
        tabbedPane.addTab("Reservas", new PanelReservas(listaClientes, listaReservas));
        
        // Agregar el panel de pestañas a la ventana
        add(tabbedPane);
        
        // Hacer visible la ventana
        setVisible(true);
    }
    
    private JPanel crearPanelInicio() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));
        
        // Panel superior con título (setBackground, Font, Color) y agregar al panel
       
        
        // Panel central con información (GridBagLayout, setBackground, Insets, JLabel, JTextArea)
        
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
