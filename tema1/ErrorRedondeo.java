/**
 * Calcula el error absoluto y porcentual por redondeo a cierto número de decimales.
 */
public class ErrorRedondeo {
    /**
     * Calcula el error absoluto al redondear.
     * @param valorOriginal Valor real.
     * @param cifrasDecimales Cantidad de decimales a redondear.
     * @return Error absoluto.
     */
    public static double calcular(double valorOriginal, int cifrasDecimales) {
        double factor = Math.pow(10, cifrasDecimales); // escala para redondeo
        double valorRedondeado = Math.round(valorOriginal * factor) / factor;
        return Math.abs(valorOriginal - valorRedondeado);
    }

    /**
     * Calcula el error porcentual al redondear.
     * @param valorOriginal Valor real.
     * @param cifrasDecimales Decimales a redondear.
     * @return Porcentaje de error.
     */
    public static double calcularPorcentaje(double valorOriginal, int cifrasDecimales) {
        double factor = Math.pow(10, cifrasDecimales);
        double valorRedondeado = Math.round(valorOriginal * factor) / factor;
        return (Math.abs(valorOriginal - valorRedondeado) / Math.abs(valorOriginal)) * 100;
    }

    public static void main(String[] args) {
        double valor = 3.14159;
        double error = calcular(valor, 3); // redondear a 3 cifras decimales
        double errorPct = calcularPorcentaje(valor, 3);
        System.out.println("Error de redondeo: " + error);
        System.out.printf("Error de redondeo (%%): %.6f %%\n", errorPct);
    }
}
