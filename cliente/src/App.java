
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import las_interfaces.ILibro;
import las_interfaces.ILibroController;
import las_interfaces.IUsuarioController;

public class App {
    public static void main(String[] args)  {
       try {
        IUsuarioController usuarioController = 
           (IUsuarioController) Naming.lookup("rmi://localhost/UsuarioController");
            ILibroController libroController =  (ILibroController)  Naming.lookup("rmi://localhost/LibroController");
           ILibro libro = libroController.newInstance();
            libro.setTitulo("100 años de soledad");
            libro.setAutor("Gabriel Garcia Marquez");
            libro.setGenero("realismo magico");
            libro.setAnioPublicacion("1967");
            libro.setCopiasDisponibles("100");

            int respuesta = libroController.add(libro);
            if(respuesta == ILibroController.ADD_EXITO){
                System.out.println("se agrego un libro con exito");
            }else{
                System.out.println("no sirvio");
            }
          
          

     
            

    } catch (MalformedURLException | RemoteException | NotBoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
