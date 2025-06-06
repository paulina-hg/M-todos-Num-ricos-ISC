# Tema 4: Integración y Derivación Numérica


Este módulo aborda técnicas numéricas para calcular integrales y derivadas de funciones reales utilizando fórmulas de aproximación. 

## Cuadratura Gaussiana

### Definición

La Cuadratura Gaussiana es un método de integración numérica que permite calcular una aproximación precisa de una integral definida. A diferencia de los métodos de Newton-Cotes, este método elige de forma óptima los puntos (raíces de los polinomios de Legendre) y los pesos, logrando así una mejor precisión con menos evaluaciones de la función.

### Fórmula


$\int_{-1}^{1} f(x) dx \approx \sum_{i=1}^{n} w_i f(x_i)$

Donde:

* $x_i$: raíces del polinomio de Legendre de grado $n$.
* $w_i$: pesos correspondientes.

### Seudocódigo

```
ALGORITMO Cuadratura_Gaussiana

	FUNCION funcion(x: REAL) : REAL
    	RETORNAR exp(-x * x)
	FIN FUNCION

	FUNCION cuadraturaGaussiana(a: REAL, b: REAL, n: ENTERO) : REAL
    	DEFINIR coeficientes COMO diccionario de ENTERO a ARREGLO de REAL
    	DEFINIR nodos COMO diccionario de ENTERO a ARREGLO de REAL

    	// Definir coeficientes para diferentes valores de n
    	coeficientes[2] = [1.0, 1.0]
    	coeficientes[3] = [0.5555555556, 0.8888888889, 0.5555555556]
    	coeficientes[4] = [0.3478548451, 0.6521451549, 0.6521451549, 0.3478548451]
    	coeficientes[5] = [0.2369268851, 0.4786286705, 0.5688888889, 0.4786286705, 0.2369268851]
    	coeficientes[6] = [0.1713244924, 0.3607615730, 0.4679139346, 0.4679139346, 0.3607615730, 0.1713244924]

    	// Definir nodos para diferentes valores de n
    	nodos[2] = [-0.5773502692, 0.5773502692]
    	nodos[3] = [0.0, -0.7745966692, 0.7745966692]
    	nodos[4] = [-0.3399810436, 0.3399810436, -0.8611363116, 0.8611363116]
    	nodos[5] = [0.0, -0.5384693101, 0.5384693101, -0.9061798459, 0.9061798459]
    	nodos[6] = [0.6612093865, -0.6612093865, -0.2386191861, 0.2386191861, -0.9324695142, 0.9324695142]

    	// Obtener coeficientes y nodos correspondientes a n
    	coef <- coeficientes[n]
    	nodo <- nodos[n]

    	suma <- 0.0

    	// Sumar contribuciones de cada nodo
    	PARA i DESDE 0 HASTA n-1 HACER
        	xi <- ((b - a) * nodo[i] + a + b) / 2.0
        	suma <- suma + coef[i] * funcion(xi)
    	FIN PARA

    	RETORNAR (b - a) / 2.0 * suma
	FIN FUNCION

	// Programa principal
	INICIO
    	DEFINIR limiteInferior COMO REAL = 0
    	DEFINIR limiteSuperior COMO REAL = 1
    	DEFINIR numeroPuntosGauss COMO ENTERO = 4

    	resultado <- cuadraturaGaussiana(limiteInferior, limiteSuperior, numeroPuntosGauss)

    	IMPRIMIR "El resultado de la integral es: ", resultado
	FIN

FIN ALGORITMO

```

### Código en Java

