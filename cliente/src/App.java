
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import las_interfaces.ILibro;
import las_interfaces.ILibroController;
import las_interfaces.IUsuarioController;

public class App {
    public static void main(String[] args) {
        try {
            IUsuarioController usuarioController = (IUsuarioController) Naming
                    .lookup("rmi://localhost/UsuarioController");
            ILibroController libroController = (ILibroController) Naming.lookup("rmi://localhost/LibroController");
            ILibro libro = libroController.newInstance();
            libro.setTitulo("Fundamentos de Bases de Datos");
            libro.setAutor("Abraham Silberschatz, Henry Korth, S. Sudarshan");
            libro.setGenero("Ciencia de la Computación");
            libro.setAnioPublicacion("2014");
            libro.setCopiasDisponibles("50");

            int respuesta = libroController.add(libro);
            if (respuesta == ILibroController.ADD_EXITO) {
                System.out.println("se agrego un libro con exito");
            } else {
                System.out.println("no sirvio");
            }

        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
