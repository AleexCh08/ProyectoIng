package Modelo;

public class Trabajo {
    private String nivel;
    private String titulo;
    private String fechaDefensa;
    private String fechaInscripcion;
    private String tutor;
    private String cotutor;
    private String autor;
    private String coautor;
    
    public Trabajo(String nivel, String titulo, String fechaDefensa, String fechaInscripcion, String tutor, String cotutor, String autor, String coautor){
        this.nivel = nivel;
        this.titulo = titulo;
        this.fechaDefensa = fechaDefensa;
        this.fechaInscripcion = fechaInscripcion;
        this.tutor = tutor;
        this.cotutor = cotutor;
        this.autor = autor;
        this.coautor = coautor;
    }
}
