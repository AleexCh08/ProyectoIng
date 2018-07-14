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
    public boolean prof = false;
    public boolean trab = false;
    public boolean band = false;
    public boolean carga;
    
    private Ctrl_Trabajos(){
        iAcceso = new IAcceso(this);
        iCargar = new ICargar(this);
        iConsulta = new IConsulta(this);
        iPrincipalCom = new IPrincipalCom(this);
        iReportesCentro = new IReportesCentro(this);
        iReportesProf = new IReportesProf(this);
        iReportesTrabProf = new IReportesTrabProf(this);
        conjuntoProfs = new ConjuntodeProfesores(this);
        conjuntoTrabj = new ConjuntodeTrabajos(this);
        reporte = new Reporte(this,conjuntoProfs,conjuntoTrabj);
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
        if (trab && prof){
            iAcceso.habilitar();
            iAcceso.setVisible(true);
        }else{
            iAcceso.deshabilitar();
            iAcceso.setVisible(true);
        }
    }
    
    public void comisionInvestigacion() {
        ocultarTodo();
        if (trab && prof){
        iPrincipalCom.habilitar();
        iPrincipalCom.setVisible(true);
        }else{
            iPrincipalCom.deshabilitar();
            iPrincipalCom.setVisible(true);
        }
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
        iReportesProf.borrarTexto();
        iReportesProf.setVisible(true);
    }
    
    public void reportesTrabProf() {
        ocultarTodo();
        iReportesTrabProf.borrarTexto();
        iReportesTrabProf.setVisible(true);
    } 
    
    public void cargarProfesores() throws IOException{
        conjuntoProfs.cargarProfesor();
        if(conjuntoProfs.getProfesor().size()>0){
         iCargar.exito();
        } else {
            iCargar.noExito();
        }
    }
    public void cargarTrabajos() throws IOException{
        conjuntoTrabj.cargarTrabajo();
        if(conjuntoTrabj.getTrabajos().size()>0){
            iCargar.exito();
        }else {
            iCargar.noExito();
        }
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
    
    public void MostrarProfs(String s1, String s2, String s3, String s4){
        iReportesTrabProf.mostrar(s1);
        iReportesTrabProf.mostrar(s2);
        iReportesTrabProf.mostrar(s3);
        iReportesTrabProf.mostrar(s4);
        iReportesTrabProf.mostrar("\n");      
    }
    
    public void reportarProfPresentaron(){
        iReportesTrabProf.borrarTexto(); 
        String dateFormat = "dd/MM/uuuu";
        String a,b;
        LocalDate x = LocalDate.parse("2014-01-01");
        LocalDate y = LocalDate.parse("2018-12-31");
        a=iReportesTrabProf.getFechaInicial();
        b=iReportesTrabProf.getFechaFinal();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern(dateFormat)
            .withResolverStyle(ResolverStyle.STRICT);
         if (!(fechaVal(a,b))){
        
         }else{
             x = LocalDate.parse(a,dateTimeFormatter);
             y = LocalDate.parse(b,dateTimeFormatter);
         }
        int h= conjuntoTrabj.getTrabajos().size(); //numero de elementos en la lista
        String fecha;
        String level;
        String cedula;
            for(int i=0; i<h;i++){          
                level=conjuntoTrabj.getTrabajos().get(i).getNivel();
                fecha=conjuntoTrabj.getTrabajos().get(i).getFechaDefensa();
                LocalDate z = LocalDate.parse(fecha,dateTimeFormatter);
                if(("TGM".equals(level) || "TDR".equals(level)) && fechaDentro(x,y,z) ){ // si Nivel es TGM o Nivel es TDR
                     cedula=conjuntoTrabj.getTrabajos().get(i).getCi();
                    reporte.esProfesor(cedula);
                }
            }
    }
    
    public void reportarProf(){
        iReportesProf.borrarTexto();      
        String dateFormat = "dd/MM/uuuu";
        String a,b;
        LocalDate x = LocalDate.parse("2014-01-01");
        LocalDate y = LocalDate.parse("2018-12-31");
        a=iReportesProf.getFechaInicial();
        b=iReportesProf.getFechaFinal();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern(dateFormat)
            .withResolverStyle(ResolverStyle.STRICT);
         if (!(fechaVal(a,b))){
        
         }else{
             x = LocalDate.parse(a,dateTimeFormatter);
             y = LocalDate.parse(b,dateTimeFormatter);
         }
        int h= conjuntoProfs.getProfesor().size(); //numero de elementos en la lista
        int j= conjuntoTrabj.getTrabajos().size();
        String fecha;
        String tutor;
        String ntutor;
        String apetutor;
        String tutorx;
        String tutory;
        String completo="";
        int canti=0;
            for(int i=0; i<h;i++){
                tutor=conjuntoProfs.getProfesor().get(i).getCedula();
                ntutor=conjuntoProfs.getProfesor().get(i).getNombre();
                apetutor=conjuntoProfs.getProfesor().get(i).getApellido();
                for(int s=0; s<j;s++){
                    fecha=conjuntoTrabj.getTrabajos().get(s).getFechaDefensa();
                    tutorx=conjuntoTrabj.getTrabajos().get(s).getCi_t();
                    tutory=conjuntoTrabj.getTrabajos().get(s).getCi_t2();
                    LocalDate z = LocalDate.parse(fecha,dateTimeFormatter);
                    if (fechaDentro(x,y,z)){
                        if (tutor.equals(tutorx) || tutor.equals(tutory)){
                            canti++;
                        }
                    }
                }
                if (canti>0){
                    
                    iReportesProf.mostrar(ntutor);
                    iReportesProf.mostrar(" ");
                    iReportesProf.mostrar(apetutor);
                    iReportesProf.mostrar(" ");
                    iReportesProf.mostrar(tutor);
                    iReportesProf.mostrar(" ");
                    iReportesProf.mostrar(Integer.toString(canti));
                    iReportesProf.mostrar("\n");
                    canti = 0;                    
                }
            }
    }      
 }