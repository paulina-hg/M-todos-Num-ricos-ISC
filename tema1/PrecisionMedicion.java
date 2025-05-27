public class PrecisionMedicion {
    public static double calcular(double valorOriginal, double valorReportado) {
        return Math.abs(valorOriginal - valorReportado);
    }

    public static double areaCirculo(double rOriginal, double rReportado) {
        double areaReal = Math.PI * Math.pow(rOriginal, 2);
        double areaReportada = Math.PI * Math.pow(rReportado, 2);
        return Math.abs(areaReal - areaReportada);
    }

    public static void main(String[] args) {
        double precision = calcular(3.45678, 3.457);
        System.out.println("Precisión de medición: " + precision);

        double areaError = areaCirculo(5.678, 5.68);
        System.out.println("Precisión en área de círculo: " + areaError);
    }
}
