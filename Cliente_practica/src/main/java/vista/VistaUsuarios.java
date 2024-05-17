/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;

/**
 *
 * @author gerli
 */
public class VistaUsuarios extends javax.swing.JFrame implements ActionListener  {
private IUsuarioController usuarioController;
private DefaultTableModel modeloTablaUsuarios;
    /**
     * Creates new form VistaUsuarios
     */
    public VistaUsuarios() {
        initComponents();
          try {
            usuarioController = (IUsuarioController) Naming.lookup("rmi://localhost/UsuarioController");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        
         btnListarUsuarios.addActionListener(this);
         btnGuardarUsuario.addActionListener(this);
         btnEliminarUsuario.addActionListener(this);
         
          modeloTablaUsuarios =(DefaultTableModel) tablaUsuarios.getModel();
        
          
    }
    
    //metodo de la implementacion ActionLIstener
    //aqui se llaman a los metodos cuando se presiona el boton correspondiente
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==btnListarUsuarios){
        listarUsuarios();
    }else if (e.getSource()==btnGuardarUsuario){
      agregarUsuario();  
    }else if(e.getSource()==btnEliminarUsuario){
        eliminarUsuario();
    }
}
     /************************************************************************************************/
     /************************************************************************************************/
     /************************************************************************************************/
     /************************************************************************************************/
   private void listarUsuarios(){
       try{
           modeloTablaUsuarios.setRowCount(0);
           List<IUsuario> usuarios  = usuarioController.list();
           for(IUsuario usuario: usuarios){
               String id = String.valueOf(usuario.getId());
               String nombre = usuario.getNombre();
               String direccion = usuario.getDireccion();
               String telefono = usuario.getTelefono();
               String numeroIdentificacion = usuario.getNumeroIdentificacion();
               
               //agregar cada usuario a la tabla: 
               Object[] fila = {id, nombre,direccion,telefono,numeroIdentificacion};
               modeloTablaUsuarios.addRow(fila);
           
           }
           
           
       }catch (RemoteException e) {
            e.printStackTrace();
        }
   }//fin del metodo listar Usuarios 
   
   /************************************************************************************************/
     /************************************************************************************************/
     /************************************************************************************************/
     /************************************************************************************************/
   private void agregarUsuario(){
       try{
       IUsuario usuarioNuevo = usuarioController.newInstance();
        int id =Integer.parseInt(txtFID.getText());
        String nombre = txtFNombre.getText();
        String  direccion = txtFDireccion.getText();
        String telefono = txtFTelefono.getText();
        String numeroIdentificacion = txtFIdentificacion.getText();
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setDireccion(direccion);
        usuarioNuevo.setTelefono(telefono);
        usuarioNuevo.setNumeroIdentificacion(numeroIdentificacion);
           
        int respueta = usuarioController.add(usuarioNuevo);
        listarUsuarios();
        
   } catch (RemoteException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        // Manejar el error de formato incorrecto
        e.printStackTrace();
    }
   }
        /************************************************************************************************/
     /************************************************************************************************/
     /************************************************************************************************/
   
     private void eliminarUsuario(){
         try {
          int id =Integer.parseInt(txtFID.getText());
        IUsuario usuarioEliminado = usuarioController.newInstance();
        usuarioEliminado.setId(id);
        int respuesta = usuarioController.delete(usuarioEliminado);
        listarUsuarios(); // Actualiza la lista de libros en la tabla
    } catch (RemoteException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        // Manejar el error de formato incorrecto
        e.printStackTrace();
    }
     }

   //

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        panelDeDatos = new javax.swing.JPanel();
        jLabelId = new javax.swing.JLabel();
        JLabelNombre = new javax.swing.JLabel();
        JLabelDireccion = new javax.swing.JLabel();
        txtFID = new javax.swing.JTextField();
        txtFNombre = new javax.swing.JTextField();
        txtFDireccion = new javax.swing.JTextField();
        labelGenero = new javax.swing.JLabel();
        labelPublicacion = new javax.swing.JLabel();
        txtFTelefono = new javax.swing.JTextField();
        txtFIdentificacion = new javax.swing.JTextField();
        btnGuardarUsuario = new javax.swing.JButton();
        btnListarUsuarios = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnOkUsuarios = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        panelDeDetalles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnCambiarLibros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelTitulo.setText("Sistema bibliotecario de Ixhuatlan del Sureste");

        jLabelSubtitulo.setText("Gestion de usuarios");

        panelDeDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabelId.setText("ID:");

        JLabelNombre.setText("Nombre:");

        JLabelDireccion.setText("Direccion");

        txtFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFIDActionPerformed(evt);
            }
        });

        txtFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNombreActionPerformed(evt);
            }
        });

        labelGenero.setText("Telefono:");

        labelPublicacion.setText("Identifiacion:");

        btnGuardarUsuario.setText("Guardar usuario");
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        btnListarUsuarios.setText("Listar usuarios");
        btnListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarUsuariosActionPerformed(evt);
            }
        });

        btnEditarUsuario.setText("Editar");

        btnOkUsuarios.setText("OK ");

        btnEliminarUsuario.setText("Eliminar usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDeDatosLayout = new javax.swing.GroupLayout(panelDeDatos);
        panelDeDatos.setLayout(panelDeDatosLayout);
        panelDeDatosLayout.setHorizontalGroup(
            panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeDatosLayout.createSequentialGroup()
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelId)
                            .addComponent(JLabelNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelDeDatosLayout.createSequentialGroup()
                        .addComponent(JLabelDireccion)
                        .addGap(8, 8, 8)))
                .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtFID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeDatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeDatosLayout.createSequentialGroup()
                                .addComponent(labelGenero)
                                .addGap(32, 32, 32))
                            .addGroup(panelDeDatosLayout.createSequentialGroup()
                                .addComponent(labelPublicacion)
                                .addGap(8, 8, 8)))
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(txtFTelefono)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeDatosLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeDatosLayout.createSequentialGroup()
                        .addComponent(btnOkUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarUsuario))
                    .addComponent(btnListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        panelDeDatosLayout.setVerticalGroup(
            panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeDatosLayout.createSequentialGroup()
                .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelId)
                            .addComponent(txtFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelGenero)
                            .addComponent(txtFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelNombre)
                            .addComponent(txtFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPublicacion)
                            .addComponent(txtFIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeDatosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarUsuario)
                            .addComponent(btnListarUsuarios))
                        .addGap(4, 4, 4)))
                .addGap(30, 30, 30)
                .addGroup(panelDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarUsuario)
                    .addComponent(btnOkUsuarios)
                    .addComponent(btnEditarUsuario))
                .addContainerGap())
        );

        panelDeDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Direccion", "Telefono", "Identificacion"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout panelDeDetallesLayout = new javax.swing.GroupLayout(panelDeDetalles);
        panelDeDetalles.setLayout(panelDeDetallesLayout);
        panelDeDetallesLayout.setHorizontalGroup(
            panelDeDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDeDetallesLayout.setVerticalGroup(
            panelDeDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnCambiarLibros.setText("cambiar a inventario de libros");
        btnCambiarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarLibrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDeDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelSubtitulo)
                        .addGap(283, 283, 283))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCambiarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabelSubtitulo)
                .addGap(44, 44, 44)
                .addComponent(panelDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(panelDeDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCambiarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panelDeDatos.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFIDActionPerformed

    private void txtFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNombreActionPerformed

    private void btnListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarUsuariosActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed

    private void btnCambiarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarLibrosActionPerformed
        // TODO add your handling code here:
       // Ocultar la ventana actual de usuarios
    this.setVisible(false);
    
    // Crear una instancia de la vista de libros
    Vista vista = new Vista();
    
    // Hacer visible la ventana de libros
    vista.setVisible(true); 
    }//GEN-LAST:event_btnCambiarLibrosActionPerformed

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
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelDireccion;
    private javax.swing.JLabel JLabelNombre;
    private javax.swing.JButton btnCambiarLibros;
    public javax.swing.JButton btnEditarUsuario;
    public javax.swing.JButton btnEliminarUsuario;
    public javax.swing.JButton btnGuardarUsuario;
    public javax.swing.JButton btnListarUsuarios;
    public javax.swing.JButton btnOkUsuarios;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelPublicacion;
    public javax.swing.JPanel panelDeDatos;
    private javax.swing.JPanel panelDeDetalles;
    public javax.swing.JTable tablaUsuarios;
    public javax.swing.JTextField txtFDireccion;
    public javax.swing.JTextField txtFID;
    public javax.swing.JTextField txtFIdentificacion;
    public javax.swing.JTextField txtFNombre;
    public javax.swing.JTextField txtFTelefono;
    // End of variables declaration//GEN-END:variables
}
