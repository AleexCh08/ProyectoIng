package Practica1;

import Ventanas.*;
import java.io.*;

public class Practica1 {
    
    public static void ventana1(){
        IAcceso ventana = new IAcceso();
        ventana.setTitle("Algoritmo de clasificación");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
    
    public static void ventana2(){
        IData ventana = new IData();
        ventana.setTitle("Data de entrada y resultado");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
    
    public static void main(String[] args) throws FileNotFoundException {
       
        ventana1();
        
        /*Scanner entrada = new Scanner(System.in); 
            Ejercico 2 (por consola):
        int []X = {17, 14, 65, 4, 22, 63, 11};
        int []Y = {12, 56, 20, 17, 85, 1, 50};
        System.out.println("Arreglo X: ");
        System.out.println(Arrays.toString(X));
        Sort.Quicksort(X, 0, 6);
        System.out.println(Arrays.toString(X));   
        System.out.println("Arreglo Y: ");
        System.out.println(Arrays.toString(Y));
        Sort.Burbblesort(Y, 7);
        System.out.println(Arrays.toString(Y));
        
        System.out.println(" ");
        System.out.print("Tamaño del arreglo: ");
        int size = entrada.nextInt();
        int []arr1 = new int[size];
        System.out.print("Elementos del arreglo: ");
        for(int i = 0; i < size; i++){
            arr1[i] = entrada.nextInt();
        }
        System.out.println(" ");
        System.out.println("Arreglo arr1: ");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Ordenado Quicksort: ");
        Sort.Quicksort(arr1, 0, size-1);
        System.out.println(Arrays.toString(arr1));*/             
    } 
}
