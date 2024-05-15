
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import las_interfaces.ILibro;
import las_interfaces.ILibroController;

public class LibroController extends UnicastRemoteObject implements ILibroController {

    private final DBManager dbManager;
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
        ILibro libroEncontrado = findOne(libro.getId());
        boolean existe = libroEncontrado.getId() != 0;
        if(existe){
            return ADD_ID_DUPLICADO;
        }
        Map<String, Object> datos = Libro.toMap(libro);

        int respuesta = dbManager.insertar(TABLE, datos);
        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;  
    }//fin del metodo 

    @Override
    public int update(ILibro libro) throws RemoteException {
        // TODO Auto-generated method stub
        if(libro.getId() == 0 ){
            return UPDATE_ID_NULO;
        }
        //verficar que existe persona con id recibido 
        ILibro libroEncontrado = findOne(libro.getId());
        if(libroEncontrado.getId() == 0){
            return UPDATE_INEXISTE;
        }
        Map<String, Object> datos = Libro.toMap(libro);
        Map<String, Object> where = new HashMap<>();
        where.put("id", libro.getId());
        int respuesta = dbManager.actualizar(TABLE, datos, where);
        return (respuesta > 0) ? UPADATE_EXITO : UPDATE_SIN_EXITO;
    }//fin del metodo update 

    @Override
    public int delete(ILibro libro) throws RemoteException {
        ILibro libroTemp = findOne(libro.getId());
        if(libroTemp.getId() == 0){
            return DELETE_ID_INEXISTENTE;
        }
        Map<String, Object> where = new HashMap<>();
        where.put("id",libro.getId());
        int respuesta = dbManager.eliminar(TABLE,where);
        if(respuesta == 0){
            return DELETE_SIN_EXITO;
        }else{
           return DELETE_EXITO;
        }
        
    }

    @Override
    public int delete(int id) throws RemoteException {
        ILibro libroTemp = findOne(id);
        if (libroTemp.getId() == 0) {
            return DELETE_ID_INEXISTENTE;
        }

        Map<String, Object> where = new HashMap<>();
        where.put("id", id);
        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    @Override
    public List<ILibro> list() throws RemoteException {
        List<ILibro> listaILibro = new ArrayList<>();
        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            ILibro libro = Libro.fromMap(registro);

            listaILibro.add(libro);
        }

        return listaILibro;

    }

    @Override
    public ILibro findOne(int id) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("id", id);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Libro.fromMap(registro);
    }

    @Override
    public List<ILibro> find(ILibro libro) throws RemoteException {
        List<ILibro> listaILibro = new ArrayList<>();

        Map<String, Object> where = Libro.toMap(libro);
        List<Map<String, Object>> registros = dbManager.listar(TABLE, null);

        for (Map<String, Object> registro : registros) {
            ILibro libroTemp = Libro.fromMap(registro);

            listaILibro.add(libroTemp);
        }

        return listaILibro;
    }

}// fin de la clase libro controller
