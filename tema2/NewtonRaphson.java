public class NewtonRaphson {
    public static double f(double x) {
        return x * x - 2; // Ejemplo f(x) = x^2 - 2
    }

    public static double df(double x) {
        return 2 * x; // Derivada f'(x) = 2x
    }

    public static double newtonRaphson(double x0, double tol, int maxIter) {
        double x1;
        for (int i = 0; i < maxIter; i++) {
            x1 = x0 - f(x0) / df(x0);
            if (Math.abs(x1 - x0) < tol)
                return x1;
            x0 = x1;
        }
        return Double.NaN; // No convergió
    }

    public static void main(String[] args) {
        double x0 = 1, tol = 0.0001;
        int maxIter = 100;
        double raiz = newtonRaphson(x0, tol, maxIter);
        if (!Double.isNaN(raiz))
            System.out.printf("Raíz aproximada: %.6f\n", raiz);
        else
            System.out.println("No convergió");
    }
}
