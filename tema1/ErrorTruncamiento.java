/**
 * Calcula el error por truncamiento (al cortar decimales sin redondear).
 */
public class ErrorTruncamiento {
    /**
     * Elimina los decimales después de cierta cantidad sin redondear.
     * @param valor Valor original.
     * @param cifrasDecimales Cantidad de decimales a conservar.
     * @return Valor truncado.
     */
    public static double truncar(double valor, int cifrasDecimales) {
        double factor = Math.pow(10, cifrasDecimales);
        return ((int)(valor * factor)) / factor;
    }

    /**
     * Calcula el error absoluto de truncamiento.
     */
    public static double calcular(double valorOriginal, int cifrasDecimales) {
        double truncado = truncar(valorOriginal, cifrasDecimales);
        return Math.abs(valorOriginal - truncado);
    }

    /**
     * Calcula el error porcentual de truncamiento.
     */
    public static double calcularPorcentaje(double valorOriginal, int cifrasDecimales) {
        double truncado = truncar(valorOriginal, cifrasDecimales);
        return (Math.abs(valorOriginal - truncado) / Math.abs(valorOriginal)) * 100;
    }

    public static void main(String[] args) {
        double valor = 2.71828;
        double error = calcular(valor, 2); // truncado a 2 decimales
        double errorPct = calcularPorcentaje(valor, 2);
        System.out.println("Error de truncamiento: " + error);
        System.out.printf("Error de truncamiento (%%): %.6f %%\n", errorPct);
    }
}
