
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;

public class UsuarioController extends UnicastRemoteObject implements IUsuarioController{

    private DBManager dbManager;
    private final String TABLE = "Usuarios";

    public UsuarioController() throws RemoteException{
        dbManager = new DBManager();
    }

    @Override
    public IUsuario newInstance() throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newInstance'");
    }

    @Override
    public int add(IUsuario usuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int delete(IUsuario usuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public IUsuario findOne(int idUsuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }
    
}
