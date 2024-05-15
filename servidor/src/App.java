
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import las_interfaces.ILibroController;
import las_interfaces.IUsuarioController;


public class App {
    public static void main(String[] args)  {
        try {
            LocateRegistry.createRegistry(1099);
            
            IUsuarioController usuarioController = new UsuarioController();
            Naming.rebind("rmi://localhost/UsuarioController", usuarioController);

            ILibroController libroController = new LibroController();
            Naming.rebind("rmi://localhost/LibroController", libroController);


            System.out.println("En espera de una solicitud...");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
