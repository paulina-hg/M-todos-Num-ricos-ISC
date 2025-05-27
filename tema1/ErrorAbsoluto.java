/**
 * Calcula el error absoluto entre un valor real y uno medido.
 */
public class ErrorAbsoluto {
    /**
     * Retorna la diferencia absoluta entre dos valores.
     * @param valorReal Valor verdadero o exacto.
     * @param valorMedido Valor medido o aproximado.
     * @return Valor absoluto de la diferencia.
     */
    public static double calcular(double valorReal, double valorMedido) {
        return Math.abs(valorReal - valorMedido);
    }

    public static void main(String[] args) {
        // Caso de prueba: valor real 2.50, valor medido 2.45
        double error = ErrorAbsoluto.calcular(2.50, 2.45);// Caso de prueba
        System.out.printf("Error absoluto: %.3f%n", error);
    }
}
