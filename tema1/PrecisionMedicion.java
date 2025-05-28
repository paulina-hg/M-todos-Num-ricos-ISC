/**
 * Evalúa la precisión de una medición comparando dos valores.
 */
public class PrecisionMedicion {
    /**
     * Calcula la diferencia entre el valor original y el valor reportado.
     */
    public static double calcular(double valorOriginal, double valorReportado) {
        return Math.abs(valorOriginal - valorReportado);
    }

    /**
     * Calcula el error en el área de un círculo al usar un radio impreciso.
     */
    public static double areaCirculo(double rOriginal, double rReportado) {
        double areaReal = Math.PI * Math.pow(rOriginal, 2);
        double areaReportada = Math.PI * Math.pow(rReportado, 2);
        return Math.abs(areaReal - areaReportada);
    }

    public static void main(String[] args) {
        // Diferencia entre valor exacto y medido
        double precision = calcular(3.45678, 3.457);
        System.out.println("Precisión de medición: " + precision);

        // Error en el cálculo de un área
        double areaError = areaCirculo(5.678, 5.68);
        System.out.println("Precisión en área de círculo: " + areaError);
    }
}
