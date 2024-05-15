package las_interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILibro extends Remote {
    int getId() throws RemoteException;

    void setId(int id) throws RemoteException;

    String getTitulo() throws RemoteException;

    void setTitulo(String titulo) throws RemoteException;

    String getAutor() throws RemoteException;

    void setAutor(String autor) throws RemoteException;

    String getGenero() throws RemoteException;

    void setGenero(String genero) throws RemoteException;

    String getAnioPublicacion() throws RemoteException;

    void setAnioPublicacion(String anioPublicacion) throws  RemoteException;

    String getCopiasDisponibles() throws  RemoteException;

    void setCopiasDisponibles(String copiasDisponibles) throws RemoteException;

    String getString() throws RemoteException;
}