[CuadraturaGaussiana.java](https://github.com/paulina-hg/M-todos-de-Diferenciaci-n-e-Integraci-n-Num-rica/blob/main/CuadraturaGaussiana.java)

### Problema o ejercicio
```
Función:
${f(x) = ln(x + 1)}$
Segmentos: n=4
Función: ln(x+1)
Límite Inferior: 0
Límite Superior: 2
Número de Puntos de Gauss: 4
Resultado de la función por Cuadratura Gaussiana: 1.294
```

---

## Derivación numérica de 3 puntos

### Definición

Este método utiliza una fórmula de diferencias finitas hacia adelante o hacia atrás para estimar la derivada de una función en un punto específico. Es útil cuando se tienen pocos puntos cercanos y se desea una aproximación rápida.

### Fórmula (adelante)

$f'(x_0) \approx \frac{-3f(x_0) + 4f(x_1) - f(x_2)}{2h}$

### Seudocódigo

```
INICIO
  // Clase para representar una función matemática
  CLASE Función
    ATRIBUTOS:
      expresión: cadena
      builder: objeto ExpressionBuilder (de la librería exp4j)
    CONSTRUCTOR(expresión_str)
      establecer expresión = expresión_str
      intentar
        crear builder con la expresión y la variable "x"
      capturar excepción
        establecer builder = nulo
      fin intentar
    FIN_CONSTRUCTOR
    FUNCIÓN esValida(): BOOLEANO
      SI builder es diferente de nulo ENTONCES
        retornar VERDADERO
      SINO
        retornar FALSO
      FIN_SI
    FIN_FUNCIÓN
    FUNCIÓN evaluar(valor_x): DOBLE
      SI NO esValida() ENTONCES
        retornar NoEsUnNúmero
      FIN_SI
      establecer la variable "x" del builder con valor_x
      retornar el resultado de evaluar la expresión del builder
    FIN_FUNCIÓN
  FIN_CLASE
  // Función principal
  FUNCIÓN principal()
    crear un objeto Scanner para leer la entrada del usuario
    imprimir "DERIVACIÓN NUMÉRICA (MÉTODO DE 3 PUNTOS)"
    imprimir "\nIngrese la función f(x): "
    leer funcionStr
    imprimir "Ingrese el valor de x: "
    leer x
    imprimir "Ingrese el valor de h: "
    leer h
    crear un objeto Función llamado funcion con funcionStr
    SI NO funcion.esValida() ENTONCES
      imprimir "Error: La función ingresada no es válida."
      imprimir "Asegúrese de usar sintaxis correcta."
      terminar el programa con código de error 1
    FIN_SI
    imprimir "\nRESULTADOS:"
    imprimir "f(", formatear x con 4 decimales, ") = ", formatear funcion.evaluar(x) con 3 decimales
    imprimir "Derivada hacia adelante: ", formatear derivadaAdelante(funcion, x, h) con 3 decimales
    imprimir "Derivada hacia atrás:          ", formatear derivadaAtras(funcion, x, h) con 3 decimales
    imprimir "Derivada centrada:            ", formatear derivadaCentrada(funcion, x, h) con 3 decimales
    cerrar el objeto Scanner
  FIN_FUNCIÓN
  // Función para calcular la derivada numérica hacia adelante (método de 3 puntos)
  FUNCIÓN derivadaAdelante(f: Función, x: DOBLE, h: DOBLE): DOBLE
    retornar (-f.evaluar(x + 2*h) + 4*f.evaluar(x + h) - 3*f.evaluar(x)) / (2*h)
  FIN_FUNCIÓN
  // Función para calcular la derivada numérica hacia atrás (método de 3 puntos)
  FUNCIÓN derivadaAtras(f: Función, x: DOBLE, h: DOBLE): DOBLE
    retornar (3*f.evaluar(x) - 4*f.evaluar(x - h) + f.evaluar(x - 2*h)) / (2*h)
  FIN_FUNCIÓN
  // Función para calcular la derivada numérica centrada (método de 3 puntos)
  FUNCIÓN derivadaCentrada(f: Función, x: DOBLE, h: DOBLE): DOBLE
    retornar (f.evaluar(x + h) - f.evaluar(x - h)) / (2*h)
  FIN_FUNCIÓN
FIN

```

### Código en Java

[Derivacion3Puntos.java](https://github.com/paulina-hg/M-todos-de-Diferenciaci-n-e-Integraci-n-Num-rica/blob/main/DerivacionNumericaTresPuntos.java)

### Problema o ejercicio

```
Función: ${f(x) = e^x}$
x=2
h=0.1
Resultados:
f(2.000)=7.389
Derivada hacia adelante: 7.362
Derivada hacia atrás: 7.366
Derivada centrada: 7.401

```

---

## Derivación centrada de 5 puntos

### Definición

Este método calcula la derivada de una función en un punto utilizando cinco valores igualmente espaciados. Es más preciso que los métodos de tres puntos y se utiliza cuando se requiere mayor exactitud.

### Fórmula

$f'(x_0) \approx \frac{f(x-2h) - 8f(x-h) + 8f(x+h) - f(x+2h)}{12h}$

### Seudocódigo

```
/*
 * PSEUDOCÓDIGO: MÉTODO DE 5 PUNTOS CENTRADO PARA DERIVACIÓN NUMÉRICA
 * 
 * Este algoritmo calcula la derivada de una función en un punto dado usando
 * el método de 5 puntos centrado, que ofrece una aproximación más precisa
 * que métodos con menos puntos.
 */

ALGORITMO Derivacion5Puntos
    // Entrada de datos
    IMPRIMIR "DERIVACIÓN NUMÉRICA (MÉTODO DE 5 PUNTOS CENTRADO)"
    
    // Solicitar función, punto y tamaño de paso
    IMPRIMIR "Ingrese la función f(x): "
    LEER funcionStr
    
    IMPRIMIR "Ingrese el valor de x: "
    LEER x
    
    IMPRIMIR "Ingrese el valor de h: "
    LEER h
    
    // Validar la función (implementación dependiente del lenguaje)
    SI NO esFuncionValida(funcionStr) ENTONCES
        IMPRIMIR "Error: Función no válida"
        TERMINAR
    FIN SI
    
    // Calcular derivada
    derivada = CalcularDerivada5Puntos(funcionStr, x, h)
    
    // Mostrar resultados
    IMPRIMIR "RESULTADOS:"
    IMPRIMIR "f(" + x + ") = " + EvaluarFuncion(funcionStr, x)
    IMPRIMIR "Derivada centrada (5 puntos): " + derivada
FIN ALGORITMO

/*
 * Función para calcular la derivada usando el método de 5 puntos centrado
 * Fórmula: f'(x) ≈ [-f(x+2h) + 8f(x+h) - 8f(x-h) + f(x-2h)] / (12h)
 */
FUNCIÓN CalcularDerivada5Puntos(funcion, x, h)
    // Evaluar la función en los puntos necesarios
    fx2h = EvaluarFuncion(funcion, x + 2*h)
    fxh = EvaluarFuncion(funcion, x + h)
    fxmh = EvaluarFuncion(funcion, x - h)
    fxm2h = EvaluarFuncion(funcion, x - 2*h)
    
    // Aplicar fórmula de 5 puntos
    derivada = (-fx2h + 8*fxh - 8*fxmh + fxm2h) / (12*h)
    
    RETORNAR Redondear(derivada, 4)
FIN FUNCIÓN

/*
 * Función auxiliar para redondear a N decimales
 */
FUNCIÓN Redondear(valor, decimales)
    factor = 10^decimales
    RETORNAR REDONDEO(valor * factor) / factor
FIN FUNCIÓN


```

### Código en Java

[Derivacion5Puntos.java](https://github.com/paulina-hg/M-todos-de-Diferenciaci-n-e-Integraci-n-Num-rica/blob/main/Derivacion5Puntos.java)

### Problema o ejercicio

```
DERIVACIÓN NUMÉRICA (MÉTODO DE 5 PUNTOS CENTRADO)
Ingrese la función f(x): e^x
Ingrese el valor de x: 0
Ingrese el valor de h: 0.01
RESULTADOS:
f(0.0000) = 1.0000
Derivada centrada (5 puntos) : 1.0000
```
---

## Método del Trapecio

### Definición

Este método numérico aproxima el área bajo una curva usando trapecios. Es una técnica sencilla que ofrece buena precisión si la función es suave.

### Fórmula

$\int_{a}^{b} f(x) dx \approx \frac{h}{2}(f(a) + f(b))$

### Seudocódigo

```
Proceso MetodoTrapecio

    Definir a, b, h, resultado, suma, xi, fi, f0, fn Como Real
    Definir n, i, opcion Como Entero

    Escribir "INTEGRACIÓN NUMÉRICA - MÉTODO DEL TRAPECIO"
    
    Escribir "Selecciona la función a integrar:"
    Escribir "1. f(x) = x^2 + 4x + 4"
    Escribir "2. f(x) = cos(x) + x^2"
    Escribir "3. f(x) = e^x"
    Escribir "4. f(x) = 1 / (1 + x^2)"
    Leer opcion
    
    Escribir "Introduce el límite inferior (a):"
    Leer a
    
    Escribir "Introduce el límite superior (b):"
    Leer b
    
    Escribir "Introduce el número de intervalos (n):"
    Leer n

    h <- (b - a) / n
    suma <- 0

    // Calcular f(a)
    xi <- a
    f0 <- f(xi, opcion)
    
    // Calcular f(b)
    xi <- b
    fn <- f(xi, opcion)

    Para i <- 1 Hasta n - 1 Con Paso 1
        xi <- a + i * h
        fi <- f(xi, opcion)
        suma <- suma + fi
    FinPara

    resultado <- h * ( (f0 + fn) / 2 + suma )

    Escribir "Resultado de la integral: ", resultado

FinProceso

Funcion f(x, opcion) Como Real
    Segun opcion Hacer
        Caso 1:
            f <- x^2 + 4*x + 4
        Caso 2:
            f <- cos(x) + x^2
        Caso 3:
            f <- exp(x)
        Caso 4:
            f <- 1 / (1 + x^2)
        De Otro Modo:
            f <- 0
    FinSegun
FinFuncion

```

### Código en Java

[MetodoTrapecio.java](https://github.com/paulina-hg/M-todos-de-Diferenciaci-n-e-Integraci-n-Num-rica/blob/main/MetodoTrapecio.java)

### Problema o ejercicio

```
Función: x^2 + 4
Intervalo: [0, 2]
n = 4
Resultado aproximado: ≈ 10.75

```
---

## Método de Simpson 1/3

### Definición

El método de Simpson 1/3 es un método de integración numérica que utiliza una parábola para aproximar el área bajo una curva. Requiere un número par de subintervalos (o un solo tramo con tres puntos).

### Fórmula

$\int_{a}^{b} f(x) dx \approx \frac{h}{3} [f(a) + 4f((a+b)/2) + f(b)]$

### Seudocódigo

```

Proceso Simpson13

    // Definir parámetros fijos para la integración
    Definir a, b, resultado Como Real
    Definir n Como Entero

    a <- 0           // Límite inferior
    b <- 2           // Límite superior
    n <- 4           // Número de segmentos (debe ser par)

    // Calcular la integral usando la regla de Simpson 1/3
    resultado <- simpson13(a, b, n)

    // Imprimir información y resultado formateado
    Escribir "Función: x*sin(x)"
    Escribir "Límite Inferior: ", a
    Escribir "Límite Superior: ", b
    Escribir "Número de Segmentos: ", n
    Escribir "Resultado de la integral por el método de Simpson 1/3: ", resultado

FinProceso


Funcion resultado <- funcion(x)
    Definir resultado Como Real
    resultado <- x * sen(x)
FinFuncion


Funcion resultado <- simpson13(a, b, n)
    Definir resultado, h, suma, x Como Real
    Definir i Como Entero

    // Validar que n sea par
    Si (n MOD 2 <> 0) Entonces
        Escribir "ERROR: n debe ser un número par"
        FinFuncion
    FinSi

    // Calcular el tamaño del paso
    h <- (b - a) / n

    // Inicializar la suma con f(a) + f(b)
    suma <- funcion(a) + funcion(b)

    // Sumar los puntos intermedios
    Para i <- 1 Hasta n - 1
        x <- a + i * h
        Si (i MOD 2 = 0) Entonces
            suma <- suma + 2 * funcion(x)
        Sino
            suma <- suma + 4 * funcion(x)
        FinSi
    FinPara

    // Aplicar la fórmula final
    resultado <- (h / 3) * suma

FinFuncion

```

### Código en Java

[Simpson13.java](https://github.com/paulina-hg/M-todos-de-Diferenciaci-n-e-Integraci-n-Num-rica/blob/main/Simpson13.java)

### Problema o ejercicio

```
Función: x^2
Limite Inferior: 0
Límite Superior: 2
Número de Segmentos: 4
Resultado de la función por el método de Simpson 1/3: 2.667
```

---

## Método de Simpson 3/8

### Definición

El método de Simpson 3/8 es una variante del método de Simpson que usa tres subintervalos (cuatro puntos) para aproximar el área bajo una curva. Es especialmente útil cuando el número de subintervalos es múltiplo de 3.

### Fórmula

$\int_{a}^{b} f(x) dx \approx \frac{3h}{8} [f(a) + 3f(a+h) + 3f(a+2h) + f(b)]$

### Seudocódigo

```
Proceso Simpson38

    // Definir parámetros fijos para la integración
    Definir a, b, resultado Como Real
    Definir n Como Entero

    a <- 0           // Límite inferior
    b <- 2           // Límite superior
    n <- 6           // Número de segmentos (debe ser múltiplo de 3)

    // Calcular la integral usando la regla de Simpson 3/8
    resultado <- simpson38(a, b, n)

    // Imprimir información y resultado formateado
    Escribir "Función: x*sin(x)"
    Escribir "Límite Inferior: ", a
    Escribir "Límite Superior: ", b
    Escribir "Número de Segmentos: ", n
    Escribir "Resultado de la integral por el método de Simpson 3/8: ", resultado
FinProceso
Funcion resultado <- funcion(x)
    Definir resultado Como Real
    resultado <- x * sen(x)
FinFuncion
Funcion resultado <- simpson38(a, b, n)
    Definir resultado, h, suma, x Como Real
    Definir i Como Entero
    // Validar que n sea múltiplo de 3
    Si (n MOD 3 <> 0) Entonces
        Escribir "ERROR: n debe ser múltiplo de 3"
        FinFuncion
    FinSi
    // Calcular el tamaño del paso
    h <- (b - a) / n
    // Inicializar la suma con f(a) + f(b)
    suma <- funcion(a) + funcion(b)
    // Sumar los puntos intermedios
    Para i <- 1 Hasta n - 1
        x <- a + i * h
        Si (i MOD 3 = 0) Entonces
            suma <- suma + 2 * funcion(x)
        Sino
            suma <- suma + 3 * funcion(x)
        FinSi
    FinPara

    // Aplicar la fórmula final
    resultado <- (3 * h / 8) * suma

FinFuncion



```

### Código en Java

[Simpson38.java](https://github.com/paulina-hg/M-todos-de-Diferenciaci-n-e-Integraci-n-Num-rica/blob/main/Simpson38.java)

### Problema o ejercicio

```
Función: x*sin (x)
Límite Inferior: 0
Límite Superior: 2
Número de Segmentos: 6
Resultado de la integral por el método de Simpson 3/8: 1.741
```

### Bibliografía
Chapra, S. C., & Canale, R. P. (2007). Métodos numéricos para ingenieros. McGraw-Hill.