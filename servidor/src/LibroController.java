
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import las_interfaces.ILibro;
import las_interfaces.ILibroController;

public class LibroController extends UnicastRemoteObject implements ILibroController {

    private DBManager dbManager;
    private final String TABLE = "Libros";

    public LibroController() throws RemoteException {
        dbManager = new DBManager();
    }

    @Override
    public ILibro newInstance() throws RemoteException {
        // TODO Auto-generated method stub
        return new Libro();
    }

    @Override
    public int add(ILibro libro) throws RemoteException {
        boolean existe = false;
        if (libro.getId() != 0) {
            Map<String, Object> where = new HashMap<>();
            where.put("id", libro.getId());
            Map<String, Object> registro = dbManager.buscarUno(TABLE, where);
            existe = registro.size() > 0;

        }
        if (existe) {
            Map<String, Object> datos = new HashMap<>();
            if (libro.getId() != 0) {
                datos.put("id", libro.getId());
            }

            if (libro.getTitulo() != null) {
                datos.put("id", libro.getTitulo());
            }

            if (libro.getAutor() != null) {
                datos.put("autor", libro.getAutor());
            }
            if (libro.getGenero() != null) {
                datos.put("genero", libro.getGenero());
            }
            if (libro.getAnioPublicacion() != null) {
                datos.put("anio_publicacion", libro.getAnioPublicacion());
            }
            if (libro.getCopiasDisponibles() != null) {
                datos.put("copias_disponibles", libro.getCopiasDisponibles());
            }

            int respuesta = dbManager.insertar(TABLE, datos);

            return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;
        }

        return 0;
    }

    @Override
    public int update(ILibro libro) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(ILibro libro) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete(int id) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ILibro> list() throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public ILibro findOne(int id) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<ILibro> find(ILibro libro) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

}