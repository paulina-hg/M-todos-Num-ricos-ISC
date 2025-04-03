import java.util.Scanner;


public class MetodoGaussSeidel {


    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);


        System.out.println("Ingrese el tamaño de la matriz: ");
        int sc = lee.nextInt();


        double m[][] = new double[sc][sc + 1];


        // Llenado de la matriz
        for (int i = 0; i < sc; i++) {
            for (int j = 0; j <= sc; j++) {
                System.out.println("Ingrese el valor en la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                m[i][j] = lee.nextDouble();
            }
        }


        // Mostrar matriz original
        System.out.println("\nMatriz original:");
        for (int i = 0; i < sc; i++) {
            for (int j = 0; j <= sc; j++) {
                System.out.printf("%8.2f ", m[i][j]);
            }
            System.out.println();
        }


        // Mostrar matriz aumentada
        System.out.println("\nMatriz aumentada:");
        for (int i = 0; i < sc; i++) {
            for (int j = 0; j < sc; j++) {
                System.out.printf("%8.2f ", m[i][j]);
            }
            System.out.print("| "); // Separador para la columna de resultados
            System.out.printf("%8.2f", m[i][sc]);
            System.out.println();
        }


        // Verificar si el sistema es singular
        if (esSistemaSingular(m)) {
            System.out.println("El sistema es singular, no tiene una solución única.");
            return;
        }


        // Inicialización de las soluciones 
        double[] x = new double[sc];
        for (int i = 0; i < sc; i++) {
            x[i] = 0;
        }


        // Parámetros de iteración
        double tol = 1e-6;
        int maxIter = 1000;
        int iter = 0;
        double maxDiff;


        // Iteración de Gauss-Seidel
        while (iter < maxIter) {
            iter++;
            maxDiff = 0;


            // Iteraciones en el orden correcto
            for (int i = 0; i < sc; i++) {
                double suma = m[i][sc];
                for (int j = 0; j < sc; j++) {
                    if (i != j) {
                        suma -= m[i][j] * x[j]; // Se usa el valor más reciente de x[j] si ya fue calculado
                    }
                }


                double nuevoValor = suma / m[i][i];
                maxDiff = Math.max(maxDiff, Math.abs(nuevoValor - x[i]));
                x[i] = nuevoValor;
            }


            // Verificar convergencia
            if (maxDiff < tol) {
                break;
            }
        }


        // Mostrar las soluciones
        if (iter == maxIter) {
            System.out.println("\nEl método no ha convergido después de " + maxIter + " iteraciones.");
        } else {
            System.out.println("\nSoluciones (después de " + iter + " iteraciones):");
            for (int i = 0; i < sc; i++) {
                System.out.printf("x" + (i + 1) + " = %8.4f\n", x[i]);
            }
        }


        lee.close();
    }


    // Método para verificar si el sistema es singular (determinante 0)
    public static boolean esSistemaSingular(double[][] m) {
        if (m.length != 3 || m[0].length != 4) {
            return false; // Solo evaluamos matrices 3x3 para este caso
        }
        
        double determinant = m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                           - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                           + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
        
        return determinant == 0; // Si el determinante es 0, el sistema es singular
    }
}
