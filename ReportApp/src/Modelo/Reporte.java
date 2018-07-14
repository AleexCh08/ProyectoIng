package Modelo;

import Controlador.Ctrl_Trabajos;
import java.time.LocalDate;
import java.time.Month;

public class Reporte {
    public LocalDate i;
    public LocalDate f;
    private Ctrl_Trabajos ctrl_trabajos;
    private ConjuntodeProfesores conjuntodeprofesores;
    private ConjuntodeTrabajos conjuntodetrabajos;
    
    public Reporte (Ctrl_Trabajos ctrl_trabajos, ConjuntodeProfesores conjuntodeprofesores, ConjuntodeTrabajos conjuntodetrabajos){
        this.f = LocalDate.of(2000, Month.MARCH, 10);
        this.i = LocalDate.of(1999, Month.MARCH, 10);
        this.ctrl_trabajos = ctrl_trabajos;
        this.conjuntodeprofesores = conjuntodeprofesores;
        this.conjuntodetrabajos = conjuntodetrabajos;
    }
    
    public void  esProfesor(String CI){
        String  cedulaProf,aux1,aux2,aux3,aux4;
        
        int tam= conjuntodeprofesores.getProfesor().size();
        for (int i=0; i<tam;i++){
            cedulaProf=conjuntodeprofesores.getProfesor().get(i).getCedula();
            if(CI.equals(cedulaProf)){               
                aux1=conjuntodeprofesores.getProfesor().get(i).getCedula();
                aux2=conjuntodeprofesores.getProfesor().get(i).getApellido();
                aux3=conjuntodeprofesores.getProfesor().get(i).getNombre();
                aux4=conjuntodeprofesores.getProfesor().get(i).getCentro();
                ctrl_trabajos.MostrarProfs(aux1,aux2,aux3,aux4);         
            }
        }   
    }
}

