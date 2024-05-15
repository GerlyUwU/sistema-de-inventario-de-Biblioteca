package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import las_interfaces.ILibro;
import las_interfaces.ILibroController;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;

public class GUI extends JFrame {

    private IUsuarioController usuarioController;
    private ILibroController libroController;

    public GUI() {
        setTitle("Sistema de Gestión de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Cargar datos de RMI
        try {
            usuarioController = (IUsuarioController) Naming.lookup("rmi://localhost/UsuarioController");
            List<IUsuario> lista = usuarioController.list();
            for (IUsuario usuario : lista) {
                System.out.println(usuario.getString());
            }
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar datos de RMI", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addButton = new JButton("Registrar Libro");
        // ActionListener para el botón "Registrar Libro"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear paneles y campos de texto para los datos del libro
                JPanel bookPanel = new JPanel();
                bookPanel.setLayout(new GridLayout(6, 2));
                JTextField idField = new JTextField(10);
                JTextField titleField = new JTextField(10);
                JTextField authorField = new JTextField(10);
                JTextField genreField = new JTextField(10);
                JTextField yearField = new JTextField(10);
                JTextField copiesField = new JTextField(10);

                // Agregar etiquetas y campos de texto al panel
                bookPanel.add(new JLabel("ID:"));
                bookPanel.add(idField);
                bookPanel.add(new JLabel("Título:"));
                bookPanel.add(titleField);
                bookPanel.add(new JLabel("Autor:"));
                bookPanel.add(authorField);
                bookPanel.add(new JLabel("Género:"));
                bookPanel.add(genreField);
                bookPanel.add(new JLabel("Año de Publicación:"));
                bookPanel.add(yearField);
                bookPanel.add(new JLabel("Copias Disponibles:"));
                bookPanel.add(copiesField);

                // Mostrar JOptionPane para ingresar datos del libro
                int result = JOptionPane.showConfirmDialog(null, bookPanel, "Ingrese los datos del libro", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        // Obtener los datos ingresados en los campos de texto
                        int id = Integer.parseInt(idField.getText());
                        String title = titleField.getText();
                        String author = authorField.getText();
                        String genre = genreField.getText();
                        int year = Integer.parseInt(yearField.getText());
                        int copies = Integer.parseInt(copiesField.getText());

                        // Crear un nuevo objeto ILibro con los datos ingresados
                        ILibroController libroController = (ILibroController) Naming.lookup("rmi://localhost/LibroController");
                        ILibro newBook =  libroController.newInstance();

                        // Llamar al método remoto para registrar el libro
                        newBook.setId(id);
                        newBook.setTitulo(title);
                        newBook.setAutor(author);
                        newBook.setGenero(genre);
                        newBook.setAnioPublicacion(String.valueOf(year));
                        newBook.setCopiasDisponibles(String.valueOf(copies));
                        libroController.add(newBook);

                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Libro registrado correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        // Manejar excepción si ocurre un error al convertir los números
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para ID, año y copias.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (RemoteException ex) {
                        // Manejar excepción de RMI
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al comunicarse con el servidor RMI", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    } catch (NotBoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        // Botón para consultar inventario
        JButton inventoryButton = new JButton("Consultar Inventario");
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para abrir una nueva pantalla para consultar el inventario
                // Por ahora, simplemente mostramos un mensaje
                JOptionPane.showMessageDialog(null, "Funcionalidad de consulta de inventario aún no implementada.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Botón para gestión de usuario
        JButton userManagerButton = new JButton("Gestión de Usuario");
        userManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para abrir una nueva pantalla para gestionar usuarios
                // Por ahora, simplemente mostramos un mensaje
                JOptionPane.showMessageDialog(null, "Funcionalidad de gestión de usuario aún no implementada.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        });

        panel.add(new JLabel());
        panel.add(addButton);
        panel.add(new JLabel());
        panel.add(inventoryButton);
        panel.add(new JLabel());
        panel.add(userManagerButton);

        add(panel);
        setVisible(true);
    }
}