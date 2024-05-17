package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import las_interfaces.*;
import las_interfaces.ILibroController;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gerli
 */
public class Vista extends javax.swing.JFrame implements ActionListener {
    private ILibroController libroController;
    private DefaultTableModel modeloTabla;

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        try {
            libroController = (ILibroController) Naming.lookup("rmi://localhost/LibroController");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        btnEditar.addActionListener(this);// Agregar el ActionListener al botón "Eliminar"
        btnEliminar.addActionListener(this);// Agregar el ActionListener al botón "Eliminar"
        btnGuardar.addActionListener(this);// Agregar el ActionListener al botón "Guardar"
        btnListar.addActionListener(this); // Agregar el ActionListener al botón "Listar"
        modeloTabla = (DefaultTableModel) tabla.getModel(); // Obtener el modelo de la tabla
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnListar) {
            listarLibros(); // Llamar al método para listar usuarios
        } else if (e.getSource() == btnGuardar) {
            agregarLibro(); // Llamar al método para agregar un nuevo libro
        } else if (e.getSource() == btnEliminar) {
            eliminarLibro();
        } else if (e.getSource() == btnEditar) {
            actualizarLibro();
        }
    }

    /************************************************************************************************/
    /************************************************************************************************/
    /************************************************************************************************/
    /************************************************************************************************/
    private void listarLibros() {
        try {
            modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            List<ILibro> libros = libroController.list(); // Obtener la lista de usuarios del servidor
            for (ILibro libro : libros) {
                // Agregar cada usuario a la tabla
                String id = String.valueOf(libro.getId());
                String titulo = libro.getTitulo();
                String autor = libro.getAutor();
                String genero = libro.getGenero();
                String anioPublicacion = String.valueOf(libro.getAnioPublicacion());
                String copiasDisponibles = String.valueOf(libro.getCopiasDisponibles());

                // Agregar cada libro a la tabla
                Object[] fila = { id, titulo, autor, genero, anioPublicacion, copiasDisponibles };
                modeloTabla.addRow(fila);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /************************************************************************************************/
    private void agregarLibro() {
        try {
            int id = Integer.parseInt(txtFId.getText());
            String titulo = txtFTitulo.getText();
            String autor = txtFAutor.getText();
            String genero = txtFGenero.getText();
            int anioPublicacion = Integer.parseInt(txtFPublicacion.getText());
            int copiasDisponibles = Integer.parseInt(txtTCopias.getText());
            ILibro libroNuevo = libroController.newInstance();
            libroNuevo.setTitulo(titulo);
            libroNuevo.setAutor(autor);
            libroNuevo.setGenero(genero);
            libroNuevo.setAnioPublicacion(anioPublicacion);
            libroNuevo.setCopiasDisponibles(copiasDisponibles);

            libroController.add(libroNuevo); // Llama al método remoto para agregar el libro

            listarLibros(); // Actualiza la lista de libros en la tabla
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

    private void eliminarLibro() {
        try {
            int id = Integer.parseInt(txtFId.getText());
            ILibro libroEliminado = libroController.newInstance();
            libroEliminado.setId(id);
            int respuesta = libroController.delete(libroEliminado);

            listarLibros(); // Actualiza la lista de libros en la tabla
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
    private void actualizarLibro() {
        try {
            int id = Integer.parseInt(txtFId.getText());
            ILibro libroActualizado = libroController.newInstance();
            libroActualizado.setId(id);
            int respuesta = libroController.update(libroActualizado);
            listarLibros(); // Actualiza la lista de libros en la tabla
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Manejar el error de formato incorrecto
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDatos = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelAutor = new javax.swing.JLabel();
        txtFId = new javax.swing.JTextField();
        txtFTitulo = new javax.swing.JTextField();
        txtFAutor = new javax.swing.JTextField();
        labelGenero = new javax.swing.JLabel();
        labelPublicacion = new javax.swing.JLabel();
        labelCopias = new javax.swing.JLabel();
        txtFGenero = new javax.swing.JTextField();
        txtFPublicacion = new javax.swing.JTextField();
        txtTCopias = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanelDetalles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jlabeTitulo = new javax.swing.JLabel();
        jlabelInventarioLibros = new javax.swing.JLabel();
        btnCambiarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        labelId.setText("ID:");

        labelTitulo.setText("Titulo:");

        labelAutor.setText("Autor:");

        txtFId.setText("1");
        txtFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFIdActionPerformed(evt);
            }
        });

        txtFTitulo.setText("El Alquimista");
        txtFTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFTituloActionPerformed(evt);
            }
        });

        txtFAutor.setText("Paulo Coelho");

        labelGenero.setText("Genero");

        labelPublicacion.setText("Publicacion");

        labelCopias.setText("Copias");

        txtFGenero.setText("Novela, autoayuda");

        txtFPublicacion.setText("1988");

        txtTCopias.setText("2500");

        btnGuardar.setText("Guardar");

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");

        btnOk.setText("OK ");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
                jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDatosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelDatosLayout.createSequentialGroup()
                                                .addGroup(jPanelDatosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                89, Short.MAX_VALUE)
                                                        .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelDatosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnEliminar,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanelDatosLayout.createSequentialGroup()
                                                                .addComponent(btnEditar)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnOk))))
                                        .addGroup(jPanelDatosLayout.createSequentialGroup()
                                                .addGroup(jPanelDatosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanelDatosLayout.createSequentialGroup()
                                                                        .addGroup(jPanelDatosLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(labelId)
                                                                                .addComponent(labelTitulo))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(jPanelDatosLayout.createSequentialGroup()
                                                                .addComponent(labelAutor)
                                                                .addGap(8, 8, 8)))
                                                .addGroup(jPanelDatosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(txtFAutor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                1, Short.MAX_VALUE)
                                                        .addComponent(txtFId, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtFTitulo,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 89,
                                                                Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelDatosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelDatosLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanelDatosLayout.createSequentialGroup()
                                                                                .addComponent(labelGenero)
                                                                                .addGap(32, 32, 32))
                                                                .addGroup(jPanelDatosLayout.createSequentialGroup()
                                                                        .addComponent(labelPublicacion)
                                                                        .addGap(8, 8, 8)))
                                                        .addGroup(jPanelDatosLayout.createSequentialGroup()
                                                                .addComponent(labelCopias)
                                                                .addGap(34, 34, 34)))
                                                .addGroup(jPanelDatosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtTCopias)
                                                        .addComponent(txtFPublicacion,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtFGenero,
                                                                javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap(248, Short.MAX_VALUE)));
        jPanelDatosLayout.setVerticalGroup(
                jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDatosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelId)
                                        .addComponent(txtFId, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelGenero)
                                        .addComponent(txtFGenero, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDatosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTitulo)
                                        .addComponent(txtFTitulo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPublicacion)
                                        .addComponent(txtFPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDatosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelDatosLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtFAutor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelCopias)
                                                .addComponent(txtTCopias, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25,
                                        Short.MAX_VALUE)
                                .addGroup(jPanelDatosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnGuardar)
                                        .addComponent(btnEditar)
                                        .addComponent(btnOk))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDatosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnListar)
                                        .addComponent(btnEliminar))));

        jPanelDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "TITULO", "AUTOR", "GENERO", "PUBLICACION", "COPIAS DISPONIBLES"
                }));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanelDetallesLayout = new javax.swing.GroupLayout(jPanelDetalles);
        jPanelDetalles.setLayout(jPanelDetallesLayout);
        jPanelDetallesLayout.setHorizontalGroup(
                jPanelDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDetallesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanelDetallesLayout.setVerticalGroup(
                jPanelDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199,
                                javax.swing.GroupLayout.PREFERRED_SIZE));

        jlabeTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jlabeTitulo.setText("sistema bibliotecario de Ixhuatlan del Sureste");

        jlabelInventarioLibros.setText("Inventario de libros");

        btnCambiarUsuario.setText("Cambiar a gestion de usuarios");
        btnCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jPanelDetalles,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanelDatos,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlabeTitulo)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(166, 166, 166)
                                                                .addComponent(jlabelInventarioLibros))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(236, 236, 236)
                                                .addComponent(btnCambiarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(58, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(55, Short.MAX_VALUE)
                                .addComponent(jlabeTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlabelInventarioLibros)
                                .addGap(9, 9, 9)
                                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jPanelDetalles, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnCambiarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFTituloActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFTituloActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtFTituloActionPerformed

    private void txtFIdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFIdActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtFIdActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnListarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCambiarUsuarioActionPerformed
     // Ocultar la ventana actual de libros
    this.setVisible(false);
    
    
    //cerrar conexion con la base de datos
    try {
        libroController.cerrarConexion();
} catch (RemoteException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
    
    // Crear una instancia de la vista de usuarios
    VistaUsuarios vistaUsuarios = new VistaUsuarios();
    
    // Hacer visible la ventana de usuarios
    vistaUsuarios.setVisible(true);
    }// GEN-LAST:event_btnCambiarUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarUsuario;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelDetalles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabeTitulo;
    private javax.swing.JLabel jlabelInventarioLibros;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelCopias;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelPublicacion;
    private javax.swing.JLabel labelTitulo;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtFAutor;
    public javax.swing.JTextField txtFGenero;
    public javax.swing.JTextField txtFId;
    public javax.swing.JTextField txtFPublicacion;
    public javax.swing.JTextField txtFTitulo;
    public javax.swing.JTextField txtTCopias;
    // End of variables declaration//GEN-END:variables
}
