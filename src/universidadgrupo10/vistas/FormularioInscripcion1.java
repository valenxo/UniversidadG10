package universidadgrupo10.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadgrupo10.entidades.*;
import universidadgrupo10.accesoADatos.*;

public class FormularioInscripcion1 extends javax.swing.JFrame {
    
    List<Materia> listaM;
    List<Alumno> listaA;
    
    private inscripcionData inscData; //objeto para crear inscripcion o guardar o anular
    private materiaData mData;
    private alumnoData aData;
    
    
    private DefaultTableModel modelo;
    
    public FormularioInscripcion1() {
        initComponents();
        
        aData=new alumnoData();
        listaA = aData.listarAlumnos();
        modelo = new DefaultTableModel();
        inscData = new inscripcionData();
        mData = new materiaData();
        cargaAlumnos();
        armarCabeceraTabla();

    }

    private void cargaAlumnos(){    //carga los alumnos al combobox
        for (Alumno item : listaA) {
            boxalu.addItem(item);
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbMateria = new javax.swing.JRadioButton();
        rbMateriaNo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        botonInscribir = new javax.swing.JButton();
        botonAnular = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        boxalu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un alumno:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Listado de Materias");

        rbMateria.setText("Materias Inscriptas");
        rbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMateriaActionPerformed(evt);
            }
        });

        rbMateriaNo.setText("Materias No inscriptas");
        rbMateriaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMateriaNoActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMaterias);

        botonInscribir.setText("Inscribir");
        botonInscribir.setEnabled(false);
        botonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInscribirActionPerformed(evt);
            }
        });

        botonAnular.setText("Anular Inscripcion");
        botonAnular.setEnabled(false);
        botonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnularActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbMateria)
                                .addGap(46, 46, 46)
                                .addComponent(rbMateriaNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(boxalu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(102, Short.MAX_VALUE))
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

    private void rbMateriaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMateriaNoActionPerformed
        borrarFilasTabla();
        rbMateria.setSelected(false);
        
        noInscriptas();
         botonAnular.setEnabled(false);
        botonInscribir.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMateriaNoActionPerformed

    private void botonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInscribirActionPerformed
     
        int filaseleccionada= jtMaterias.getSelectedRow();
        if(filaseleccionada!=1){
            Alumno a=(Alumno)boxalu.getSelectedItem();
            int idMateria=(Integer)modelo.getValueAt(filaseleccionada, 0);
            String Nombre=(String)modelo.getValueAt(filaseleccionada, 1);
            int Año=(Integer)modelo.getValueAt(filaseleccionada, 2);
            Materia m= new Materia(idMateria,Nombre,Año,true);
            
            Inscripcion i= new Inscripcion(a,m,0);
            inscData.guardarInscripcion(i);
            borrarFilasTabla();
        }
    }//GEN-LAST:event_botonInscribirActionPerformed

    private void botonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnularActionPerformed
        
        int filaseleccionada= jtMaterias.getSelectedRow();
        if(filaseleccionada!=1){
            Alumno a=(Alumno)boxalu.getSelectedItem();
            int idMateria=(Integer)modelo.getValueAt(filaseleccionada, 0);
            
            inscData.borrarInscripcionMateriaAlumno(a.getIdAlumno(), idMateria);
            borrarFilasTabla();
        }
        
    }//GEN-LAST:event_botonAnularActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_botonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioInscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioInscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioInscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioInscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioInscripcion1().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnular;
    private javax.swing.JButton botonInscribir;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox<Alumno> boxalu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMaterias;
    private javax.swing.JRadioButton rbMateria;
    private javax.swing.JRadioButton rbMateriaNo;
    // End of variables declaration//GEN-END:variables

private void armarCabeceraTabla(){
    ArrayList<Object> filaCabecera = new ArrayList<>();
    
    filaCabecera.add("ID");
    filaCabecera.add("Nombre");
    filaCabecera.add("Año");
    for(Object it: filaCabecera){
        modelo.addColumn(it);
    }
    jtMaterias.setModel(modelo);
}

private void borrarFilasTabla(){
    int ind= modelo.getRowCount() -1;
    
    for(int i = ind ; i >= 0 ; i--){
        modelo.removeRow(i);
    }
}

private void noInscriptas(){
    
    //borrar filas de tabla
    
    Alumno alSelec = (Alumno)boxalu.getSelectedItem();
    listaM = inscData.obtenerMateriasNoCursadas(alSelec.getIdAlumno());
    for (Materia m: listaM){
        modelo.addRow(new Object[] {m.getIdMateria(), m.getNombre(), m.getAño()});
    }
}

private void cargarInscriptas() {
    Alumno al = (Alumno) boxalu.getSelectedItem();
    List<Materia> lista = inscData.obtenerMateriasCursadas(al.getIdAlumno());
    for (Materia m : lista) {
        modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAño()});
    }
}


}



