// Clase que contiene el método de interpolación lineal
class InterpolacionLineal {
    // Método que recibe dos puntos (x0, y0) y (x1, y1), y un valor x para el cual se quiere interpolar y
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        double m = (y1 - y0) / (x1 - x0); // Se calcula la pendiente de la recta entre los dos puntos
        return y0 + m * (x - x0); // Fórmula de la recta para obtener y interpolado
    }
}

// Clase principal que utiliza el método de interpolación
public class Interpolacion_Lineal {
    public static void main(String[] args) {
        // Se realiza una interpolación entre los puntos (3.20, 2.79) y (4, 3.56) para x = 3.6
        double resultado = InterpolacionLineal.interpolar(3.20, 2.79, 4, 3.56, 3.6);

        // Se muestra el valor interpolado con 4 cifras decimales
        System.out.printf("Valor interpolado en x = 3.6000 es: %.4f", resultado);
    }
    
}
