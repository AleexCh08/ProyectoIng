package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto {
    private String Codigo; 
    private String Fecha; 
    private String Nombre; 
    private Double Precio; 
    private String Descripcion; 

    public Producto(String Codigo, String Nombre, Double Precio, String Descripcion) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Descripcion = Descripcion;
        DateFormat fechaAux = new SimpleDateFormat("dd/MM/yyyy"); 
        Date fecha = new Date(); 
        this.Fecha = fechaAux.format(fecha); 
    }
    
    public String toString() {
        String producto = "Producto " + Codigo + " {\n"; 
        producto += "   Nombre:      " + Nombre + "\n"; 
        producto += "   Fecha:       " + Fecha + "\n";
        producto += "   Precio:      " + Precio.toString() + "\n";
        producto += "   Descripcion: " + Descripcion + "\n";
        producto += "}\n";
        
        return producto; 
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
