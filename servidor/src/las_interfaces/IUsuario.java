package las_interfaces;

import java.rmi.*;

public interface IUsuario extends Remote {
    int getId() throws RemoteException;

    void setId(int id) throws RemoteException;

    String getNombre() throws RemoteException;

    void setNombre(String nombre) throws RemoteException;

    String getDireccion() throws RemoteException;

    void setDireccion(String direccion) throws RemoteException;

    String getTelefono() throws RemoteException;

    void setTelefono(String telefono) throws RemoteException;

    String getNmeroIdentificacion() throws RemoteException;

    void setNumeroIdentificacion(String NumeroIdentificacion) throws RemoteException;

    String getString() throws RemoteException;
}