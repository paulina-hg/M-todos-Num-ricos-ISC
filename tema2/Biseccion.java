public class Biseccion {

    // Función objetivo f(x) = x^3 - x - 2
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    // Método de Bisección
    public static double biseccion(double a, double b, double tol, int maxIter) {
        // Verificamos que haya una raíz en el intervalo [a, b]
        if (f(a) * f(b) >= 0) {
            System.out.println("No se garantiza raíz en el intervalo");
            return Double.NaN;
        }

        double c = a; // Inicializamos c
        for (int i = 0; i < maxIter; i++) {
            c = (a + b) / 2; // Punto medio
            if (Math.abs(f(c)) < tol) // Verifica si el valor es suficientemente cercano a 0
                break;
            if (f(c) * f(a) < 0) // La raíz está en [a, c]
                b = c;
            else // La raíz está en [c, b]
                a = c;
        }

        return c; // Retornamos la raíz aproximada
    }

    public static void main(String[] args) {
        double a = 1, b = 2, tol = 0.0001;
        int maxIter = 100;

        // Llamamos al método de Bisección y mostramos la raíz
        
        double raiz = biseccion(a, b, tol, maxIter);
        System.out.printf("Raíz aproximada: %.6f\n", raiz);
    }
}
