package universidadgrupo10.vistas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadgrupo10.entidades.*;
import universidadgrupo10.accesoADatos.*;
public class FormularioInscripcion extends javax.swing.JFrame {
    
    ArrayList<Materia> listaMat;
    ArrayList<Alumno> listaAlu;
    
    private inscripcionData inscData; //objeto para crear inscripcion o guardar o anular
    private materiaData matData;
    private alumnoData aluData;
    
    
    private DefaultTableModel modelo;
    
    public FormularioInscripcion() {
        initComponents();
        
        aluData=new alumnoData();
        listaAlu = (ArrayList <Alumno>)aluData.listarAlumnos();
        modelo = new DefaultTableModel();
        cargaAlumnos();
        armarCabeceraTabla();
        inscData = new inscripcionData();
        matData = new materiaData();
        
    }

    private void cargaAlumnos(){    //carga los alumnos al combobox
        for (Alumno alu : listaAlu) {
            boxalu.addItem(alu.getNombre());
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxalu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        rbMateria = new javax.swing.JRadioButton();
        rbMateriaNo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        botonInscribir = new javax.swing.JButton();
        botonAnular = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un alumno:");

        boxalu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Listado de Materias");

        rbMateria.setText("Materias Inscriptas");
        rbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMateriaActionPerformed(evt);
            }
        });

        rbMateriaNo.setText("Materias No inscriptas");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        botonInscribir.setText("Inscribir");
        botonInscribir.setEnabled(false);

        botonAnular.setText("Anular Inscripcion");
        botonAnular.setEnabled(false);

        botonSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbMateria)
                                .addGap(46, 46, 46)
                                .addComponent(rbMateriaNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(boxalu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonInscribir)
                .addGap(88, 88, 88)
                .addComponent(botonAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonSalir)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(boxalu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMateria)
                    .addComponent(rbMateriaNo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInscribir)
                    .addComponent(botonAnular)
                    .addComponent(botonSalir))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMateriaActionPerformed
        borrarFilasTabla();
        rbMateriaNo.setSelected(false);
        
        cargarInscriptas();
        botonAnular.setEnabled(true);
        botonInscribir.setEnabled(false);
        
        
    }//GEN-LAST:event_rbMateriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioInscripcion().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnular;
    private javax.swing.JButton botonInscribir;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox<String> boxalu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbMateria;
    private javax.swing.JRadioButton rbMateriaNo;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

private void armarCabeceraTabla(){
    ArrayList<Object> filaCabecera = new ArrayList<>();
    
    filaCabecera.add("ID");
    filaCabecera.add("Nombre");
    filaCabecera.add("Año");
    for(Object it: filaCabecera){
        modelo.addColumn(it);
    }
    table.setModel(modelo);
}

private void borrarFilasTabla(){
    int ind= modelo.getRowCount() -1;
    
    for(int i = ind ; i >= 0 ; i--){
        modelo.removeRow(i);
    }
}

private void noInscriptas(){
    
    //borrar filas de tabla
    
    Alumno al = (Alumno)boxalu.getSelectedItem();
    listaMat = (ArrayList) inscData.obtenerMateriasNoCursadas(al.getIdAlumno());
    for (Materia m: listaMat){
        modelo.addRow(new Object[] {m.getIdMateria(), m.getNombre(), m.getAño()});
    }
}

private void cargarInscriptas(){
    
        Alumno al = (Alumno)boxalu.getSelectedItem();
        List <Materia> lista = inscData.obtenerMateriasCursadas(al.getIdAlumno());
        for (Materia m: listaMat){
        modelo.addRow(new Object[] {m.getIdMateria(), m.getNombre(), m.getAño()});
        }
    }

}



