/**
 * Calcula el error relativo porcentual.
 */
public class ErrorRelativo {
    /**
     * Calcula el porcentaje de error relativo respecto al valor real.
     * @param valorReal Valor exacto.
     * @param valorMedido Valor medido.
     * @return Porcentaje de error relativo.
     */
    public static double calcular(double valorReal, double valorMedido) {
        double ea = Math.abs(valorReal - valorMedido); // error absoluto
        return (ea / Math.abs(valorReal)) * 100;
    }

    public static void main(String[] args) {
        // Caso de prueba
        double errorRel = calcular(2.50, 2.45);
        System.out.printf("Error relativo: %.4f %%\n", errorRel);
    }
}
