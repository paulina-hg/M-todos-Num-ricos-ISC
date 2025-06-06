# Tema 2: Solución de ecuaciones no lineales
## Métodos Numéricos 

Este documento contiene una descripción detallada de los métodos numéricos utilizados para encontrar soluciones aproximadas de ecuaciones no lineales. Cada método incluye su definición, fórmula, seudocódigo, código en Java (enlace) y un problema resuelto.

---

## 1. Método de Bisección

**Definición:**
El método de bisección es una técnica de búsqueda binaria para encontrar la raíz de una función continua en un intervalo \[a, b] donde se cumple el teorema de Bolzano: f(a) \* f(b) < 0. El método divide iterativamente el intervalo a la mitad hasta encontrar una aproximación aceptable de la raíz.

**Fórmula:**
$c = \frac{a + b}{2}$

**Seudocódigo:**

```
Inicio
  Definir a, b, tolerancia, maxIter
  Si f(a)*f(b) >= 0 entonces
    Error: No se garantiza raíz en el intervalo
  FinSi
  Para i = 1 hasta maxIter hacer
    c = (a + b) / 2
    Si |f(c)| < tolerancia entonces
      Retornar c
    FinSi
    Si f(c)*f(a) < 0 entonces
      b = c
    Sino
      a = c
    FinSi
  FinPara
  Retornar c
Fin

```

**Código en Java:**
[Biseccion.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema2/Biseccion.java)

**Ejercicio resuelto:**
Encontrar la raíz de la función ${f(x) = (x^3 - x - 2)}$ en el intervalo \[1, 2]. Resultado: Raíz aproximada: 1.521380

---

## 2. Método de la Regla Falsa

**Definición:**
Este método también requiere que f(a) \* f(b) < 0, pero en lugar de usar el punto medio, utiliza la intersección de la línea secante entre (a, f(a)) y (b, f(b)) con el eje x. Es más rápido que la bisección para algunas funciones.

**Fórmula:**
$x_r = b - \frac{f(b)(a - b)}{f(a) - f(b)}$

**Seudocódigo:**

```
Inicio
  Definir a, b, tolerancia, maxIter
  Si f(a)*f(b) >= 0 entonces
    Error: No se garantiza raíz en el intervalo
  FinSi
  Para i = 1 hasta maxIter hacer
    c = (a*f(b) - b*f(a)) / (f(b) - f(a))
    Si |f(c)| < tolerancia entonces
      Retornar c
    FinSi
    Si f(c)*f(a) < 0 entonces
      b = c
    Sino
      a = c
    FinSi
  FinPara
  Retornar c
Fin

```

**Código en Java:**
[ReglaFalsa.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema2/ReglaFalsa.java)

**Ejercicio resuelto:**
Resolver ${f(x) = e^-x - x }$ en el intervalo \[0, 1]. Resultado: Raíz aproximada: 0.567206

---

## 3. Método del Punto Fijo

**Definición:**
Transforma la ecuación $f(x) = 0$ en la forma $x = g(x)$, y usa iteraciones de $x_{n+1} = g(x_n)$ para encontrar un punto fijo, es decir, donde $x = g(x)$.

**Fórmula:**
$x_{n+1} = g(x_n)$

**Seudocódigo:**

```
Inicio
  Definir x0, tolerancia, maxIter
  Para i = 1 hasta maxIter hacer
    x1 = g(x0)
    Si |x1 - x0| < tolerancia entonces
      Retornar x1
    FinSi
    x0 = x1
  FinPara
  Retornar error (no convergió)
Fin

```

**Código en Java:**
[PuntoFijo.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema2/PuntoFijo.java)

**Ejercicio resuelto:**
Resolver $x = cos(x)$ con $x_0 = 0.5$. Resultado: Raíz aproximada: 0.739050

---

## 4. Método de Newton-Raphson

**Definición:**
Este método usa derivadas para refinar una aproximación inicial. A partir de una estimación inicial $x_0$, se calcula sucesivamente $x_{n+1} = x_n - f(x_n)/f'(x_n)$.

**Fórmula:**
$x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}$

**Seudocódigo:**

```
Inicio
  Definir x0, tolerancia, maxIter
  Para i = 1 hasta maxIter hacer
    x1 = x0 - f(x0)/f'(x0)
    Si |x1 - x0| < tolerancia entonces
      Retornar x1
    FinSi
    x0 = x1
  FinPara
  Retornar error (no convergió)
Fin

```

**Código en Java:**
[NewtonRaphson.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema2/NewtonRaphson.java)

**Ejercicio resuelto:**
Encontrar la raíz de  ${f(x) = x^2 - 2 }$ con $x_0 = 1.0$. Resultado: Raíz aproximada: 1.414214



---

## 5. Método de la Secante

**Definición:**
Es una versión modificada del método de Newton-Raphson que no requiere derivada, usando dos aproximaciones iniciales para calcular sucesivamente la siguiente.

**Fórmula:**
$x_{n+1} = x_n - f(x_n)\frac{x_n - x_{n-1}}{f(x_n) - f(x_{n-1})}$

**Seudocódigo:**

```
Inicio
  Definir x0, x1, tolerancia, maxIter
  Para i = 1 hasta maxIter hacer
    Si f(x1) - f(x0) == 0 entonces
      Error: División entre cero
    FinSi
    x2 = x1 - f(x1)*(x1 - x0)/(f(x1) - f(x0))
    Si |x2 - x1| < tolerancia entonces
      Retornar x2
    FinSi
    x0 = x1
    x1 = x2
  FinPara
  Retornar error (no convergió)
Fin

```

**Código en Java:**
[Secante.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema2/Secante.java)

**Ejercicio resuelto:**
Resolver ${f(x) = ln(x) -1 }$ con $x_0 = 2, x_1 = 3$. Resultado: Raíz aproximada: 2.718282

---

### Referencia general:

Todos los códigos están disponibles en la carpeta `tema2` del repositorio:


👉 [Repositorio GitHub: Métodos Numéricos ISC](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/tree/main/tema2)

-Chapra, S. C., & Canale, R. P. (2006). Métodos numéricos para ingenieros.
