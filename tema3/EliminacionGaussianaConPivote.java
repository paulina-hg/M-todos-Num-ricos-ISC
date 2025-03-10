import java.util.Scanner;
public class EliminacionGaussianaConPivote {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int tamaño=0;
        System.out.println("Ingrese el tamaño de la matriz ");
        tamaño = sc.nextInt();
        int filas= tamaño;
        int columnas= tamaño;
        int[][] matriz = new int[filas][columnas];
        
         // Llenar la matriz con un for anidado
         System.out.println("Ingrese los valores de la matriz:");
         for (int i = 0; i < filas; i++) {
             for (int j = 0; j < columnas; j++) {
                 System.out.print("Elemento [" + i + "][" + j + "]: ");
                 matriz[i][j] = sc.nextInt();
             }
         }
 
         // Imprimir la matriz
         System.out.println("\nMatriz ingresada:");
         for (int i = 0; i < filas; i++) {
             for (int j = 0; j < columnas; j++) {
                 System.out.print(matriz[i][j]);
             }
             System.out.println();
         }

        

    }
    
}