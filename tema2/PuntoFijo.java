public class PuntoFijo {

    // Función g(x) = cos(x), usada para la transformación f(x)=0
    public static double g(double x) {
        return Math.cos(x);
    }

    // Método del Punto Fijo
    public static double puntoFijo(double x0, double tol, int maxIter) {
        double x1;

        for (int i = 0; i < maxIter; i++) {
            x1 = g(x0); // Evaluamos la función g(x)

            if (Math.abs(x1 - x0) < tol) // Si la diferencia es menor a la tolerancia, convergió
                return x1;

            x0 = x1; // Actualizamos el valor
        }

        return Double.NaN; // Si no converge
    }

    
    public static void main(String[] args) {
        double x0 = 0.5, tol = 0.0001;
        int maxIter = 100;

        // Ejecutamos el método de Punto Fijo
        double raiz = puntoFijo(x0, tol, maxIter);

        if (!Double.isNaN(raiz))
            System.out.printf("Raíz aproximada: %.6f\n", raiz);
        else
            System.out.println("No convergió");
    }
}
