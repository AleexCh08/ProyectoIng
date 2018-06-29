package Controlador;

import Modelo.Inventario;
import Modelo.Producto;
import Vista.*;
import java.util.Iterator;
import javax.swing.JFrame;

public class CtrlInventario {
    private static CtrlInventario uniqueInstance = null; 
    private IPrincipal iPrincipal; 
    private IAgregar iAgregar; 
    private IConsultar iConsultar; 
    private IEliminar iEliminar; 
    private IModificar iModificar; 
    private Inventario inventario; 
    private IExito iExito; 
    
    private JFrame regreso; 
    private Producto eliminar; 
    
    private CtrlInventario() {
        iPrincipal = new IPrincipal(this); 
        iAgregar = new IAgregar(this); 
        iConsultar = new IConsultar(this); 
        iEliminar = new IEliminar(this); 
        iModificar = new IModificar(this); 
        inventario = new Inventario(); 
        iExito = new IExito(this); 
    }
    
    public static CtrlInventario getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new CtrlInventario(); 
        }
        
        return uniqueInstance; 
    }
    
    public void ocultarTodo() {
        iPrincipal.ocultar(); 
        iAgregar.ocultar(); 
        iConsultar.ocultar(); 
        iEliminar.ocultar(); 
        iModificar.ocultar(); 
        iExito.ocultar(); 
    }
    
    public void principal() {
        ocultarTodo(); 
        iPrincipal.setVisible(true);
    }
    
    public void agregarProducto(JFrame ventana) {
        regreso = ventana; 
        ocultarTodo(); 
        iAgregar.setVisible(true); 
    }
    
    public void consultarProducto() {
        ocultarTodo();  
        
        actualizarConsulta();
        
        iConsultar.setVisible(true); 
    }
    
    public void actualizarConsulta() {
        String codigo; 
        String nombre; 
        String fecha; 
        String precio; 
        String descripcion;
        for(Producto p : inventario.getTodo()){
            codigo = p.getCodigo(); 
            nombre = p.getNombre(); 
            fecha = p.getFecha(); 
            precio = p.getPrecio().toString();
            descripcion = p.getDescripcion(); 
            iConsultar.agregarFila(codigo, fecha, nombre, precio, descripcion);
        }
    }

    public void agregar() {
        String codigo; 
        String nombre; 
        Double precio; 
        String descripcion; 
        
        codigo = iAgregar.getCodigo(); 
        nombre = iAgregar.getNombre();
        
        descripcion = iAgregar.getDescripcion();
        
        if(codigo.length() == 0){
            System.out.println("Aqui");
            iAgregar.desplegarMsj("Error: El codigo no puede ser vacio"); 
        }else if(inventario.existe(codigo)){
            iAgregar.desplegarMsj("Error: Ya existe un producto con ese codigo"); 
        } else {
            if(nombre.length() == 0){
                iAgregar.desplegarMsj("Error: El nombre no puede ser vacio"); 
            } else  if (!esNumerico(iAgregar.getPrecio())){
                iAgregar.desplegarMsj("Error: El precio debe ser un valor real distinto de vacio");
            } else {
                precio = Double.parseDouble(iAgregar.getPrecio()); 
                Producto p = new Producto(codigo, nombre, precio, descripcion); 
                inventario.agregar(p);
                iAgregar.limpiar(); 
                notificar("Producto agregado con exito");
            }
        }
        
    }
    
    private boolean esNumerico(String numero) {
        boolean retorno = true; 
        int cantPuntos = 0; 
        if(numero.length() > 0) {
            if(numero.charAt(0) < '0' || numero.charAt(0) > '9') {
                retorno = false;
            } else {        
                for(int i = 1; i < numero.length(); i++) {
                    if(numero.charAt(i) < '0' || numero.charAt(i) > '9') {
                        if(numero.charAt(i) == '.') {
                            cantPuntos++;
                        } else {
                            retorno = false; 
                            break; 
                        }
                    }
                }

                if(retorno && cantPuntos > 1) {
                    retorno = false; 
                } 
            }
        } else {
            retorno = false; 
        }
        
        return retorno; 
    }

    public void volver() {
        ocultarTodo(); 
        actualizarConsulta();
        regreso.setVisible(true); 
    }
    
    public void salir() {
        System.exit(0);
    }
    
    public void buscar(String codigo) {
        if(codigo.length() > 0) {
            boolean encontrado = false; 
            String cod; 
            String nombre; 
            String fecha; 
            String precio; 
            String descripcion;

            iConsultar.limpiar(); 

            for(Producto p : inventario.getTodo()){
                cod = p.getCodigo(); 

                if(cod.toLowerCase().equals(codigo.toLowerCase())){
                    encontrado = true; 
                    nombre = p.getNombre(); 
                    fecha = p.getFecha(); 
                    precio = p.getPrecio().toString(); 
                    descripcion = p.getDescripcion(); 

                    iConsultar.agregarFila(cod, fecha, nombre, precio, descripcion); 
                }
            }

            if(!encontrado) {
                iConsultar.desplegarMsj("No se encontraron productos con ese código"); 
            }
        } else {
            iConsultar.desplegarMsj("Error: El campo código está vacío.");
        }
    }

    public void seleccionado(boolean valor) {
        iConsultar.permitirBotones(valor);
    }
    
    public void modificar(String codigo) {
        ocultarTodo(); 
        regreso = iConsultar; 
        Producto p = inventario.buscar(codigo);
        String nombre = p.getNombre();
        String precio = p.getPrecio().toString();
        String descripcion = p.getDescripcion(); 
        
        iModificar.desplegarCodigo(codigo);
        iModificar.desplegarNombre(nombre); 
        iModificar.desplegarPrecio(precio); 
        iModificar.desplegarDescripcion(descripcion);
        
        iModificar.setVisible(true); 
    }
    
    public void modificar() {
        String codigo = iModificar.getCodigo(); 
        String nombre = iModificar.getNombre(); 
        
        if(nombre.length() == 0) {
            iModificar.desplegarMsj("Error: El nombre no puede ser vacio.");
        } else if (!esNumerico(iModificar.getPrecio())){
            iModificar.desplegarMsj("Error: El precio debe ser un valor real distinto de vacio");
        } else {
            String descripcion = iModificar.getDescripcion();
            Double precio = Double.parseDouble(iModificar.getPrecio()); 
            Producto p = new Producto(codigo, nombre, precio, descripcion); 
            inventario.modificar(codigo, p);
            notificar("Producto modificado con exito");
        }
    }
    
    public void notificar(String msj) {
        ocultarTodo(); 
        iExito.desplegarMsj(msj); 
        iExito.setVisible(true); 
    }
    
    public void actualizar() {
        iConsultar.limpiar();
        actualizarConsulta();
    }
    
    public void eliminar(String codigo) {
        ocultarTodo(); 
        eliminar = inventario.buscar(codigo); 
        String nombre = eliminar.getNombre(); 
        
        iEliminar.desplegar(codigo + " - " + nombre);
        iEliminar.setVisible(true); 
    }
    
    public void eliminar() {
        inventario.eliminar(eliminar.getCodigo());
        eliminar = null; 
        consultarProducto(); 
    }
    
    public void cancelarEliminar() {
        eliminar = null; 
        consultarProducto(); 
    }
}
