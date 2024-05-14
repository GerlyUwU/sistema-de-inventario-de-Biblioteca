
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import las_interfaces.IUsuario;

public class Usuario extends UnicastRemoteObject implements IUsuario {

    private int id; 
    private String nombre; 
    private String direccion; 
    private String telefono; 
    private String numeroIdentificacion;


    public Usuario() throws RemoteException {

    }


    public Usuario(int id, String nombre, String direccion, String telefono, String numeroIdentificacion) throws RemoteException{
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    




}
