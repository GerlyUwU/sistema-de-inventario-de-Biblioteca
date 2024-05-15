
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import las_interfaces.IUsuario;

public class Usuario extends UnicastRemoteObject implements IUsuario {

    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String numeroIdentificacion;

    public Usuario() throws RemoteException {

    }

    public Usuario(int id, String nombre, String direccion, String telefono, String numeroIdentificacion)
            throws RemoteException {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getId() throws RemoteException {
        return id;
    }

    public void setId(int id) throws RemoteException {
        this.id = id;
    }

    public String getNombre() throws RemoteException {
        return nombre;
    }

    public void setNombre(String nombre) throws RemoteException {
        this.nombre = nombre;
    }

    public String getDireccion() throws RemoteException {
        return direccion;
    }

    public void setDireccion(String direccion) throws RemoteException {
        this.direccion = direccion;
    }

    public String getTelefono() throws RemoteException {
        return telefono;
    }

    public void setTelefono(String telefono) throws RemoteException {
        this.telefono = telefono;
    }

    public String getNumeroIdentificacion() throws RemoteException {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) throws RemoteException {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getString() throws RemoteException {
        return String.format("Id: %d, Nombre: %s, Email: %s, Telefono: %s, Numero de Identificacion: %s",
                id, nombre, direccion, telefono, numeroIdentificacion);
    }

    public static IUsuario fromMap(Map<String, Object> map) throws RemoteException {
        IUsuario usuario = new Usuario();
        if (map.containsKey("id")) {
            usuario.setId((Integer) map.get("id"));
        }

        if (map.containsKey("nombre")) {
            usuario.setNombre((String) map.get("nombre"));
        }

        if (map.containsKey("direccion")) {
            usuario.setDireccion((String) map.get("direccion"));
        }

        if (map.containsKey("telefono")) {
            usuario.setTelefono((String) map.get("telefono"));
        }

        if (map.containsKey("numero_identificacion")) {
            usuario.setNumeroIdentificacion((String) map.get("numero_identificacion"));
        }
        return usuario;
    }

}
