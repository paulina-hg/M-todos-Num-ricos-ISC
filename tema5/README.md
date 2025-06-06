
# Tema 5: Interpolación y Ajuste de Curvas

---

## 1. Interpolación Lineal

### Definición

La interpolación lineal es un método que aproxima el valor de una función entre dos puntos conocidos asumiendo que la función es lineal entre esos puntos. Se utiliza una recta que pasa por ambos puntos para estimar valores intermedios.

### Fórmula

Dado dos puntos $(x_0, y_0)$ y $(x_1, y_1)$, el valor interpolado $y$ para un valor $x$ entre $x_0$ y $x_1$ es:

$$
y = y_0 + \frac{(y_1 - y_0)}{(x_1 - x_0)} (x - x_0)
$$


### Seudocódigo

```
Entradas: x0, y0, x1, y1, x
Paso 1: Calcular la pendiente: m = (y1 - y0) / (x1 - x0)
Paso 2: Calcular f(x): y = y0 + m * (x - x0)
Salida: y

```

### Código Java

[Interpolacion_Lineal.java](https://github.com/paulina-hg/TEMA-5---Interpolaci-n-y-ajuste-de-funciones/blob/main/Interpolacion_Lineal.java)

### Ejemplo resuelto

```
Estimar la temperatura a las 3 horas

Tabla de datos
Hora (x): 1, 2, 3
Temperatura (y °C): 36.5555, 37.2222, 38.1111

Planteamiento:
El médico desea estimar la temperatura del paciente a las 3 horas.
Datos introducidos:
x₀ = 2, y₀ = 37.2222
x₁ = 4, y₁ = 38.1111
x = 3.0

Resultado esperado:
37.6667 °C

Ejecución de código: 
Valor interpolado: 37.6667 

```
---

## 2. Método de Mínimos Cuadrados (Ajuste Lineal)

### Definición

El método de mínimos cuadrados se utiliza para ajustar una recta a un conjunto de datos experimentales minimizando la suma de los cuadrados de las diferencias entre los valores observados y los valores predichos por la recta.

### Fórmulas

Dado $n$ puntos $(x_i, y_i)$, la recta de regresión es:

$$
y = a + b x
$$

donde

$$
b = \frac{n \sum x_i y_i - \sum x_i \sum y_i}{n \sum x_i^2 - (\sum x_i)^2}
$$

$$
a = \frac{\sum y_i - b \sum x_i}{n}
$$

### Seudocódigo

```
Inicio
  Mostrar "Método de mínimos cuadrados - Ajuste lineal"

  Leer n  

  Crear lista x vacía
  Crear lista y vacía

  Para i desde 1 hasta n hacer:
    Leer xi
    Leer yi
    Agregar xi a la lista x
    Agregar yi a la lista y
  Fin Para

  Inicializar sum_x ← 0
  Inicializar sum_y ← 0
  Inicializar sum_x2 ← 0
  Inicializar sum_xy ← 0

  Para i desde 0 hasta n-1 hacer:
    sum_x  ← sum_x  + x[i]
    sum_y  ← sum_y  + y[i]
    sum_x2 ← sum_x2 + x[i]²
    sum_xy ← sum_xy + x[i] * y[i]
  Fin Para

  b ← (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x²)
  a ← (sum_y - b * sum_x) / n

  Redondear a y b a 4 cifras decimales

  Mostrar "Resultado:"
  Mostrar "La recta de regresión es: y = a + bx"

Fin

```
### Código Java
[MinimosCuadrados.java](https://github.com/paulina-hg/TEMA-5---Interpolaci-n-y-ajuste-de-funciones/blob/main/MinimosCuadrados.java)


### Ejemplo resuelto

```
Relación entre años de experiencia y salario mensual


Años de experiencia (x)
Salario (y, USD)
1
1500
3
2100
5
2600
7
3000
9
3400


Desea estimar el salario para 6 años de experiencia.

Datos introducidos:
ArrayList<Double> x = [1.0, 3.0, 5.0, 7.0, 9.0];
ArrayList<Double> y = [1500.0, 2100.0, 2600.0, 3000.0, 3400.0];

Resultado lanzado por el código:
La recta de regresion es: y = 1394.2857 + 238.5714x

Salario estimado para 6 años: y = 1394.2857 + 238.5714(6) = 2821.7141 USD
El salario estimado es: 2821.7141 USD

```
---

## 3. Interpolación de Newton (Diferencias Divididas)

### Definición

La interpolación de Newton utiliza diferencias divididas para construir un polinomio que pasa exactamente por un conjunto de puntos. Es eficiente para agregar nuevos puntos sin recalcular todo el polinomio.

### Fórmulas

El polinomio de interpolación de Newton es:

$$
P_n(x) = f[x_0] + f[x_0, x_1](x - x_0) + f[x_0, x_1, x_2](x - x_0)(x - x_1) + \cdots
$$

Donde $f[x_i, \dots, x_j]$ son las diferencias divididas.

### Seudocódigo

```
Proceso InterpolacionNewton
    Definir x[100], y[100], dd[100,100] Como Real
    Definir n, i, j Como Entero
    Definir xEval, resultado, producto Como Real

    // Leer cantidad de puntos
    Escribir "Ingrese la cantidad de puntos:"
    Leer n

    // Leer los valores de x
    Para i <- 0 Hasta n - 1 Con Paso 1
        Escribir "x[", i, "] = "
        Leer x[i]
    FinPara

    // Leer los valores de y
    Para i <- 0 Hasta n - 1 Con Paso 1
        Escribir "y[", i, "] = "
        Leer y[i]
    FinPara

    // Inicializar la primera columna de diferencias divididas con y
    Para i <- 0 Hasta n - 1 Con Paso 1
        dd[i, 0] <- y[i]
    FinPara

    // Calcular diferencias divididas
    Para j <- 1 Hasta n - 1 Con Paso 1
        Para i <- 0 Hasta n - j - 1 Con Paso 1
            dd[i, j] <- (dd[i + 1, j - 1] - dd[i, j - 1]) / (x[i + j] - x[i])
        FinPara
    FinPara

    // Evaluar el polinomio
    Escribir "Ingrese el valor de x para evaluar el polinomio:"
    Leer xEval

    resultado <- dd[0, 0]
    producto <- 1

    Para i <- 1 Hasta n - 1 Con Paso 1
        producto <- producto * (xEval - x[i - 1])
        resultado <- resultado + dd[0, i] * producto
    FinPara

    Escribir "El valor interpolado en x = ", xEval, " es: ", resultado
FinProceso

```

### Código Java

[NewtonInterpolation.java](https://github.com/paulina-hg/TEMA-5---Interpolaci-n-y-ajuste-de-funciones/blob/main/NewtonInterpolation.java)

### Ejemplo resuelto

```
Una empresa registra la producción de una máquina (en unidades) cada hora.



Hora (x)
Producción (y)
1
100
3
170
6
290



Se desea estimar la producción a las 4 horas.

Datos introducidos:

En los valores de x ingresamos los siguientes datos: 1, 3, 6.

En los valores de y se ingresan: 100, 170, 290.

En el código sería algo así:


double[] x = {1, 3, 6};
double[] y = {100, 170, 290};
double xEval = 4.0;



El resultado lanzado sería:

Valor interpolado en x = 4.0000 es: 210.0000 

Por lo que podemos concluir que a las 4 horas, la producción estimada de la máquina es 210.0000 unidades.
```


---

## 4. Coeficiente de Correlación y Regresión Lineal

### Definición

El coeficiente de correlación de Pearson mide la fuerza y dirección de la relación lineal entre dos variables. La regresión lineal estima la relación funcional entre ellas.

### Fórmulas

Ecuación de regresión:

$$
Y = a + bX
$$

donde

$$
b = \frac{n \sum xy - \sum x \sum y}{n \sum x^2 - (\sum x)^2}
$$

$$
a = \frac{\sum y - b \sum x}{n}
$$

Coeficiente de correlación $r$:

$$
r = \frac{n \sum xy - \sum x \sum y}{\sqrt{\left(n \sum x^2 - (\sum x)^2\right) \left(n \sum y^2 - (\sum y)^2\right)}}
$$

### Seudocódigo

```
Algoritmo Correlacion
Definir n, i Como Entero
Definir xi, yi Como Real
Definir sumaX, sumaY, sumaXY, sumaX2, sumaY2 Como Real
Definir coefPendiente, coefIntercepto, r Como Real
	
Escribir "Ingrese el número de datos:"
Leer n
	
Dimension datosX[n], datosY[n]
	
sumaX <- 0
sumaY <- 0
sumaXY <- 0
sumaX2 <- 0
sumaY2 <- 0
	
Para i <- 1 Hasta n Con Paso 1
	Escribir "Dato ", i
	Escribir "Ingrese X[", i "]: "
	Leer xi
	Escribir "Ingrese Y[", i, "]: "
	Leer yi
		
	datosX[i] <- xi
	datosY[i] <- yi
		
	sumaX <- sumaX + xi
	sumaY <- sumaY + yi
	sumaXY <- sumaXY + xi * yi
	sumaX2 <- sumaX2 + xi * xi
	sumaY2 <- sumaY2 + yi * yi
Fin Para
	
coefPendiente <- (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX)
coefIntercepto <- (sumaY - coefPendiente * sumaX) / n
	
r <- (n * sumaXY - sumaX * sumaY) / raiz( (n * sumaX2 - sumaX^2) * (n * sumaY2 - sumaY^2) )
Escribir "-----------------------------------------"
Escribir "Ecuación de regresión: Y = ", coefIntercepto, " + ", coefPendiente, " * X"
Escribir "Coeficiente de correlación r = ", r
Escribir "Interpretación:"
Si r > 0 Entonces

```

### Código Java

[correlacion.java](https://github.com/paulina-hg/TEMA-5---Interpolaci-n-y-ajuste-de-funciones/blob/main/correlacion.java)

### Ejemplo resuelto

```
Temperatura vs ventas de sopa caliente 
Un restaurante analiza cómo afecta la temperatura exterior a las ventas de sopa caliente.
Temperatura (°C) (X)
Ventas (Y)
30
50
28
60
26
70
24
85
22
95

Resultado esperado:
Ecuación: Y = 221.5000 - 5.7500 * X
r ≈ -0.9972
Interpretación: Correlación negativa muy fuerte.
Resultado en el código:
Ingrese el número de datos: 5
Dato 1
Ingrese X[1]: 30
Ingrese Y[1]: 50
Dato 2
Ingrese X[2]: 28
Ingrese Y[2]: 60
Dato 3
Ingrese X[3]: 26
Ingrese Y[3]: 70
Dato 4
Ingrese X[4]: 24
Ingrese Y[4]: 85
Dato 5
Ingrese X[5]: 22
Ingrese Y[5]: 95
Ecuación de regresión: Y = 221.5000 + -5.7500 * X
Coeficiente de correlación r = -0.9972
Interpretación:
Relación negativa.

```

---

## Bibliografía 
- Chapra, S. C., & Canale, R. P. (2006). *Métodos numéricos para ingenieros*.
- Burden, R. L., & Faires, J. D. (2011). *Análisis numérico*.
