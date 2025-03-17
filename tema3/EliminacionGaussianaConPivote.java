import java.util.Scanner;

public class EliminacionGaussianaConPivote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear objeto para leer entrada del usuario

        System.out.print("Ingrese el tamaño de la matriz: ");
        int n = sc.nextInt(); // Leer el tamaño de la matriz

        double[][] matriz = new double[n][n + 1]; // Declarar matriz aumentada de tamaño n x (n+1)

        // Leer valores de la matriz aumentada
        System.out.println("Ingrese la matriz aumentada:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= n; j++)
                matriz[i][j] = sc.nextDouble();

        System.out.println("\nMatriz aumentada inicial:");
        imprimirMatriz(matriz); // Mostrar matriz antes del proceso

        // Eliminar hacia adelante (método de eliminación Gaussiana con pivoteo)
        for (int i = 0; i < n; i++) {
            // Encontrar fila con el mayor valor absoluto en la columna i
            int filaMax = i;
            for (int k = i + 1; k < n; k++)
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[filaMax][i]))
                    filaMax = k;

            // Intercambiar filas si es necesario (pivoteo parcial)
            double[] temp = matriz[i];
            matriz[i] = matriz[filaMax];
            matriz[filaMax] = temp;

            // Eliminar los elementos por debajo del pivote
            for (int j = i + 1; j < n; j++) {
                double factor = matriz[j][i] / matriz[i][i];
                for (int k = i; k <= n; k++)
                    matriz[j][k] -= factor * matriz[i][k];
            }
        }

        System.out.println("\nMatriz después de eliminación:");
        imprimirMatriz(matriz); // Mostrar la matriz después de eliminación hacia adelante

        // Sustitución regresiva para resolver el sistema triangular superior
        double[] soluciones = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++)
                suma += matriz[i][j] * soluciones[j];
            soluciones[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        // Mostrar las soluciones
        System.out.println("\nSoluciones:");
        for (int i = 0; i < n; i++)
            System.out.printf("x%d = %.4f%n", i + 1, soluciones[i]);

        sc.close(); // Cerrar el escáner
    }

    // Método para imprimir la matriz en consola
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double val : fila)
                System.out.printf("%10.4f", val);
            System.out.println();
            
        }
    }
}
