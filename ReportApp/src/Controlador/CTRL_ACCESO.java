package Controlador;

public class CTRL_ACCESO {
    private static Ctrl_Trabajos ctrl_trabajos;
    
    public static void main(String[] args){
        ctrl_trabajos = Ctrl_Trabajos.getInstance();
        ctrl_trabajos.principal();  
    }
}

/*Proyecto de Ingeneria de Software II-2107 - ReportAPP
Equipo #3
Integrantes: Cabrera Kharleann - 25831122
             Churio Alexander - 23708325
             Jimenez Franco - 26552242
             Gerig Edgar - 25858414
*/