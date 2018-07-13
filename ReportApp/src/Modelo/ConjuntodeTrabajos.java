package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConjuntodeTrabajos {
    private List<Trabajo> trabajo;
    
    public ConjuntodeTrabajos(){
        trabajo = new ArrayList<>();
    }
    
    public void agregarTrabajo(String nivel, String titulo, String ci, String apellido1, String nombre1, String ci_2, String apellido2, String nombre2, String sem1erainsc, String fechaDefensa, String ci_t, String apellido_t1, String nombre_t1, String ci_t2, String apellido_t2, String nombre_t2 ){      
       trabajo.add(new Trabajo(nivel, titulo, ci, apellido1, nombre1, ci_2, apellido2, nombre2, sem1erainsc, fechaDefensa, ci_t, apellido_t1, nombre_t1, ci_t2, apellido_t2, nombre_t2 ));
    }
    
    public void cargarTrabajo() throws IOException{
        String auxTrabajos = "";
        String[] aux = null;
        String agr = "";
        String auxnivel= "";
        String auxtitulo = "";
        String auxci = "";
        String auxapellido1 = "";
        String auxnombre1 = "";
        String auxci_2 = "";
        String auxapellido2 = "";
        String auxnombre2 = "";
        String auxsem1erainsc = "";
        String auxfechaDefensa = "";
        String auxci_t = "";
        String auxapellido_t1 = "";
        String auxnombre_t1 = "";
        String auxci_t2 = "";
        String auxapellido_t2 = "";
        String auxnombre_t2 = "";
        
        File trabajos = new File("src/Data/trabajos.txt");
        
        try {
            FileReader trabajosFR = new FileReader(trabajos);
            BufferedReader trabajosBR = new BufferedReader(trabajosFR);
            while((auxTrabajos = trabajosBR.readLine()) != null){
                if(auxTrabajos.endsWith("EOF")){

                }else{
                    aux = auxTrabajos.split("#");                     
                    if(aux[0].equals("TEG")){                                        
                        auxnivel = aux[0];
                        auxtitulo = aux[1];
                        auxci = aux[2];
                        auxapellido1 = aux[3];
                        auxnombre1 = aux[4];
                        auxci_2 = aux[5];
                        auxapellido2 = aux[6];
                        auxnombre2 = aux[7];
                        auxsem1erainsc = aux[8];
                        auxfechaDefensa = aux[9];
                        auxci_t = aux[10];
                        auxapellido_t1 = aux[11];
                        auxnombre_t1 = aux[12];
                        auxci_t2 = aux[13];
                        auxapellido_t2 = aux[14];
                        agr = aux[15].replace(";", "");
                        auxnombre_t2 = agr;
                        agregarTrabajo(auxnivel, auxtitulo, auxci, auxapellido1, auxnombre1, auxci_2, auxapellido2, auxnombre2, auxsem1erainsc, auxfechaDefensa, auxci_t, auxapellido_t1, auxnombre_t1, auxci_t2, auxapellido_t2, auxnombre_t2);
                    }else{
                        auxnivel = aux[0];
                        auxtitulo = aux[1];
                        auxci = aux[2];
                        auxapellido1 = aux[3];
                        auxapellido2 = aux[4];
                        auxci_2 = auxapellido2 = auxnombre2 = "";
                        auxsem1erainsc = aux[5];
                        auxfechaDefensa = aux[6];
                        auxci_t = aux[7];
                        auxapellido_t1 = aux[8];
                        auxnombre_t1 = aux[9];
                        auxci_t2 = aux[10];
                        auxapellido_t2 = aux[11];
                        agr = aux[12].replace(";", "");
                        auxnombre_t2 = agr;
                        agregarTrabajo(auxnivel, auxtitulo, auxci, auxapellido1, auxnombre1, auxci_2, auxapellido2, auxnombre2, auxsem1erainsc, auxfechaDefensa, auxci_t, auxapellido_t1, auxnombre_t1, auxci_t2, auxapellido_t2, auxnombre_t2);
                    }               
                }
            }
            trabajosBR.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(ConjuntodeTrabajos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
