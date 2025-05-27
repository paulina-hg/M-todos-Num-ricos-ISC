public class Biseccion {

    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    public static double calcular(double a, double b, double tol, int maxIter) {
        if (f(a) * f(b) >= 0) {
            throw new IllegalArgumentException("f(a) y f(b) deben tener signos opuestos");
        }

        double c = a;
        for (int i = 0; i < maxIter; i++) {
            c = (a + b) / 2;
            if (Math.abs(f(c)) < tol) break;

            if (f(a) * f(c) < 0)
                b = c;
            else
                a = c;
        }
        return c;
    }

    public static void main(String[] args) {
        double raiz = calcular(1, 2, 1e-6, 100);
        System.out.printf("Raíz aproximada: %.6f%n", raiz);
    }
}
