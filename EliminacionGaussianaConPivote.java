import java.util.Scanner;

public class EliminacionGaussianaConPivote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la matriz: ");
        int n = sc.nextInt();
        double[][] matriz = new double[n][n + 1];

        System.out.println("Ingrese la matriz aumentada:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= n; j++)
                matriz[i][j] = sc.nextDouble();

        System.out.println("\nMatriz aumentada inicial:");
        imprimirMatriz(matriz);

        // Eliminación Gaussiana con pivoteo parcial
        for (int i = 0; i < n; i++) {
            // Pivoteo parcial
            int filaMax = i;
            for (int k = i + 1; k < n; k++)
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[filaMax][i]))
                    filaMax = k;

            double[] temp = matriz[i];
            matriz[i] = matriz[filaMax];
            matriz[filaMax] = temp;

            // Eliminación hacia adelante
            for (int j = i + 1; j < n; j++) {
                double factor = matriz[j][i] / matriz[i][i];
                for (int k = i; k <= n; k++)
                    matriz[j][k] -= factor * matriz[i][k];
            }
        }

        System.out.println("\nMatriz después de eliminación:");
        imprimirMatriz(matriz);

        // Sustitución regresiva
        double[] soluciones = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++)
                suma += matriz[i][j] * soluciones[j];
            soluciones[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        System.out.println("\nSoluciones:");
        for (int i = 0; i < n; i++)
            System.out.printf("x%d = %.4f%n", i + 1, soluciones[i]);

        sc.close();
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double val : fila)
                System.out.printf("%10.4f", val);
            System.out.println();
        }
    }
}
