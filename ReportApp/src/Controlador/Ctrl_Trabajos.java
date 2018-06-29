package Controlador;

import Vista.*;
import Modelo.*;

public class Ctrl_Trabajos {
    private static Ctrl_Trabajos uniqueInstance = null;
    private Ctrl_Trabajos(){
        iAcceso = new IAcceso();
        iCargar = new ICargar();
        iConsulta = new IConsulta();
        iPrincipalCom = new IPrincipalCom();
        iReportesCentro = new IReportesCentro();
        iReportesProf = new IReportesProf();
        iReportesTrabProf = new IReportesTrabProf();
        reporte = new Reporte();
        
    }
    
    public static Ctrl_Trabajos getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Ctrl_Trabajos();
        }
        return uniqueInstance;
    }
    
    private IAcceso iAcceso;
    private ICargar iCargar;
    private IConsulta iConsulta;
    private IPrincipalCom iPrincipalCom;
    private IReportesCentro iReportesCentro;
    private IReportesProf iReportesProf;
    private IReportesTrabProf iReportesTrabProf;  
    private Reporte reporte;
}
