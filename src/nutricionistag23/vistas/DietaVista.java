/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionistag23.vistas;

import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import nutricionistag23.accesoADatos.DietaData;
import nutricionistag23.accesoADatos.PacienteData;
import nutricionistag23.accesoADatos.Validaciones;
import nutricionistag23.entidades.Dieta;
import nutricionistag23.entidades.Paciente;
import static nutricionistag23.vistas.MainMenu.getMainMenu;

/**
 *
 * @author pmora
 */
public class DietaVista extends javax.swing.JInternalFrame {

    private DietaComidaVista dietaComidaVista;
    public static int idDieta;
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    private String dni;

    public DietaVista() {
        initComponents();
        armarCabecera();
        llenarTabla();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        jtPaciente.setEditable(false);
        jbConfigDieta.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbModificar.setEnabled(false);
        jsPesoInicial.setModel(new SpinnerNumberModel(0.0, 0.0, 500, 0.1));
        jsPesoFinal.setModel(new SpinnerNumberModel(0.0, 0.0, 500, 0.1));
        jtNombreDieta.setBorder(BorderFactory.createCompoundBorder(jtNombreDieta.getBorder(), BorderFactory.createEmptyBorder(2, 5, 0, 5)));
        jtPaciente.setBorder(BorderFactory.createCompoundBorder(jtPaciente.getBorder(), BorderFactory.createEmptyBorder(2, 5, 0, 5)));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtNombreDieta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtPaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDieta = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jrbDietaNoActiva = new javax.swing.JRadioButton();
        jrbDietaActiva = new javax.swing.JRadioButton();
        jbVaciarCampos = new javax.swing.JButton();
        jsPesoFinal = new javax.swing.JSpinner();
        jsPesoInicial = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jtCerrar = new javax.swing.JToggleButton();
        jdFechaInit = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jdFechaFin = new com.toedter.calendar.JDateChooser();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbConfigDieta = new javax.swing.JButton();
        jPaneInfo = new javax.swing.JPanel();
        jLInfo = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setPreferredSize(new java.awt.Dimension(768, 633));

        jPanel1.setBackground(new java.awt.Color(140, 184, 132));
        jPanel1.setMinimumSize(new java.awt.Dimension(752, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nombre Dieta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 26, -1, 27));

        jtNombreDieta.setBackground(new java.awt.Color(230, 255, 227));
        jtNombreDieta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtNombreDieta.setBorder(null);
        jtNombreDieta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtNombreDietaKeyReleased(evt);
            }
        });
        jPanel1.add(jtNombreDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 28, 451, 27));

        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Paciente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 58, -1, 27));

        jtPaciente.setBackground(new java.awt.Color(230, 255, 227));
        jtPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtPaciente.setBorder(null);
        jPanel1.add(jtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 451, 27));

        jLabel6.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha Final");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 142, 80, 27));

        jLabel7.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PF-Peso Final (kg)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 137, -1, 27));

        jtDieta.setBackground(new java.awt.Color(230, 255, 227));
        jtDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtDieta.setSelectionBackground(new java.awt.Color(68, 106, 61));
        jtDieta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jtDieta.getTableHeader().setResizingAllowed(false);
        jtDieta.getTableHeader().setReorderingAllowed(false);
        jtDieta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtDietaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtDieta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 229, 606, 314));

        jbAgregar.setText("Agregar");
        jbAgregar.setMaximumSize(new java.awt.Dimension(83, 32));
        jbAgregar.setMinimumSize(new java.awt.Dimension(83, 32));
        jbAgregar.setPreferredSize(new java.awt.Dimension(83, 32));
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 231, 80, 30));

        jrbDietaNoActiva.setBackground(new java.awt.Color(230, 255, 227));
        jrbDietaNoActiva.setFont(new java.awt.Font("Gabriola", 1, 16)); // NOI18N
        jrbDietaNoActiva.setForeground(new java.awt.Color(255, 255, 255));
        jrbDietaNoActiva.setText("Dieta No Activa");
        jrbDietaNoActiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDietaNoActivaActionPerformed(evt);
            }
        });
        jPanel1.add(jrbDietaNoActiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 192, -1, 30));

        jrbDietaActiva.setBackground(new java.awt.Color(230, 255, 227));
        jrbDietaActiva.setFont(new java.awt.Font("Gabriola", 1, 16)); // NOI18N
        jrbDietaActiva.setForeground(new java.awt.Color(255, 255, 255));
        jrbDietaActiva.setText("Dieta Activa");
        jrbDietaActiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDietaActivaActionPerformed(evt);
            }
        });
        jPanel1.add(jrbDietaActiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 192, -1, 30));

        jbVaciarCampos.setText("Limpiar");
        jbVaciarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVaciarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(jbVaciarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 26, 80, 30));

        jsPesoFinal.setBorder(null);
        jPanel1.add(jsPesoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 137, 79, 27));

        jsPesoInicial.setBorder(null);
        jPanel1.add(jsPesoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 100, 79, 27));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Seleccione una dieta");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 183, 20));

        jtCerrar.setText("Cerrar");
        jtCerrar.setMaximumSize(new java.awt.Dimension(83, 32));
        jtCerrar.setMinimumSize(new java.awt.Dimension(83, 32));
        jtCerrar.setPreferredSize(new java.awt.Dimension(83, 32));
        jtCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jtCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 555, -1, -1));

        jdFechaInit.setBackground(new java.awt.Color(230, 255, 227));
        jPanel1.add(jdFechaInit, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 102, 130, -1));

        jLabel9.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PI-Peso Inicial (kg)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 100, -1, 27));

        jLabel10.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fecha Inicial");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 102, 90, 30));

        jdFechaFin.setBackground(new java.awt.Color(230, 255, 227));
        jPanel1.add(jdFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 142, 130, -1));

        jbEliminar.setText("Eliminar");
        jbEliminar.setMaximumSize(new java.awt.Dimension(83, 32));
        jbEliminar.setMinimumSize(new java.awt.Dimension(83, 32));
        jbEliminar.setPreferredSize(new java.awt.Dimension(83, 32));
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 331, 80, 30));

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 281, 80, 30));

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 58, 80, 30));

        jbConfigDieta.setText("Configurar Dieta");
        jbConfigDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfigDietaActionPerformed(evt);
            }
        });
        jPanel1.add(jbConfigDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 190, -1, -1));

        jPaneInfo.setBackground(new java.awt.Color(140, 184, 132));
        jPaneInfo.setForeground(new java.awt.Color(255, 255, 255));
        jPaneInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPaneInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPaneInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPaneInfoMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPaneInfoMouseReleased(evt);
            }
        });

        jLInfo.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLInfo.setText("?");

        javax.swing.GroupLayout jPaneInfoLayout = new javax.swing.GroupLayout(jPaneInfo);
        jPaneInfo.setLayout(jPaneInfoLayout);
        jPaneInfoLayout.setHorizontalGroup(
            jPaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPaneInfoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPaneInfoLayout.setVerticalGroup(
            jPaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPaneInfoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPaneInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtNombreDietaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreDietaKeyReleased
        if (!jtNombreDieta.getText().equals("") && Validaciones.validacionInmediataCaracteres(jtNombreDieta.getText(), 2) == false) {
            JOptionPane.showMessageDialog(this, "Caracter inválido");
            jtNombreDieta.setText("");
        }
    }//GEN-LAST:event_jtNombreDietaKeyReleased

    private void jtDietaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDietaMouseReleased
        jbModificar.setEnabled(true);
        jtNombreDieta.setText(modeloTabla.getValueAt(jtDieta.getSelectedRow(), 0).toString());
        if(((Paciente) modeloTabla.getValueAt(jtDieta.getSelectedRow(), 1))!=null){
            jtPaciente.setText(((Paciente) modeloTabla.getValueAt(jtDieta.getSelectedRow(), 1)).toString());
            dni = String.valueOf(((Paciente) modeloTabla.getValueAt(jtDieta.getSelectedRow(), 1)).getDni());
        }else{
            jtPaciente.setText("");
        }
        jsPesoInicial.setValue((double) modeloTabla.getValueAt(jtDieta.getSelectedRow(), 2));
        jsPesoFinal.setValue((double) modeloTabla.getValueAt(jtDieta.getSelectedRow(), 3));
        jdFechaInit.setDate(Date.valueOf((LocalDate) modeloTabla.getValueAt(jtDieta.getSelectedRow(), 4)));
        jdFechaFin.setDate(Date.valueOf((LocalDate) modeloTabla.getValueAt(jtDieta.getSelectedRow(), 5)));
        jbAgregar.setEnabled(false);
        jbEliminar.setEnabled(true);
        jbConfigDieta.setEnabled(true);
        idDieta = ((Dieta)modeloTabla.getValueAt(jtDieta.getSelectedRow(), 0)).getIdDieta();
    }//GEN-LAST:event_jtDietaMouseReleased

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        try {
            if (Validaciones.validacionNombrePaciente(jtNombreDieta.getText()) && Validaciones.validacionPeso((double) jsPesoFinal.getValue()) && Validaciones.validacionPeso((double) jsPesoInicial.getValue())
                    && Validaciones.validacionFechaFinal(jdFechaInit.getDate(), jdFechaFin.getDate())) {
                DietaData dd = new DietaData();
                PacienteData pd = new PacienteData();
                Dieta dieta = new Dieta();
                dieta.setNombre(jtNombreDieta.getText());
                if(jtPaciente.getText().equals("")){
                    dieta.setPaciente(null);
                }else{
                    dieta.setPaciente(pd.buscarPacienteXDni(Integer.parseInt(dni)));
                }
                dieta.setFechaInicial(jdFechaInit.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                dieta.setFechaFinal(jdFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                dieta.setPesoInicial((double) jsPesoInicial.getValue());
                dieta.setPesoFinal((double) jsPesoFinal.getValue());
                jrbDietaActiva.setSelected(false);
                jrbDietaNoActiva.setSelected(false);
                jbConfigDieta.setEnabled(false);
                jbEliminar.setEnabled(false);
                dd.guardarDieta(dieta);
                tableClean();
                llenarTabla();
                limpiar();
            }
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "No se permiten campos vacíos y/o caracteres inválidos.");
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jrbDietaNoActivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDietaNoActivaActionPerformed
        limpiar();
        tableClean();
        jbModificar.setEnabled(false);
        jbAgregar.setEnabled(true);
        jrbDietaActiva.setSelected(false);
        jbConfigDieta.setEnabled(false);
        jbEliminar.setEnabled(false);
        DietaData dd = new DietaData();
        List<Dieta> dietaList = dd.listaDieta();
        Iterator iterador = dietaList.iterator();
        while (iterador.hasNext()) {
            Dieta dieta = (Dieta) iterador.next();
            if (dieta.getFechaFinal().compareTo(LocalDate.now()) > 0) {// 0 si son iguales, -1 cuando el segundo es mayor que lo primero, 1 si lo segundo es menor a lo primero
                iterador.remove();
            }

        }
        for (Dieta dieta : dietaList) {
            modeloTabla.addRow(new Object[]{dieta, dieta.getPaciente(), dieta.getPesoInicial(), dieta.getPesoFinal(), dieta.getFechaInicial(), dieta.getFechaFinal()});
        }
    }//GEN-LAST:event_jrbDietaNoActivaActionPerformed

    private void jrbDietaActivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDietaActivaActionPerformed
        limpiar();
        tableClean();
        jbModificar.setEnabled(false);
        jbAgregar.setEnabled(true);
        jrbDietaNoActiva.setSelected(false);
        jbConfigDieta.setEnabled(false);
        jbEliminar.setEnabled(false);
        DietaData dd = new DietaData();
        List<Dieta> dietaList = dd.listaDieta();
        for (Dieta dieta : dietaList) {

            if (dieta.getFechaFinal().compareTo(LocalDate.now()) > 0) {// 0 si son iguales, -1 cuando el segundo es mayor que lo primero, 1 si lo segundo es menor a lo primero
                modeloTabla.addRow(new Object[]{dieta, dieta.getPaciente(), dieta.getPesoInicial(), dieta.getPesoFinal(), dieta.getFechaInicial(), dieta.getFechaFinal()});
            }
        }
    }//GEN-LAST:event_jrbDietaActivaActionPerformed

    private void jbVaciarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVaciarCamposActionPerformed
        limpiar();
        jbAgregar.setEnabled(true);
        jbModificar.setEnabled(false);
        jrbDietaActiva.setSelected(false);
        jrbDietaNoActiva.setSelected(false);
        jbConfigDieta.setEnabled(false);
        jbEliminar.setEnabled(false);
        tableClean();
        llenarTabla();
    }//GEN-LAST:event_jbVaciarCamposActionPerformed

    private void jtCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCerrarActionPerformed
        this.dispose();
        MainMenu.getMainMenu().reinicializarBotonesDesdeVistas();
    }//GEN-LAST:event_jtCerrarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            if (Validaciones.validacionDNI(dni = JOptionPane.showInputDialog(this, "Ingrese el DNI del paciente"))) {
                PacienteData pData = new PacienteData();
                Paciente paciente = pData.buscarPacienteXDni(Integer.parseInt(dni));
                jtPaciente.setText(paciente.getNombre());
            }

        } catch (NullPointerException e) {
        }


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        try {
            if (Validaciones.validacionNombrePaciente(jtNombreDieta.getText()) && Validaciones.validacionPeso((double) jsPesoFinal.getValue()) && Validaciones.validacionPeso((double) jsPesoInicial.getValue())
                    && Validaciones.validacionFechaFinal(jdFechaInit.getDate(), jdFechaFin.getDate())) {
                DietaData dd = new DietaData();
                PacienteData pd = new PacienteData();
                Dieta dieta = new Dieta();
                dieta.setIdDieta(((Dieta)modeloTabla.getValueAt(jtDieta.getSelectedRow(), 0)).getIdDieta());
                dieta.setNombre(jtNombreDieta.getText());
                if(jtPaciente.getText().equals("")){
                    dieta.setPaciente(null);
                }else{
                    dieta.setPaciente(pd.buscarPacienteXDni(Integer.parseInt(dni)));
                }
                dieta.setFechaInicial(jdFechaInit.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                dieta.setFechaFinal(jdFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                dieta.setPesoInicial((double) jsPesoInicial.getValue());
                dieta.setPesoFinal((double) jsPesoFinal.getValue());
                dd.modificarDieta(dieta);
                jbAgregar.setEnabled(true);
                jbModificar.setEnabled(false);
                jbEliminar.setEnabled(false);
                jrbDietaActiva.setSelected(false);
                jrbDietaNoActiva.setSelected(false);
                jbConfigDieta.setEnabled(false);
                tableClean();
                llenarTabla();
                limpiar();
            }
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "No se permiten campos vacíos y/o caracteres inválidos.");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea Eliminar?") == 0) {
            DietaData dd = new DietaData();
            jbAgregar.setEnabled(true);
            jbModificar.setEnabled(false);
            jbEliminar.setEnabled(false);
            jrbDietaActiva.setSelected(false);
            jrbDietaNoActiva.setSelected(false);
            jbConfigDieta.setEnabled(false);
            dd.borrarDieta(((Dieta)modeloTabla.getValueAt(jtDieta.getSelectedRow(), 0)).getIdDieta());
            limpiar();
            tableClean();
            llenarTabla();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbConfigDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfigDietaActionPerformed
        if (dietaComidaVista != null) {
            getMainMenu().removerVista(dietaComidaVista);
        }
        dietaComidaVista = new DietaComidaVista();
        dietaComidaVista.setVisible(true);
        getMainMenu().agregarVista(dietaComidaVista);
    }//GEN-LAST:event_jbConfigDietaActionPerformed

    private void jPaneInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPaneInfoMouseEntered
        jPaneInfo.setBackground(new Color(195, 255, 184));
        jLInfo.setForeground(Color.BLACK);
    }//GEN-LAST:event_jPaneInfoMouseEntered

    private void jPaneInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPaneInfoMouseExited
        jPaneInfo.setBackground(new Color(140, 184, 132));
        jLInfo.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPaneInfoMouseExited

    private void jPaneInfoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPaneInfoMouseReleased
        JOptionPane.showMessageDialog(this, "-Para agregar una dieta, escriba el nombre, presione el botón [Buscar] e ingrese el DNI del paciente, "
                + "\ncargue la fecha inicial y la fecha final del plan nutricional, ingrese el peso inicial y final del paciente y presione el botón [Agregar].\n" +
"\n" +
"-Para limpiar todos los campos presione el botón [Limpiar].\n" +
"\n" +
"-Para ver el detalle de la dieta, seleccionela en la tabla y presione el botón [Configurar Dieta].\n" +
"\n" +
"-Para modificar una dieta, seleccionela en la tabla, modifique los datos que desea actualizar y presione el botón [Modificar].\n" +
"\n" +
"-Para eliminar una dieta, seleccionela en la tabla (asegurese que la dieta no tiene consumisiones) y presione el botón [Eliminar].");
    }//GEN-LAST:event_jPaneInfoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPaneInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbConfigDieta;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVaciarCampos;
    private com.toedter.calendar.JDateChooser jdFechaFin;
    private com.toedter.calendar.JDateChooser jdFechaInit;
    private javax.swing.JRadioButton jrbDietaActiva;
    private javax.swing.JRadioButton jrbDietaNoActiva;
    private javax.swing.JSpinner jsPesoFinal;
    private javax.swing.JSpinner jsPesoInicial;
    private javax.swing.JToggleButton jtCerrar;
    private javax.swing.JTable jtDieta;
    private javax.swing.JTextField jtNombreDieta;
    private javax.swing.JTextField jtPaciente;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {// Arma la cabecera de la tabla
        modeloTabla.addColumn("Dieta");
        modeloTabla.addColumn("Paciente");
        modeloTabla.addColumn("PI");
        modeloTabla.addColumn("PF");
        modeloTabla.addColumn("Fecha Inicial");
        modeloTabla.addColumn("Fecha Final");
        jtDieta.setModel(modeloTabla);
        jtDieta.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtDieta.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtDieta.getColumnModel().getColumn(2).setPreferredWidth(20);
        jtDieta.getColumnModel().getColumn(3).setPreferredWidth(20);
        jtDieta.getColumnModel().getColumn(4).setPreferredWidth(80);
        jtDieta.getColumnModel().getColumn(5).setPreferredWidth(80);

        JTableHeader header = jtDieta.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer(jtDieta));
    }

    private void llenarTabla() {
        DietaData dData = new DietaData();
        List<Dieta> listaDieta = dData.listaDieta();
        for (Dieta dieta : listaDieta) {
            modeloTabla.addRow(new Object[]{ dieta, dieta.getPaciente(), dieta.getPesoInicial(), dieta.getPesoFinal(), dieta.getFechaInicial(), dieta.getFechaFinal()});

        }
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//Alinea los datos de las celdas numericas a la derecha 
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jtDieta.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtDieta.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtDieta.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jtDieta.getColumnModel().getColumn(5).setCellRenderer(tcr);

    }

    private void tableClean() {
        //limpia la tabla de dietas
        if (jtDieta.getRowCount() != 0) {
            int largo = jtDieta.getRowCount() - 1;
            for (; largo >= 0; largo--) {
                modeloTabla.removeRow(largo);
            }
        }
    }

    private void limpiar() {
        //Limpia los campos
        jtNombreDieta.setText("");
        jtPaciente.setText("");
        jdFechaFin.setCalendar(null);
        jdFechaInit.setCalendar(null);
        jsPesoFinal.setValue((double) 0);
        jsPesoInicial.setValue((double) 0);
    }

}
