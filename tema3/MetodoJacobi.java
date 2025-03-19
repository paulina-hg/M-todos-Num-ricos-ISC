import java.util.Arrays;

public class MetodoJacobi {
    public static void main(String[] args) {
        double[][][] testCases = {
            {
                {10, 1, 1, 12},
                {2, 10, 1, 13},
                {2, 2, 10, 14}
            }
        };

        // Ejecutar todos los casos de prueba
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\nCaso " + (i + 1) + ":");
            solveJacobi(testCases[i], 1e-6, 100); // Ejecutar el método con tolerancia y máx. iteraciones
        }
    }

    // Método del Jacobi
    public static void solveJacobi(double[][] matrix, double tolerance, int maxIterations) {
        int n = matrix.length;
        double[] previous = new double[n]; // Soluciones anteriores
        double[] current = new double[n];  // Soluciones actuales
        Arrays.fill(previous, 0); // Inicializar soluciones previas

        System.out.println("Matriz original:");
        printMatrix(matrix);

        // Verificar si la matriz es diagonalmente dominante
        if (!isDiagonallyDominant(matrix)) {
            System.out.println("Este sistema no es diagonalmente dominante y puede no converger con el método de Jacobi.");
            return;
        }

        // Proceso iterativo
        int iterations = 0;
        for (int iter = 0; iter < maxIterations; iter++) {
            for (int i = 0; i < n; i++) {
                double sum = matrix[i][n];
                for (int j = 0; j < n; j++) {
                    if (j != i)
                        sum -= matrix[i][j] * previous[j];
                }
                current[i] = sum / matrix[i][i];
            }

            iterations++;
            if (converged(previous, current, tolerance)) {
                // Imprimir soluciones
                System.out.println("Soluciones (después de " + iterations + " iteraciones):");
                for (int i = 0; i < n; i++)
                    System.out.printf("x%d = %.4f\n", i + 1, current[i]);
                return;
            }

            // Copiar valores actuales a los anteriores para la siguiente iteración
            System.arraycopy(current, 0, previous, 0, n);
        }

        System.out.println("No se alcanzó la convergencia en " + maxIterations + " iteraciones.");
    }

    // Verifica si la matriz es diagonalmente dominante
    public static boolean isDiagonallyDominant(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            double suma = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (i != j)
                    suma += Math.abs(matrix[i][j]);
            }
            if (Math.abs(matrix[i][i]) <= suma)
                return false;
        }
        return true;
    }

    // Verifica si se ha alcanzado la tolerancia deseada
    public static boolean converged(double[] prev, double[] curr, double tol) {
        for (int i = 0; i < prev.length; i++) {
            if (Math.abs(curr[i] - prev[i]) > tol)
                return false;
        }
        return true;
    }

    
    // Imprime la matriz
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%10.4f ", val);
            System.out.println();
        }
    }
}
