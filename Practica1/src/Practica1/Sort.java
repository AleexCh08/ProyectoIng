package Practica1;

public class Sort {

    public static void Quicksort(int []arr, int from, int to){
        if(arr.length > 1){
            int pivot = arr[from];
            int under = from + 1;
            int over = to;
            int temp;
            while(under <= over){
                while(under <= to && arr[under] <= pivot){
                    under++;
                }
                while(over >= from && arr[over] > pivot){
                    over--;
                }
                if(under <= over){
                    temp = arr[under];
                    arr[under] = arr[over];
                    arr[over] = temp;
                    under++;
                    over--;
                }
            }
            arr[from] = arr[over];
            arr[over] = pivot;
            if(over-1 >= from){
                Quicksort(arr, from, over-1);
            }
            if(over+1 <= to){
                Quicksort(arr, over+1, to);
            }
        } else {
            System.out.println("Error. Arreglo sin elementos");
        } 
    }
    
    public static void Burbblesort(int arr[], int size){
        if(size == 0){
            System.out.println("Error. Arreglo sin elementos");
        }else{
            int temp;
            for(int i = size-1; i > 0; i--){
              for(int j = 0; j < i; j++){
                  if(arr[j] > arr[j+1]){
                      temp = arr[j];
                      arr[j] = arr[j+1];
                      arr[j+1] = temp;
                    }
                }
            }  
        } 
    }
    
    public static void Tradicionalsort(int arr[]){
        int aux1;
        int aux2;
        int temp;
        for(aux1 = 1; aux1 < arr.length; aux1++) {
            temp = arr[aux1];
            aux2 = aux1 - 1;
            while((aux2 >= 0) && (temp < arr[aux2])){
                arr[aux2+1] = arr[aux2];
                aux2--;
            }
            arr[aux2+1] = temp;
        } 
    }
}
