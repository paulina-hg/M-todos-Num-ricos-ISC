import java.util.Scanner;

public class GaussJordan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Lectura desde teclado

        System.out.println("Ingrese el tamaño de la matriz: ");
        int n = sc.nextInt(); // Leer número de incógnitas

        double[][] matriz = new double[n][n + 1]; // Crear matriz aumentada n x (n+1)

        // Llenar la matriz aumentada
        System.out.println("Ingrese la matriz aumentada:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n + 1; j++)
                matriz[i][j] = sc.nextDouble();

        System.out.println("Matriz inicial:");
        imprimirMatriz(matriz); // Mostrar matriz original

        // Resolver usando método de Gauss-Jordan
        if (resolverGaussJordan(matriz)) {
            System.out.println("Matriz final (forma escalonada reducida):");
            imprimirMatriz(matriz); // Mostrar forma final

            // Mostrar soluciones
            System.out.println("Soluciones:");
            for (int i = 0; i < n; i++)
                System.out.printf("x%d = %.4f\n", i + 1, matriz[i][n]);
        } else {
            System.out.println("El sistema no tiene solución única o es inconsistente.");
        }
    }

    // Método que aplica Gauss-Jordan
    public static boolean resolverGaussJordan(double[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            // Comprobar si el pivote es 0 y hacer cambio de fila si es necesario
            if (matriz[i][i] == 0) {
                boolean cambio = false;
                for (int k = i + 1; k < n; k++) {
                    if (matriz[k][i] != 0) {
                        double[] temp = matriz[i];
                        matriz[i] = matriz[k];
                        matriz[k] = temp;
                        cambio = true;
                        break;
                    }
                }
                if (!cambio) return false; // No se puede resolver
            }

            // Convertir el pivote a 1
            double pivote = matriz[i][i];
            for (int j = 0; j <= n; j++)
                matriz[i][j] /= pivote;

            // Hacer ceros en la columna actual excepto en la fila del pivote
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j <= n; j++)
                        matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }
        return true;
    }

    // Método para imprimir matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila)
                System.out.printf("%8.4f ", valor);
            System.out.println();
        }
        System.out.println();
    }
}
