public class ErrorRedondeo {
    public static double calcular(double valorOriginal, int cifrasDecimales) {
        double factor = Math.pow(10, cifrasDecimales);
        double valorRedondeado = Math.round(valorOriginal * factor) / factor;
        return Math.abs(valorOriginal - valorRedondeado);
    }

    public static double calcularPorcentaje(double valorOriginal, int cifrasDecimales) {
        double factor = Math.pow(10, cifrasDecimales);
        double valorRedondeado = Math.round(valorOriginal * factor) / factor;
        return (Math.abs(valorOriginal - valorRedondeado) / Math.abs(valorOriginal)) * 100;
    }

    public static void main(String[] args) {
        double valor = 3.14159;
        double error = calcular(valor, 3);
        double errorPct = calcularPorcentaje(valor, 3);
        System.out.println("Error de redondeo: " + error);
        System.out.printf("Error de redondeo (%%): %.6f %%\n", errorPct);
    }
}
