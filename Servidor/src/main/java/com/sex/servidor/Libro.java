/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sex.servidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import las_interfaces.ILibro;
/**
 *
 * @author gerli gabo y habibi
 */
public class Libro  extends UnicastRemoteObject implements  ILibro{

    private int id;
    private String titulo; 
    private String autor; 
    private String genero; 
    private int  anioPublicacion; 
    private int copiasDisponibles;

public Libro( )throws RemoteException{

}

    public Libro(int anioPublicacion, String autor, int copiasDisponibles, String genero, int id, String titulo) throws RemoteException {
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.copiasDisponibles = copiasDisponibles;
        this.genero = genero;
        this.id = id;
        this.titulo = titulo;
    }

    public int getId()throws RemoteException {
        return id;
    }

    public void setId(int id) throws RemoteException{
        this.id = id;
    }

    public String getTitulo()throws RemoteException {
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

    public int getAnioPublicacion() throws RemoteException{
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) throws RemoteException{
        this.anioPublicacion = anioPublicacion;
    }

    public int getCopiasDisponibles() throws RemoteException{
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles)throws RemoteException {
        this.copiasDisponibles = copiasDisponibles;
    }

    







    @Override
    public String getString() throws RemoteException {
        return String.format("Id: %d, titulo %s, autor: %s, genero: %s, anioPublicacion: %s,copiasDisponibles: %s",
        id, titulo,autor, genero, anioPublicacion,copiasDisponibles);
    }

    public static ILibro fromMap(Map<String, Object> map) throws RemoteException {
        ILibro libro = new Libro();
        if (map.containsKey("id")) {
            libro.setId((Integer) map.get("id"));
        }

        if (map.containsKey("titulo")) {
            libro.setTitulo((String) map.get("titulo"));
        }

        if (map.containsKey("autor")) {
            libro.setAutor((String) map.get("autor"));
        }

        if (map.containsKey("genero")) {
            libro.setGenero((String) map.get("genero"));
        }

        if (map.containsKey("anio_publicacion")) {
            libro.setAnioPublicacion((Integer) map.get("anio_publicacion"));
        }

       if (map.containsKey("copias_disponibles")) {
            libro.setCopiasDisponibles((Integer) map.get("copias_disponibles"));
        }

        return libro;
    }

    public static Map<String, Object> toMap (ILibro libro) throws  RemoteException{
        Map<String, Object> datos = new HashMap<>();
        if (libro.getId() != 0) {
            datos.put("id", libro.getId());
        }
        if (libro.getTitulo() != null) {
            datos.put("titulo", libro.getTitulo());
        }
        if (libro.getAutor() != null) {
            datos.put("autor", libro.getAutor());
        }
        if (libro.getGenero() != null) {
            datos.put("genero", libro.getGenero());
        }
        if (libro.getAnioPublicacion() != 0) {
            datos.put("anio_publicacion", libro.getAnioPublicacion());
        }

        if (libro.getCopiasDisponibles() != 0) {
            datos.put("copias_disponibles", libro.getCopiasDisponibles());
        }

        return datos;
    }

    
    
}
