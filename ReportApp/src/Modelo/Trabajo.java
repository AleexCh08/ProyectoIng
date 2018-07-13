package Modelo;

public class Trabajo {
    private String nivel;
    private String titulo;
    private String ci;
    private String apellido1;
    private String nombre1;
    private String ci_2;
    private String apellido2;
    private String nombre2;
    private String sem1erainsc;
    private String fechaDefensa;
    private String ci_t;
    private String apellido_t1;
    private String nombre_t1;
    private String ci_t2;
    private String apellido_t2;
    private String nombre_t2;
    
    public Trabajo(String nivel, String titulo, String ci, String apellido1, String nombre1, String ci_2, String apellido2, String nombre2, String sem1erainsc, String fechaDefensa, String ci_t, String apellido_t1, String nombre_t1, String ci_t2, String apellido_t2, String nombre_t2 ){
        this.nivel = nivel;
        this.titulo = titulo;
        this.ci = ci;
        this.apellido1 = apellido1;
        this.nombre1 = nombre1;
        this.ci_2 = ci_2;
        this.apellido2 = apellido2;
        this.nombre2 = nombre2;
        this.sem1erainsc = sem1erainsc;
        this.fechaDefensa = fechaDefensa;
        this.ci_t = ci_t;
        this.apellido_t1 = apellido_t1;
        this.nombre_t1 = nombre_t1;
        this.ci_t2 = ci_t2;
        this.apellido_t2 = apellido_t2;
        this.nombre_t2 = nombre_t2;
    }
    
    public String getNivel(){
        return nivel;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getCi(){
        return ci;
    }
    
    public String getApellido1(){
        return apellido1;
    }
    
    public String getNombre1(){
        return nombre1;
    }
    
    public String getCi_2(){
        return ci_2;
    }
    
    public String getApellido2(){
        return apellido2;
    }
    
    public String getNombre2(){
        return nombre2;
    }
    
    public String getSem1erainsc(){
        return sem1erainsc;
    }
    
    public String getFechaDefensa(){
        return fechaDefensa;
    }
    
    public String getCi_t(){
        return ci_t;
    }
    
    public String getApellido_t1(){
        return apellido_t1;
    }
    
    public String getNombre_t1(){
        return nombre_t1;
    }
    
    public String getCi_t2(){
        return ci_t2;
    }
    
    public String getApellido_t2(){
        return apellido_t2;
    }
    
    public String getNombre_t2(){
        return nombre_t2;
    }       
}
