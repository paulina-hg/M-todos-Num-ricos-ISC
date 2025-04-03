import java.util.Arrays;

public class MetodoJacobi {

    public static void main(String[] args) {
        double[][][] testCases = {

            { 
                {1, 2, 3},
                {7, 8, 9}
            }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\nCaso " + (i + 1) + ":");
            solveJacobi(testCases[i], 1e-6, 100);
        }
    }

    public static void solveJacobi(double[][] matrix, double tolerance, int maxIterations) {
        int n = matrix.length;
        double[] previous = new double[n];
        double[] current = new double[n];
        Arrays.fill(previous, 0);
        
        System.out.println("Matriz original:");
        printMatrix(matrix);

        if (!isDiagonallyDominant(matrix)) {
            System.out.println("Este sistema no es diagonalmente dominante y puede no converger con el método de Jacobi.");
            return;
        }

        int iterations = 0;
        for (int iter = 0; iter < maxIterations; iter++) {
            for (int i = 0; i < n; i++) {
                double sum = matrix[i][n];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= matrix[i][j] * previous[j];
                    }
                }
                current[i] = sum / matrix[i][i];
            }

            iterations++;
            if (converged(previous, current, tolerance)) {
                System.out.println("Soluciones (después de " + iterations + " iteraciones):");
                for (int i = 0; i < n; i++) {
                    System.out.printf("x%d = %.4f\n", i + 1, current[i]);
                }
                return;
            }
            System.arraycopy(current, 0, previous, 0, n);
        }
        System.out.println("No se alcanzó la convergencia en " + maxIterations + " iteraciones.");
    }

    public static boolean isDiagonallyDominant(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += Math.abs(matrix[i][j]);
                }
            }
            if (Math.abs(matrix[i][i]) < sum) {
                return false;
            }
        }
        return true;
    }

    public static boolean converged(double[] prev, double[] curr, double tol) {
        for (int i = 0; i < prev.length; i++) {
            if (Math.abs(curr[i] - prev[i]) > tol) {
                return false;
            }
        }
        return true;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.4f", value);
            }
            System.out.println();
        }
        System.out.println();
    }
}
