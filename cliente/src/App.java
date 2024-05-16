
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import las_interfaces.ILibro;
import las_interfaces.ILibroController;

public class App {
    public static void main(String[] args) {
        try {
            ILibroController libroController = (ILibroController) Naming.lookup("rmi://localhost/LibroController");
            ILibro libro = libroController.newInstance();
           

        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
