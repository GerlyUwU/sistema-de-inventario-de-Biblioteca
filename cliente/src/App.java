
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;

public class App {
    public static void main(String[] args)  {
       try {
        IUsuarioController usuarioController = 
           (IUsuarioController) Naming.lookup("rmi://localhost/UsuarioController");

           IUsuario usuario = usuarioController.newInstance();
           usuario.setNombre("GABRIEL ANTONIO MORALES GARCIA");
           usuario.setDireccion("calle ixhuatlan #305 colonia centro");
           usuario.setTelefono("9123843829");
           usuario.setNumeroIdentificacion("s21111111");
           int respuesta = usuarioController.add(usuario);
            if(respuesta == IUsuarioController.ADD_EXITO){
                System.out.println("usuario agregado con exito");
            }else{
                System.out.println("algo salio mal :c");
            }



    } catch (MalformedURLException | RemoteException | NotBoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
