/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package las_interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gerli
 */

public interface ILibro extends Remote {
    int getId() throws RemoteException;

    void setId(int id) throws RemoteException;

    String getTitulo() throws RemoteException;

    void setTitulo(String titulo) throws RemoteException;

    String getAutor() throws RemoteException;

    void setAutor(String autor) throws RemoteException;

    String getGenero() throws RemoteException;

    void setGenero(String genero) throws RemoteException;

    int getAnioPublicacion() throws RemoteException;

    void setAnioPublicacion(int anioPublicacion) throws  RemoteException;

    int  getCopiasDisponibles() throws  RemoteException;

    void setCopiasDisponibles(int copiasDisponibles) throws RemoteException;

    String getString() throws RemoteException;
}