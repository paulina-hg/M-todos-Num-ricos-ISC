public class NewtonRaphson {

    // Función f(x) = x^2 - 2
    public static double f(double x) {
        return x * x - 2;
    }

    // Derivada de f(x): f'(x) = 2x
    public static double df(double x) {
        return 2 * x;
    }

    // Método de Newton-Raphson
    public static double newtonRaphson(double x0, double tol, int maxIter) {
        double x1;

        for (int i = 0; i < maxIter; i++) {
            x1 = x0 - f(x0) / df(x0); // Fórmula principal

            if (Math.abs(x1 - x0) < tol) // Verificamos si se alcanzó la tolerancia
                return x1;

            x0 = x1; // Actualizamos el valor
        }

        return Double.NaN; // Si no converge
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
