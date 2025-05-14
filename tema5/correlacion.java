import java.util.Scanner; 

// Clase principal
public class correlacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        int n; // Cantidad de datos a ingresar
        double xi, yi; // Variables temporales para capturar cada par (x, y)
        
        // Variables para las sumatorias necesarias
        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0, sumaY2 = 0;
        double coefPendiente, coefIntercepto, r; // Pendiente, intercepto y coeficiente de correlación

        // Solicita la cantidad de datos al usuario
        System.out.print("Ingrese el número de datos: ");
        n = scanner.nextInt();

        // Arreglos para almacenar los valores de X y Y
        
        double[] datosX = new double[n];
        double[] datosY = new double[n];

        // Ciclo para capturar todos los valores (X, Y)
        for (int i = 0; i < n; i++) {
            System.out.println("Dato " + (i + 1));
            System.out.print("Ingrese X[" + (i + 1) + "]: ");
            xi = scanner.nextDouble();
            System.out.print("Ingrese Y[" + (i + 1) + "]: ");
            yi = scanner.nextDouble();

            // Guardar los datos en los arreglos
            datosX[i] = xi;
            datosY[i] = yi;

            // Actualizar sumatorias necesarias para la fórmula
            sumaX += xi;
            sumaY += yi;
            sumaXY += xi * yi;
            sumaX2 += xi * xi;
            sumaY2 += yi * yi;
        }

        // Cálculo del coeficiente de la pendiente (b) usando fórmula de mínimos cuadrados
        coefPendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);
        
        // Cálculo del intercepto (a)
        coefIntercepto = (sumaY - coefPendiente * sumaX) / n;

        // Cálculo del coeficiente de correlación de Pearson (r)
        r = (n * sumaXY - sumaX * sumaY) /
            Math.sqrt((n * sumaX2 - sumaX * sumaX) * (n * sumaY2 - sumaY * sumaY));

        // Mostrar resultados
        System.out.println("-----------------------------------------");
        System.out.printf("Ecuación de regresión: Y = %.4f + %.4f * X%n", coefIntercepto, coefPendiente);
        System.out.printf("Coeficiente de correlación r = %.4f%n", r);

        // Interpretación cualitativa del coeficiente de correlación
        System.out.println("Interpretación:");
        if (r > 0) {
            System.out.println("Relación positiva."); // r > 0 indica que X y Y aumentan juntos
        } else if (r < 0) {
            System.out.println("Relación negativa."); // r < 0 indica que una variable aumenta mientras la otra disminuye
        } else {
            System.out.println("La correlación es nula."); // r = 0 indica que no hay relación lineal
        }

        scanner.close(); // Cierra el objeto Scanner
    }
}
