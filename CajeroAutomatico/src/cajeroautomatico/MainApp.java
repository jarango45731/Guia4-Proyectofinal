/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

import cajeroautomatico.modelo.Cuenta;
import java.awt.event.WindowEvent;

/**
 *
 * @author jose
 */
public class MainApp extends javax.swing.JFrame {
    public static Cuenta CUENTA_ACTUAL;
    
    /**
     * Creates new form MainApp
     */
    public MainApp() {
        initComponents();
    }
    
    public void seleccionarFormulario(FormularioEnum formulario) {
        this.ocultarFormularios();
        switch(formulario) {
            case CREAR_CUENTA:
                this.crearCuentaForm2.limpiarFormulario();
                this.crearCuentaForm2.setVisible(true);
                break;
            case INGRESAR_CAJERO:
                this.ingresarCajeroForm1.limpiarFormulario();
                this.ingresarCajeroForm1.setVisible(true);
                break;
            case CAJERO:
                this.cajeroForm2.limpiarFormulario();
                this.cajeroForm2.setCuenta(CUENTA_ACTUAL);
                this.cajeroForm2.setVisible(true);
                break;
            case CERRAR_CUENTA:
                this.cerrarCuentaForm1.limpiarFormulario();
                this.cerrarCuentaForm1.setVisible(true);
                break;
        }
    }
    
    private void ocultarFormularios() {
        this.crearCuentaForm2.setVisible(false);
        this.ingresarCajeroForm1.setVisible(false);
        this.cajeroForm2.setVisible(false);
        this.cerrarCuentaForm1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        crearCuentaForm2 = new cajeroautomatico.CrearCuentaForm();
        cajeroForm2 = new cajeroautomatico.CajeroForm();
        cerrarCuentaForm1 = new cajeroautomatico.CerrarCuentaForm();
        ingresarCajeroForm1 = new cajeroautomatico.IngresarCajeroForm();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemCrearCuenta = new javax.swing.JMenuItem();
        menuItemIngresarCajero = new javax.swing.JMenuItem();
        menuItemCerrarCuenta = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new java.awt.CardLayout());
        jLayeredPane1.add(crearCuentaForm2, "card2");
        jLayeredPane1.add(cajeroForm2, "card3");
        jLayeredPane1.add(cerrarCuentaForm1, "card4");
        jLayeredPane1.add(ingresarCajeroForm1, "card5");

        jMenu1.setText("Opciones");

        menuItemCrearCuenta.setText("Crear cuenta");
        menuItemCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCuentaActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCrearCuenta);

        menuItemIngresarCajero.setText("Ingresar al cajero");
        menuItemIngresarCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIngresarCajeroActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemIngresarCajero);

        menuItemCerrarCuenta.setText("Cerrar cuenta");
        menuItemCerrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarCuentaActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCerrarCuenta);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemIngresarCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIngresarCajeroActionPerformed
        this.seleccionarFormulario(FormularioEnum.INGRESAR_CAJERO);
    }//GEN-LAST:event_menuItemIngresarCajeroActionPerformed

    private void menuItemCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCuentaActionPerformed
        this.seleccionarFormulario(FormularioEnum.CREAR_CUENTA);
    }//GEN-LAST:event_menuItemCrearCuentaActionPerformed

    private void menuItemCerrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarCuentaActionPerformed
        this.seleccionarFormulario(FormularioEnum.CERRAR_CUENTA);
    }//GEN-LAST:event_menuItemCerrarCuentaActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_menuItemSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cajeroautomatico.CajeroForm cajeroForm2;
    private cajeroautomatico.CerrarCuentaForm cerrarCuentaForm1;
    private cajeroautomatico.CrearCuentaForm crearCuentaForm2;
    private cajeroautomatico.IngresarCajeroForm ingresarCajeroForm1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemCerrarCuenta;
    private javax.swing.JMenuItem menuItemCrearCuenta;
    private javax.swing.JMenuItem menuItemIngresarCajero;
    private javax.swing.JMenuItem menuItemSalir;
    // End of variables declaration//GEN-END:variables
}
