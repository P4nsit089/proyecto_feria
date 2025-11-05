import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PanelReservas extends JPanel {
    private listaClientes listaClientes;
    private ListaReservas listaReservas;
    private JTable tablaReservas;
    private DefaultTableModel modeloTabla;
    private JTextField txtReservaId, txtClienteId, txtHabitacionId;
    private JTextField txtFechaIngreso, txtFechaSalida;
    private JComboBox<String> comboMetodoPago;
    private int siguienteReservaId = 1000;
    
    public PanelReservas(listaClientes listaClientes, ListaReservas listaReservas) {
        this.listaClientes = listaClientes;
        this.listaReservas = listaReservas;
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
        panel.setBorder(BorderFactory.createTitledBorder("Nueva Reserva"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // ID Cliente
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID Cliente:"), gbc);
        gbc.gridx = 1;
        txtClienteId = new JTextField(10);
        panel.add(txtClienteId, gbc);
        
        // ID Habitación
        gbc.gridx = 2;
        panel.add(new JLabel("ID Habitación:"), gbc);
        gbc.gridx = 3;
        txtHabitacionId = new JTextField(10);
        panel.add(txtHabitacionId, gbc);
        
        // Fecha Ingreso
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Fecha Ingreso (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        txtFechaIngreso = new JTextField(10);
        txtFechaIngreso.setToolTipText("Formato: 2025-12-25");
        panel.add(txtFechaIngreso, gbc);
        
        // Fecha Salida
        gbc.gridx = 2;
        panel.add(new JLabel("Fecha Salida (YYYY-MM-DD):"), gbc);
        gbc.gridx = 3;
        txtFechaSalida = new JTextField(10);
        txtFechaSalida.setToolTipText("Formato: 2025-12-30");
        panel.add(txtFechaSalida, gbc);
        
        // Método de Pago
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Método de Pago:"), gbc);
        gbc.gridx = 1;
        String[] metodosPago = {"Tarjeta de Crédito", "Efectivo", "Transferencia Bancaria", "Tarjeta de Débito"};
        comboMetodoPago = new JComboBox<>(metodosPago);
        panel.add(comboMetodoPago, gbc);
        
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnCrear = new JButton("Crear Reserva");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnCalcular = new JButton("Calcular Costo");
        
        btnCrear.setBackground(new Color(60, 179, 113));
        btnCrear.setForeground(Color.WHITE);
        btnLimpiar.setBackground(new Color(100, 149, 237));
        btnLimpiar.setForeground(Color.WHITE);
        btnCalcular.setBackground(new Color(255, 165, 0));
        btnCalcular.setForeground(Color.WHITE);
        
        btnCrear.addActionListener(e -> crearReserva());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnCalcular.addActionListener(e -> calcularCosto());
        
        panelBotones.add(btnCrear);
        panelBotones.add(btnCalcular);
        panelBotones.add(btnLimpiar);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panel.add(panelBotones, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Reservas Registradas"));
        
        String[] columnas = {"ID Reserva", "ID Cliente", "ID Habitación", "Fecha Ingreso", "Fecha Salida", "Días", "Método de Pago"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tablaReservas = new JTable(modeloTabla);
        tablaReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tablaReservas);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de botones de la tabla
        JPanel panelBotonesTabla = new JPanel(new FlowLayout());
        JButton btnCancelar = new JButton("Cancelar Reserva");
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setForeground(Color.WHITE);
        
        btnCancelar.addActionListener(e -> cancelarReservaSeleccionada());
        
        panelBotonesTabla.add(btnCancelar);
        panel.add(panelBotonesTabla, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void crearReserva() {
        try {
            int clienteId = Integer.parseInt(txtClienteId.getText().trim());
            int habitacionId = Integer.parseInt(txtHabitacionId.getText().trim());
            LocalDate fechaIngreso = LocalDate.parse(txtFechaIngreso.getText().trim());
            LocalDate fechaSalida = LocalDate.parse(txtFechaSalida.getText().trim());
            String metodoPago = (String) comboMetodoPago.getSelectedItem();
            
            // Validar fechas
            if (fechaSalida.isBefore(fechaIngreso) || fechaSalida.isEqual(fechaIngreso)) {
                JOptionPane.showMessageDialog(this, 
                    "La fecha de salida debe ser posterior a la fecha de ingreso", 
                    "Error en fechas", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validar habitación (1-10)
            if (habitacionId < 1 || habitacionId > 10) {
                JOptionPane.showMessageDialog(this, 
                    "El ID de habitación debe estar entre 1 y 10", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear la reserva
            listaReservas.CrearReserva(siguienteReservaId, clienteId, habitacionId, 
                                      fechaIngreso, fechaSalida, metodoPago);
            
            // Calcular días
            long dias = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);
            
            // Agregar a la tabla
            Object[] fila = {siguienteReservaId, clienteId, habitacionId, 
                           fechaIngreso, fechaSalida, dias, metodoPago};
            modeloTabla.addRow(fila);
            
            siguienteReservaId++;
            limpiarFormulario();
            
            JOptionPane.showMessageDialog(this, 
                "Reserva creada exitosamente\n" +
                "ID de Reserva: " + (siguienteReservaId - 1) +
                "\nDuración: " + dias + " días", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese números válidos para los IDs", 
                "Error de formato", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al crear reserva: " + ex.getMessage() + 
                "\nAsegúrese de usar el formato de fecha correcto (YYYY-MM-DD)", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calcularCosto() {
        try {
            int habitacionId = Integer.parseInt(txtHabitacionId.getText().trim());
            LocalDate fechaIngreso = LocalDate.parse(txtFechaIngreso.getText().trim());
            LocalDate fechaSalida = LocalDate.parse(txtFechaSalida.getText().trim());
            
            if (fechaSalida.isBefore(fechaIngreso) || fechaSalida.isEqual(fechaIngreso)) {
                JOptionPane.showMessageDialog(this, 
                    "La fecha de salida debe ser posterior a la fecha de ingreso", 
                    "Error en fechas", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            long dias = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);
            
            // Determinar costo por habitación
            int costoPorNoche = 0;
            if (habitacionId >= 1 && habitacionId <= 3) {
                costoPorNoche = 15000;
            } else if (habitacionId >= 4 && habitacionId <= 5) {
                costoPorNoche = 25000;
            } else if (habitacionId >= 6 && habitacionId <= 8) {
                costoPorNoche = 30000;
            } else if (habitacionId >= 9 && habitacionId <= 10) {
                costoPorNoche = 35000;
            } else {
                JOptionPane.showMessageDialog(this, 
                    "ID de habitación inválido (debe estar entre 1 y 10)", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int costoTotal = costoPorNoche * (int) dias;
            
            JOptionPane.showMessageDialog(this, 
                "Cálculo de Costo:\n\n" +
                "Habitación: " + habitacionId + "\n" +
                "Costo por noche: $" + costoPorNoche + "\n" +
                "Número de noches: " + dias + "\n" +
                "COSTO TOTAL: $" + costoTotal, 
                "Cálculo de Costo", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un número válido para el ID de habitación", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + ex.getMessage() + 
                "\nAsegúrese de ingresar las fechas correctamente", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cancelarReservaSeleccionada() {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int reservaId = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de cancelar esta reserva?", 
                "Confirmar cancelación", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                listaReservas.CancelacionReserva(reservaId);
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, 
                    "Reserva cancelada exitosamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Por favor seleccione una reserva de la tabla", 
                "No hay selección", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void limpiarFormulario() {
        txtClienteId.setText("");
        txtHabitacionId.setText("");
        txtFechaIngreso.setText("");
        txtFechaSalida.setText("");
        comboMetodoPago.setSelectedIndex(0);
        txtClienteId.requestFocus();
    }
}
