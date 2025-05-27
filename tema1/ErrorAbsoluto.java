/**
 * Clase: ErrorAbsoluto
 * Descripción: Calcula el error absoluto entre un valor real y uno medido.
 * Autor: [Tu Nombre]
 * Fecha: [Fecha actual]
 */
public class ErrorAbsoluto {
    /**
     * Calcula el error absoluto.
     * @param valorReal El valor verdadero.
     * @param valorMedido El valor medido o aproximado.
     * @return El valor absoluto de la diferencia.
     */
    public static double calcular(double valorReal, double valorMedido) {
        return Math.abs(valorReal - valorMedido);
    }

    public static void main(String[] args) {
        double error = ErrorAbsoluto.calcular(2.50, 2.45);
        System.out.printf("Error absoluto: %.3f%n", error);  // Caso de prueba
    }
}
