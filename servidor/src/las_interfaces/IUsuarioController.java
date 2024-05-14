package las_interfaces;

import java.rmi.*;

public interface IUsuarioController extends Remote {
    IUsuario newInstance() throws RemoteException;
    int add (IUsuario usuario)throws RemoteException;
    int delete(IUsuario usuario)throws RemoteException;
    IUsuario findOne(int idUsuario)throws RemoteException;

    int ADD_EXITO = 1;
    int ADD_ID_DUPLICADO = 2;
    int UPDATE_EXITO = 1;
    int UPDATE_INEXISTENTE = 2;
}
