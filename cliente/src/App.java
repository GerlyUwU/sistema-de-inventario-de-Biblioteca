
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;

public class App {
    public static void main(String[] args)  {
       try {
        IUsuarioController usuarioController = 
           (IUsuarioController) Naming.lookup("rmi://localhost/UsuarioController");
        
       List<IUsuario> lista = usuarioController.list();
        for(IUsuario usuario : lista){
            System.out.println(usuario.getString());
        }


    } catch (MalformedURLException | RemoteException | NotBoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
