package Modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Inventario {
    private HashMap<String, Producto> Productos; 
    
    public Inventario() {
        Productos = new HashMap<String, Producto>(); 
    }
    
    public void agregar(Producto p) {
        String codigo = p.getCodigo(); 
        Productos.put(codigo, p); 
    }
    
    public boolean existe(String codigo) {
        return Productos.containsKey(codigo); 
    }
    
    public void eliminar(String codigo) {
        Productos.remove(codigo); 
    }
    
    public void imprimir() {
        for(Producto p : Productos.values()){
            System.out.println(p.toString());
        }
    }
    
    public Collection<Producto> getTodo() {
        return Productos.values();
    }
    
    public Producto buscar(String codigo) {
        return Productos.get(codigo); 
    }
    
    public void modificar(String codigo, Producto p) {
        Productos.replace(codigo, p);
    }
}
