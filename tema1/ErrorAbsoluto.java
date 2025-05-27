public class ErrorAbsoluto {
    public static double calcular(double valorReal, double valorMedido) {
        return Math.abs(valorReal - valorMedido);
    }

    public static void main(String[] args) {
        double error = ErrorAbsoluto.calcular(2.50, 2.45);
        System.out.printf("Error absoluto: %.3f%n", error);
    }
}
