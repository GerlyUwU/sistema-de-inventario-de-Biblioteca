
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;

public class UsuarioController extends UnicastRemoteObject implements IUsuarioController {

    private DBManager dbManager;
    private final String TABLE = "Usuarios";

    public UsuarioController() throws RemoteException {
        dbManager = new DBManager();
    }

    @Override
    public IUsuario newInstance() throws RemoteException {
        // TODO Auto-generated method stub
        return new Usuario();
    }

    @Override
    public int add(IUsuario usuario) throws RemoteException {
        boolean existe = false;
        if (usuario.getId() != 0) {
            Map<String, Object> where = new HashMap<>();
            where.put("id", usuario.getId());
            Map<String, Object> registro = dbManager.buscarUno(TABLE, where);
            existe = registro.size() > 0;

        }

        if (existe) {
            return ADD_ID_DUPLICADO;
        }

        Map<String, Object> datos = new HashMap<>();
        if (usuario.getId() != 0) {
            datos.put("id", usuario.getId());
        }
        if (usuario.getNombre() != null) {
            datos.put("nombre", usuario.getNombre());
        }
        if (usuario.getDireccion() != null) {
            datos.put("direccion", usuario.getDireccion());
        }
        if (usuario.getTelefono() != null) {
            datos.put("telefono", usuario.getTelefono());
        }
        if (usuario.getNumeroIdentificacion() != null) {
            datos.put("numero_identificacion", usuario.getNumeroIdentificacion());
        }
        int respuesta = dbManager.insertar(TABLE, datos);

        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;

    }

    /**************************
     * fin del metodo add
     ***************************************************/

    @Override
    public int update(IUsuario usuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(IUsuario usuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete(int idUsuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<IUsuario> list() throws RemoteException {
        // TODO Auto-generated method stub
        List<IUsuario> listaIUsuario = new ArrayList<>();

        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            IUsuario usuario = Usuario.fromMap(registro);
            listaIUsuario.add(usuario);

        }

        return listaIUsuario;
    }

    @Override
    public IUsuario findOne(int idUsuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<IUsuario> find(IUsuario usuario) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

}
