public class ReglaFalsa {

    // Función objetivo f(x) = e^(-x) - x
    public static double f(double x) {
        return Math.exp(-x) - x;
    }

    // Método de la Regla Falsa
    public static double reglaFalsa(double a, double b, double tol, int maxIter) {
        if (f(a) * f(b) >= 0) {
            System.out.println("No se garantiza raíz en el intervalo");
            return Double.NaN;
        }

        double c = a; // Inicialización
        for (int i = 0; i < maxIter; i++) {
            // Fórmula de Regla Falsa
            c = (a * f(b) - b * f(a)) / (f(b) - f(a));

            if (Math.abs(f(c)) < tol) // Condición de convergencia
                break;

            if (f(c) * f(a) < 0)
                b = c;
            else
                a = c;
        }

        return c;
    }

    public static void main(String[] args) {
        double a = 0, b = 1, tol = 0.0001;
        int maxIter = 100;

        // Llamamos al método y mostramos el resultado
        double raiz = reglaFalsa(a, b, tol, maxIter);
        System.out.printf("Raíz aproximada: %.6f\n", raiz);
    }
}
