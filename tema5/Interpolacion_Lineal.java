class InterpolacionLineal {
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        double m = (y1 - y0) / (x1 - x0);
        return y0 + m * (x - x0);
    }
}
public class Interpolacion_Lineal {
    public static void main(String[] args) {
        double resultado = InterpolacionLineal.interpolar(10, 500, 30, 1500, 20.0);
        System.out.printf("Valor interpolado en x = 20.0000 es: %.4f Pa%n", resultado);
    }
}
