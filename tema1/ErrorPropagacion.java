/**
 * Calcula la propagación del error en distintas operaciones.
 */
public class ErrorPropagacion {
    /**
     * Propagación en suma: se suman los errores.
     */
    public static double suma(double e1, double e2) {
        return e1 + e2;
    }

    /**
     * Propagación en resta: también se suman los errores.
     */
    public static double resta(double e1, double e2) {
        return e1 + e2;
    }

    /**
     * Propagación en multiplicación usando fórmula relativa.
     */
    public static double multiplicacion(double v1, double e1, double v2, double e2) {
        return Math.abs(v1 * v2) * Math.sqrt(Math.pow(e1 / v1, 2) + Math.pow(e2 / v2, 2));
    }

    /**
     * Propagación en división usando fórmula relativa.
     */
    public static double division(double v1, double e1, double v2, double e2) {
        return Math.abs(v1 / v2) * Math.sqrt(Math.pow(e1 / v1, 2) + Math.pow(e2 / v2, 2));
    }

    /**
     * Calcula la resistencia equivalente de dos resistencias en paralelo y su error.
     * @return Arreglo con resistencia equivalente y su error.
     */
    public static double[] resistencia_equivalente(double R1, double e1, double R2, double e2) {
        double Req = (R1 * R2) / (R1 + R2); // fórmula de resistencias en paralelo
        double eReq = Req * Math.sqrt(Math.pow(e1 / R1, 2) + Math.pow(e2 / R2, 2));
        return new double[]{Req, eReq};
    }

    public static void main(String[] args) {
        double R1 = 100, e1 = 2;
        double R2 = 200, e2 = 3;
        // Calcula Req y su  error
        double[] resultado = resistencia_equivalente(R1, e1, R2, e2);
        System.out.printf("Resistencia equivalente: %.2f ± %.2f ohms%n", resultado[0], resultado[1]);
    }
}
