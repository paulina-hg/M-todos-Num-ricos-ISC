public class ErrorTruncamiento {
    public static double truncar(double valor, int cifrasDecimales) {
        double factor = Math.pow(10, cifrasDecimales);
        return ((int)(valor * factor)) / factor;
    }

    public static double calcular(double valorOriginal, int cifrasDecimales) {
        double truncado = truncar(valorOriginal, cifrasDecimales);
        return Math.abs(valorOriginal - truncado);
    }

    public static double calcularPorcentaje(double valorOriginal, int cifrasDecimales) {
        double truncado = truncar(valorOriginal, cifrasDecimales);
        return (Math.abs(valorOriginal - truncado) / Math.abs(valorOriginal)) * 100;
    }

    public static void main(String[] args) {
        double valor = 2.71828;
        double error = calcular(valor, 2);
        double errorPct = calcularPorcentaje(valor, 2);
        System.out.println("Error de truncamiento: " + error);
        System.out.printf("Error de truncamiento (%%): %.6f %%\n", errorPct);
    }
}
