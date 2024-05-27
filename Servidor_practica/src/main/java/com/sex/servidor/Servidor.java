package com.sex.servidor;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import las_interfaces.ILibroController;
import las_interfaces.IUsuarioController;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Obtener la dirección IP del servidor
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ipAddress);

            // Crear el registro RMI
            LocateRegistry.createRegistry(1099);

            // Crear instancias de los controladores
            IUsuarioController usuarioController = new UsuarioController();
            ILibroController libroController = new LibroController();

            // Enlazar los objetos remotos en el registro RMI utilizando la dirección IP del
            // servidor
            Naming.rebind("rmi://" + ipAddress + "/UsuarioController", usuarioController);
            Naming.rebind("rmi://" + ipAddress + "/LibroController", libroController);

            System.out.println("Servidor listo para recibir solicitudes...");
        } catch (RemoteException | UnknownHostException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
