package Modelo;

public class Profesor {
    private String nombre;
    private String apellido;
    private String cedula;
    private String centro;
    
    public Profesor(String cedula, String apellido, String nombre, String centro){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.centro = centro;
    }    
}
