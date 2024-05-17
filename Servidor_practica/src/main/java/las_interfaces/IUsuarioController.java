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
public interface IUsuarioController extends Remote {
    
    IUsuario newInstance() throws RemoteException;

    int add(IUsuario usuario) throws RemoteException;

    int update (IUsuario usuario) throws RemoteException;

    int delete(IUsuario usuario) throws RemoteException;

    int delete(int id) throws RemoteException;

    List<IUsuario> list() throws RemoteException;

    IUsuario findOne(int id) throws RemoteException;

    List <IUsuario> find(IUsuario usuario) throws RemoteException;

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
