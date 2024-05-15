
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import las_interfaces.ILibro;



public class Libro  extends UnicastRemoteObject implements  ILibro{

    private int id;
    private String titulo; 
    private String autor; 
    private String genero; 
    private String anioPublicacion; 
    private String copiasDisponibles;

public Libro( )throws RemoteException{

}

    public Libro(String anioPublicacion, String autor, String copiasDisponibles, String genero, int id, String titulo) throws RemoteException {
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.copiasDisponibles = copiasDisponibles;
        this.genero = genero;
        this.id = id;
        this.titulo = titulo;
    }




    
    public int getId() throws RemoteException{
    return id;
}



public void setId(int id) throws RemoteException{
    this.id = id;
}



public String getTitulo() throws RemoteException{
    return titulo;
}



public void setTitulo(String titulo)throws RemoteException {
    this.titulo = titulo;
}



public String getAutor() throws RemoteException{
    return autor;
}



public void setAutor(String autor)throws RemoteException {
    this.autor = autor;
}



public String getGenero()throws RemoteException {
    return genero;
}



public void setGenero(String genero) throws RemoteException{
    this.genero = genero;
}



public String getAnioPublicacion() throws RemoteException{
    return anioPublicacion;
}



public void setAnioPublicacion(String anioPublicacion) throws RemoteException{
    this.anioPublicacion = anioPublicacion;
}



public String getCopiasDisponibles()throws RemoteException {
    return copiasDisponibles;
}



public void setCopiasDisponibles(String copiasDisponibles) throws RemoteException{
    this.copiasDisponibles = copiasDisponibles;
}



    @Override
    public String getString() throws RemoteException {
        return String.format("Id: %d, titulo %s, autor: %s, genero: %s, anioPublicacion: %s,copiasDisponibles: %s",
        id, titulo,autor, genero, anioPublicacion,copiasDisponibles);
    }
    
}
