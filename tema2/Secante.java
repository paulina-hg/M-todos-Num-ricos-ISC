public class Secante {

    // Función f(x) = ln(x) - 1
    public static double f(double x) {
        return Math.log(x) - 1;
    }

    // Método de la Secante
    public static double secante(double x0, double x1, double tol, int maxIter) {
        double x2;

        for (int i = 0; i < maxIter; i++) {
            if (f(x1) - f(x0) == 0) {
                System.out.println("División entre cero");
                return Double.NaN;
            }

            // Fórmula del método de la secante
            x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0));

            if (Math.abs(x2 - x1) < tol) // Si la diferencia entre iteraciones es pequeña
                return x2;

            x0 = x1; // Desplazamos los puntos para la siguiente iteración
            x1 = x2;
        }

        return Double.NaN;
    }

    public static void main(String[] args) {
        double x0 = 2, x1 = 3, tol = 0.0001;
        int maxIter = 100;

        double raiz = secante(x0, x1, tol, maxIter);

        if (!Double.isNaN(raiz))
            System.out.printf("Raíz aproximada: %.6f\n", raiz);
        else
            System.out.println("No convergió");
    }
    
}
