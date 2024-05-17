/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sex.servidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import las_interfaces.IUsuario;
import las_interfaces.IUsuarioController;
/**
 *
 * @author gerli gabo y habibi
 */
public class UsuarioController extends UnicastRemoteObject implements IUsuarioController {

    private DBManager dbManager;
    private final String TABLE = "Usuarios";

    public UsuarioController() throws RemoteException {
        dbManager = new DBManager();
    }

    @Override
    public IUsuario newInstance() throws RemoteException {
        // TODO Auto-generated method stub
        return new Usuario();
    }

    @Override
    public int add(IUsuario usuario) throws RemoteException {
        IUsuario usuarioEncontrado = findOne(usuario.getId());
        boolean existe = usuarioEncontrado.getId() != 0;
        if(existe){
            return  ADD_ID_DUPLICADO;
        }
        Map<String, Object> datos = Usuario.toMap(usuario);
          int respuesta = dbManager.insertar(TABLE, datos);
        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;  
    }

    /**************************
     * fin del metodo add
     ***************************************************/

    @Override
    public int update(IUsuario usuario) throws RemoteException {
        // TODO Auto-generated method stub
        if(usuario.getId() == 0){
            return UPDATE_ID_NULO;
        }
        //verficar que existe usuario con id recibido 
        IUsuario usuarioEncontrado = findOne(usuario.getId());
        if(usuarioEncontrado.getId() == 0){
            return  UPDATE_INEXISTE;
        }
        
         Map<String, Object> datos = Usuario.toMap(usuario);
        Map<String, Object> where = new HashMap<>();
        where.put("id", usuario.getId());
        
        int respuesta = dbManager.actualizar(TABLE, datos, where);
        return (respuesta > 0) ? UPADATE_EXITO : UPDATE_SIN_EXITO;
    }

    @Override
    public int delete(IUsuario usuario) throws RemoteException {
        // TODO Auto-generated method stub
        IUsuario usuarioTemp = findOne(usuario.getId());
        
         if(usuarioTemp.getId() == 0){
           return DELETE_ID_INEXISTENTE;
       }
       Map<String, Object> where = new HashMap<>();
        where.put("id", usuario.getId());
        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    @Override
    public int delete(int id) throws RemoteException {
       IUsuario usuarioTemp = findOne(id);
       if(usuarioTemp.getId() == 0){
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
    public List<IUsuario> list() throws RemoteException {
        // TODO Auto-generated method stub
        List<IUsuario> listaIUsuario = new ArrayList<>();

        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            IUsuario usuario = Usuario.fromMap(registro);
            listaIUsuario.add(usuario);

        }

        return listaIUsuario;
    }

    @Override
    public IUsuario findOne(int id) throws RemoteException {
     Map<String, Object> where = new HashMap<>();
        where.put("id", id);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Usuario.fromMap(registro); 
    }

    @Override
    public List<IUsuario> find(IUsuario usuario) throws RemoteException {
        List <IUsuario> listaIUsuario = new ArrayList<>();
        List<Map<String, Object>> registros = dbManager.listar(TABLE, null);
        for (Map<String, Object> registro : registros) {
            IUsuario usuarioTemp = Usuario.fromMap(registro);
            listaIUsuario.add(usuarioTemp);
        }
        
        return listaIUsuario;
    }
    
    public  void cerrarConexion() throws RemoteException{
        dbManager.cerrarConexion();
    }

}

