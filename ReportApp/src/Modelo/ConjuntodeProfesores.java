package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConjuntodeProfesores {
    private List<Profesor> profesor;
    
    public ConjuntodeProfesores(){
        profesor = new ArrayList<>();
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
                    auxCedula = aux[0];
                    auxApellido = aux[1];
                    auxNombre = aux[2];
                    auxCentro = aux[3];
                    agregarProfesor(auxCedula, auxApellido, auxNombre, auxCentro);                  
                }
            }
            profsBR.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(ConjuntodeProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
