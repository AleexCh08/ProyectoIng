package Controlador;

public class CTRL_ACCESO {
    private static Ctrl_Trabajos ctrl_trabajos;
    
    public static void main(String[] args){
        ctrl_trabajos = Ctrl_Trabajos.getInstance();
        ctrl_trabajos.principal();    
    }
}