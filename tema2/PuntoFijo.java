public class PuntoFijo {
    public static double g(double x) {
        return Math.cos(x); // Ejemplo g(x) = cos(x), transformado para f(x)=0
    }

    public static double puntoFijo(double x0, double tol, int maxIter) {
        double x1;
        for (int i = 0; i < maxIter; i++) {
            x1 = g(x0);
            if (Math.abs(x1 - x0) < tol)
                return x1;
            x0 = x1;
        }
        return Double.NaN; // No convergió
    }

    public static void main(String[] args) {
        double x0 = 0.5, tol = 0.0001;
        int maxIter = 100;
        double raiz = puntoFijo(x0, tol, maxIter);
        if (!Double.isNaN(raiz))
            System.out.printf("Raíz aproximada: %.6f\n", raiz);
        else
            System.out.println("No convergió");
    }
}
