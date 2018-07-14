package Modelo;

import Controlador.Ctrl_Trabajos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConjuntodeProfesores {
    private List<Profesor> profesor;
    private Ctrl_Trabajos ctrl_trabajos;
    
    public ConjuntodeProfesores(Ctrl_Trabajos ctrl_trabajos){
        profesor = new ArrayList<>();
        this.ctrl_trabajos = ctrl_trabajos;
    }
    
    public List<Profesor> getProfesor(){
        return profesor;
    }
    
    public void agregarProfesor(String cedula, String apellido, String nombre, String centro){        
        profesor.add(new Profesor(cedula, apellido, nombre, centro));
    }
    
    public void cargarProfesor() throws IOException{
        String auxProfs = "";
        String[] aux = null;
        String auxCedula = "";
        String auxApellido = "";
        String auxNombre = "";
        String auxCentro = "";

        File profs = new File("src/Data/profs_Centros.txt");
        
         
        try {
            FileReader profsFR = new FileReader(profs);
            BufferedReader profsBR = new BufferedReader(profsFR);
            while((auxProfs = profsBR.readLine()) != null){
                if(auxProfs.endsWith("EOF")){

                }else{
                    auxProfs = auxProfs.replace(";", "");
                    aux = auxProfs.split("#");
                    if (aux.length<4){
                        System.out.println("Archivo con campos incorrectos");
                        profesor.removeAll(profesor);
                        break;
                    }else{
                    auxCedula = aux[0];
                    auxApellido = aux[1];
                    auxNombre = aux[2];
                    auxCentro = aux[3];
                    agregarProfesor(auxCedula, auxApellido, auxNombre, auxCentro); 
                    }                 
                }
            }
            profsBR.close();
            ctrl_trabajos.prof=true;
        } catch (FileNotFoundException ex){
            Logger.getLogger(ConjuntodeProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
}
