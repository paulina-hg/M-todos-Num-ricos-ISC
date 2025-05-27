public class ErrorPropagacion {
    public static double suma(double e1, double e2) {
        return e1 + e2;
    }

    public static double resta(double e1, double e2) {
        return e1 + e2;
    }

    public static double multiplicacion(double v1, double e1, double v2, double e2) {
        return Math.abs(v1 * v2) * Math.sqrt(Math.pow(e1 / v1, 2) + Math.pow(e2 / v2, 2));
    }

    public static double division(double v1, double e1, double v2, double e2) {
        return Math.abs(v1 / v2) * Math.sqrt(Math.pow(e1 / v1, 2) + Math.pow(e2 / v2, 2));
    }

    public static double[] resistencia_equivalente(double R1, double e1, double R2, double e2) {
        double Req = (R1 * R2) / (R1 + R2);
        double eReq = Req * Math.sqrt(Math.pow(e1 / R1, 2) + Math.pow(e2 / R2, 2));
        return new double[]{Req, eReq};
    }

    public static void main(String[] args) {
        double R1 = 100, e1 = 2;
        double R2 = 200, e2 = 3;
        double[] resultado = resistencia_equivalente(R1, e1, R2, e2);
        System.out.printf("Resistencia equivalente: %.2f ± %.2f ohms%n", resultado[0], resultado[1]);
    }
}
