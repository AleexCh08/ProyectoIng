package Controlador;

import Modelo.Producto;

public class CtrlAcceso {
    private static CtrlInventario ctrlInventario; 

    public static void main(String[] args) {
        ctrlInventario = CtrlInventario.getInstance(); 
        
        ctrlInventario.principal();
    }
    
}
