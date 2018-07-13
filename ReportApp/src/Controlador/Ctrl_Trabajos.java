package Controlador;

import Vista.*;
import Modelo.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Ctrl_Trabajos {
    private static Ctrl_Trabajos uniqueInstance = null;
    private IAcceso iAcceso;
    private ICargar iCargar;
    private IConsulta iConsulta;
    private IPrincipalCom iPrincipalCom;
    private IReportesCentro iReportesCentro;
    private IReportesProf iReportesProf;
    private IReportesTrabProf iReportesTrabProf;  
    private ConjuntodeProfesores conjuntoProfs;
    private ConjuntodeTrabajos conjuntoTrabj;
    private Reporte reporte;
    public boolean ord;
    
    private Ctrl_Trabajos(){
        iAcceso = new IAcceso(this);
        iCargar = new ICargar(this);
        iConsulta = new IConsulta(this);
        iPrincipalCom = new IPrincipalCom(this);
        iReportesCentro = new IReportesCentro(this);
        iReportesProf = new IReportesProf(this);
        iReportesTrabProf = new IReportesTrabProf(this);
        conjuntoProfs = new ConjuntodeProfesores();
        conjuntoTrabj = new ConjuntodeTrabajos();
        reporte = new Reporte();
    }
     
    public static Ctrl_Trabajos getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Ctrl_Trabajos();
        }
        return uniqueInstance;
    }
      
    public void ocultarTodo(){
        iAcceso.ocultar();
        iCargar.ocultar();
        iConsulta.ocultar();
        iPrincipalCom.ocultar();
        iReportesCentro.ocultar();
        iReportesProf.ocultar();
        iReportesTrabProf.ocultar();
    }

    public void principal() {
        ocultarTodo();
        iAcceso.setVisible(true);
    }
    
    public void comisionInvestigacion() {
        ocultarTodo();
        iPrincipalCom.setVisible(true);
    }

    public void consulta() {
        ocultarTodo();
        iConsulta.borrarTexto();
        iConsulta.setVisible(true);
    }
    
    public void cargar() {
        ocultarTodo();
        iCargar.setVisible(true);
    }
    
    public void reportesCentro() {
        ocultarTodo();
        iReportesCentro.setVisible(true);
    }
    
    public void reportesProf() {
        ocultarTodo();
        iReportesProf.setVisible(true);
    }
    
    public void reportesTrabProf() {
        ocultarTodo();
        iReportesTrabProf.setVisible(true);
    } 
    
    public void cargarProfesores() throws IOException{
        conjuntoProfs.cargarProfesor();
    }
    public void cargarTrabajos() throws IOException{
        conjuntoTrabj.cargarTrabajo();
    }
    
    public void montar(){        
        int size = conjuntoProfs.getProfesor().size();
        String[] p = new String[size];
        for (int i = 0; i < size; i++) {
            p[i] = conjuntoProfs.getProfesor().get(i).getNombre();
            p[i] = p[i] + " " + conjuntoProfs.getProfesor().get(i).getApellido();
        }       
        iConsulta.montarP(p);
    }
    
    public void buscarTrabajos(int indice, boolean selected){       
        String cedula = "";
        int size = 0;
        String aux = "";
        String aux1 = "";
        boolean flag = false;
        
        if(selected){
            cedula = conjuntoProfs.getProfesor().get(indice).getCedula();
            size = conjuntoTrabj.getTrabajos().size();
            for(int i = 0; i < size; i++) {            
                aux = conjuntoTrabj.getTrabajos().get(i).getCi_t();
                if(aux.equals(cedula)){  
                    flag = true;
                    aux1 = conjuntoTrabj.getTrabajos().get(i).getTitulo();
                    iConsulta.mostrar(aux1);
                }
            }
            if(flag == false){
                iConsulta.mensajeError();
            }    
        }else{
            cedula = conjuntoProfs.getProfesor().get(indice).getCedula();
            size = conjuntoTrabj.getTrabajos().size();
            for(int i = 0; i < size; i++) {
                aux = conjuntoTrabj.getTrabajos().get(i).getCi();
                if(aux.equals(cedula)){  
                    flag = true;
                    aux1 = conjuntoTrabj.getTrabajos().get(i).getTitulo();
                    iConsulta.mostrar(aux1);
                }
            }
            if(flag == false){
                iConsulta.mensajeError();
            }
        }      
    }
       
    public boolean fechaVal(String a, String b) {
        String dateFormat = "dd/MM/uuuu";
        String dateStringa = a;
        String dateStringb = b;
        boolean n;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern(dateFormat)
            .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate datea = LocalDate.parse(dateStringa, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            // Retornar False
            return n=false;
        }
        LocalDate datea = LocalDate.parse(dateStringa, dateTimeFormatter);
        try {
            LocalDate dateb = LocalDate.parse(dateStringb, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            // Retornar False
            return n=false;
        }
        LocalDate dateb = LocalDate.parse(dateStringb, dateTimeFormatter);
        if ((datea.isAfter(dateb)) || (datea.isBefore(LocalDate.parse("2014-01-01"))) ||
                (dateb.isAfter(LocalDate.parse("2018-12-31")))) {
            return n=false;
        }
    return n=true;
    }
    
    public boolean fechaDentro(LocalDate a, LocalDate b, LocalDate c){
        boolean n;
        if (c.isAfter(a) && c.isBefore(b)) {
            return n=true;
    }else{
            return n=false;
        }
    }
    
    public void reportarTrabajosporProf(){
        
    }
}
