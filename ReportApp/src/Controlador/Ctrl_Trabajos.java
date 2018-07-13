package Controlador;

import Vista.*;
import Modelo.*;
import java.io.IOException;

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
    
}
