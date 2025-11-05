import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelClientes extends JPanel {
    private listaClientes listaClientes;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
    private JTextField txtId, txtDni, txtNombre, txtApellido, txtEmail, txtTelefono;
    private int siguienteId = 1;
    
    public PanelClientes(listaClientes listaClientes) {
        this.listaClientes = listaClientes;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel superior - Formulario
        JPanel panelFormulario = crearPanelFormulario();
        add(panelFormulario, BorderLayout.NORTH);
        
        // Panel central - Tabla
        JPanel panelTabla = crearPanelTabla();
        add(panelTabla, BorderLayout.CENTER);
    }
    
    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Registro de Clientes"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // DNI
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("DNI:"), gbc);
        gbc.gridx = 1;
        txtDni = new JTextField(15);
        panel.add(txtDni, gbc);
        
        // Nombre
        gbc.gridx = 2;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 3;
        txtNombre = new JTextField(15);
        panel.add(txtNombre, gbc);
        
        // Apellido
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1;
        txtApellido = new JTextField(15);
        panel.add(txtApellido, gbc);
        
        // Email
        gbc.gridx = 2;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 3;
        txtEmail = new JTextField(15);
        panel.add(txtEmail, gbc);
        
        // Teléfono
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        txtTelefono = new JTextField(15);
        panel.add(txtTelefono, gbc);
        
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAgregar = new JButton("Agregar Cliente");
        JButton btnLimpiar = new JButton("Limpiar");
        
        btnAgregar.setBackground(new Color(60, 179, 113));
        btnAgregar.setForeground(Color.WHITE);
        btnLimpiar.setBackground(new Color(100, 149, 237));
        btnLimpiar.setForeground(Color.WHITE);
        
        btnAgregar.addActionListener(e -> agregarCliente());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnLimpiar);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panel.add(panelBotones, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        
        String[] columnas = {"ID", "DNI", "Nombre", "Apellido", "Email", "Teléfono"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de botones de la tabla
        JPanel panelBotonesTabla = new JPanel(new FlowLayout());
        JButton btnEliminar = new JButton("Eliminar Seleccionado");
        btnEliminar.setBackground(new Color(220, 20, 60));
        btnEliminar.setForeground(Color.WHITE);
        
        btnEliminar.addActionListener(e -> eliminarClienteSeleccionado());
        
        panelBotonesTabla.add(btnEliminar);
        panel.add(panelBotonesTabla, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void agregarCliente() {
        try {
            String dni = txtDni.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();
            
            if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor complete al menos DNI, Nombre y Apellido", 
                    "Campos incompletos", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Cliente cliente = new Cliente(siguienteId, dni, nombre, apellido, email, telefono);
            listaClientes.AgregarCliente(cliente);
            
            // Agregar a la tabla
            Object[] fila = {siguienteId, dni, nombre, apellido, email, telefono};
            modeloTabla.addRow(fila);
            
            siguienteId++;
            limpiarFormulario();
            
            JOptionPane.showMessageDialog(this, 
                "Cliente agregado exitosamente", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al agregar cliente: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminarClienteSeleccionado() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de eliminar este cliente?", 
                "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                listaClientes.EliminarCliente(id);
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, 
                    "Cliente eliminado exitosamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Por favor seleccione un cliente de la tabla", 
                "No hay selección", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void limpiarFormulario() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtDni.requestFocus();
    }
}
