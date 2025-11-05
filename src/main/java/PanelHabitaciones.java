import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelHabitaciones extends JPanel {
    private ListaReservas listaReservas;
    private JTable tablaHabitaciones;
    private DefaultTableModel modeloTabla;
    
    public PanelHabitaciones(ListaReservas listaReservas) {
        this.listaReservas = listaReservas;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(70, 130, 180));
        JLabel titulo = new JLabel("Habitaciones Disponibles");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);
        
        // Panel central - Tabla
        crearTablaHabitaciones();
        
        // Panel de información
        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información"));
        
        JTextArea infoArea = new JTextArea(
            "Tipos de Habitaciones:\n\n" +
            "• ESTÁNDAR: Capacidad para 2 personas - $15,000/noche\n" +
            "• SUITE: Capacidad para 3 personas - $25,000/noche\n" +
            "• KING: Capacidad para 4 personas - $30,000/noche\n" +
            "• PRESIDENCIAL: Capacidad para 5 personas - $35,000/noche"
        );
        infoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        infoArea.setEditable(false);
        infoArea.setBackground(new Color(255, 255, 224));
        
        panelInfo.add(new JScrollPane(infoArea), BorderLayout.CENTER);
        add(panelInfo, BorderLayout.SOUTH);
    }
    
    private void crearTablaHabitaciones() {
        String[] columnas = {"ID", "Capacidad", "Costo/Noche", "Clase", "Descripción", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Agregar las habitaciones predefinidas del hotel
        agregarHabitacion(1, 2, 15000, "Estándar", "Para 2 personas con 2 camas individuales", "Disponible");
        agregarHabitacion(2, 2, 15000, "Estándar", "Para 2 personas con 2 camas individuales", "Disponible");
        agregarHabitacion(3, 2, 15000, "Estándar", "Para 2 personas con 2 camas individuales", "Disponible");
        agregarHabitacion(4, 3, 25000, "Suite", "Para 3 personas con 1 cama matrimonial y 2 individuales", "Disponible");
        agregarHabitacion(5, 3, 25000, "Suite", "Para 3 personas con 1 cama matrimonial y 2 individuales", "Disponible");
        agregarHabitacion(6, 4, 30000, "King", "Para 4 personas con 4 camas individuales", "Disponible");
        agregarHabitacion(7, 4, 30000, "King", "Para 4 personas con 4 camas individuales", "Disponible");
        agregarHabitacion(8, 4, 30000, "King", "Para 4 personas con 4 camas individuales", "Disponible");
        agregarHabitacion(9, 5, 35000, "Presidencial", "Para 5 personas con cama matrimonial y 4 individuales", "Disponible");
        agregarHabitacion(10, 5, 35000, "Presidencial", "Para 5 personas con cama matrimonial y 4 individuales", "Disponible");
        
        tablaHabitaciones = new JTable(modeloTabla);
        tablaHabitaciones.setRowHeight(25);
        tablaHabitaciones.getColumnModel().getColumn(4).setPreferredWidth(250);
        
        JScrollPane scrollPane = new JScrollPane(tablaHabitaciones);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void agregarHabitacion(int id, int capacidad, int costo, String clase, String descripcion, String estado) {
        Object[] fila = {id, capacidad, "$" + costo, clase, descripcion, estado};
        modeloTabla.addRow(fila);
    }
    
    public void actualizarEstadoHabitacion(int habitacionId, boolean disponible) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            if ((int) modeloTabla.getValueAt(i, 0) == habitacionId) {
                modeloTabla.setValueAt(disponible ? "Disponible" : "Ocupada", i, 5);
                break;
            }
        }
    }
}
