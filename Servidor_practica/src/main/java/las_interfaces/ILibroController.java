/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package las_interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author gerli
 */
public interface ILibroController extends Remote {
    ILibro newInstance() throws RemoteException;

    int add(ILibro libro) throws RemoteException;

    int update (ILibro libro) throws RemoteException;

    int delete(ILibro libro) throws RemoteException;

    int delete(int id) throws RemoteException;

    List<ILibro> list() throws RemoteException;

    ILibro findOne(int id) throws RemoteException;

    List <ILibro> find(ILibro libro) throws RemoteException;
    
    void cerrarConexion() throws RemoteException;

    int ADD_EXITO = 1;
    int ADD_ID_DUPLICADO = 2;
    int ADD_SIN_EXITO = 3;

    int UPADATE_EXITO = 1;
    int UPDATE_INEXISTE = 2;
    int UPDATE_ID_NULO = 3;
    int UPDATE_SIN_EXITO = 4;

    int DELETE_EXITO = 1;
    int DELETE_ID_INEXISTENTE = 2;
    int DELETE_ID_NULO = 3;
    int DELETE_SIN_EXITO = 4;

}

