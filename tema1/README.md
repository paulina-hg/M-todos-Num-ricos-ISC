

---

# Métodos Numéricos –   Errores y Precisión

Este documento presenta los principales tipos de errores numéricos en métodos numéricos, con definiciones claras, fórmulas, seudocódigo, ejercicios resueltos y enlaces al código Java disponible en GitHub.

---

## 1. Error Absoluto

### Definición

El **error absoluto** es la diferencia directa entre el valor real y el valor medido. Es una medida de **exactitud** en unidades reales, útil para saber cuánto se ha desviado una medición del valor verdadero, sin importar su magnitud relativa.

### Fórmula

$$
Error\ absoluto = |valor\ real - valor\ medido|
$$

### Seudocódigo

```
Función CalcularErrorAbsoluto(valorReal, valorMedido)
    error = abs(valorReal - valorMedido)
    retornar error
FinFunción
```

### Código  
[ErrorAbsoluto.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema1/ErrorAbsoluto.java)

### Problema  
María midió la longitud de una varilla como 2.45 m, pero la longitud real es 2.50 m. Calcular el error absoluto.

Solución (resultado con código):  
```
Error absoluto: 0.050
```


---

## 2. Error de Propagación

### Definición

El **error de propagación** evalúa cómo se acumulan los errores individuales de múltiples variables cuando se combinan. Es vital al trabajar con fórmulas que involucran varias mediciones (como resistencias, áreas o velocidades).

### Fórmulas

* Suma o resta:

  ${
  e = e_1 + e_2
  }$
* Multiplicación:

  ${
  e = |v_1 \cdot v_2| \cdot \sqrt{\left(\frac{e_1}{v_1}\right)^2 + \left(\frac{e_2}{v_2}\right)^2}
  }$
* División:

  ${
  e = \left|\frac{v_1}{v_2}\right| \cdot \sqrt{\left(\frac{e_1}{v_1}\right)^2 + \left(\frac{e_2}{v_2}\right)^2}
  }$
* Resistencia equivalente (paralelo):

  ${
  R_{eq} = \frac{R_1 R_2}{R_1 + R_2}
  \quad\quad
  e_{Req} = R_{eq} \cdot \sqrt{\left(\frac{e_1}{R_1}\right)^2 + \left(\frac{e_2}{R_2}\right)^2}
  }$

### Seudocódigo

```
Función ResistenciaEquivalenteConError(R1, e1, R2, e2)
    Req = (R1 * R2) / (R1 + R2)
    eReq = Req * sqrt((e1/R1)^2 + (e2/R2)^2)
    retornar (Req, eReq)
FinFunción
```

### Código  
[ErrorPropagacion.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema1/ErrorPropagacion.java)

### Problema  
Calcular la resistencia equivalente y su error para dos resistencias:  

- R1 = 100Ω ± 2Ω  
- R2 = 200Ω ± 3Ω  

Solución (resultado con código):  
```
Resistencia equivalente: 66.67 ± 1.67 ohms
```


---

## 3. Error de Redondeo

### Definición

El **error de redondeo** surge al ajustar una cantidad a un número limitado de cifras decimales. Este tipo de error es frecuente en computadoras, donde los números deben representarse con precisión finita.

### Fórmula

$$
Error = |valor\ original - valor\ redondeado|
$$

### Seudocódigo

```
Función CalcularErrorRedondeo(valorOriginal, cifrasDecimales)
    valorRedondeado = redondear(valorOriginal, cifrasDecimales)
    error = abs(valorOriginal - valorRedondeado)
    retornar error
FinFunción
```

### Código  
[ErrorRedondeo.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema1/ErrorRedondeo.java)

### Problema  
Calcular el error de redondeo y su porcentaje al redondear  π = 3.14159 a 3 cifras decimales.

Solución (resultado con código):  
```
Error de redondeo: 4.1000000000002146E-4
Error de redondeo (%): 0.013051 %
```


---

## 4. Error Relativo

### Definición

El **error relativo** mide el error absoluto en proporción al valor real. Se expresa como porcentaje y permite comparar la precisión relativa de mediciones con diferentes magnitudes.

### Fórmula

$$
Error\ relativo = \frac{|valor\ real - valor\ medido|}{|valor\ real|} \times 100\%
$$

### Seudocódigo

```
Función CalcularErrorRelativo(valorReal, valorMedido)
    errorAbsoluto = abs(valorReal - valorMedido)
    errorRelativo = (errorAbsoluto / abs(valorReal)) * 100
    retornar errorRelativo
FinFunción
```

### Código  
[ErrorRelativo.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema1/ErrorRelativo.java)

### Problema  
Calcular el error relativo de una medición de 2.45 cuando el valor real es 2.50.

Solución (resultado con código):  
```
Error relativo: 2.0000 %
```


---

## 5. Error de Truncamiento

###  Definición

El **error de truncamiento** es la diferencia entre un número y su versión truncada (sin redondear). Se utiliza cuando se cortan cifras decimales para simplificar cálculos, lo que puede provocar pérdida de precisión.

### Fórmula

$$
Error = |valor\ original - valor\ truncado|
$$

### Seudocódigo

```
Función CalcularErrorTruncamiento(valorOriginal, cifrasDecimales)
    valorTruncado = truncar(valorOriginal, cifrasDecimales)
    error = abs(valorOriginal - valorTruncado)
    retornar error
FinFunción
```

### Código  
[ErrorTruncamiento.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema1/ErrorTruncamiento.java)

### Problema  
Calcular el error de truncamiento y porcentaje truncando e=2.71828 a 2 cifras decimales.

Solución (resultado con código):  
```
Error de truncamiento: 0.008280000000000065
Error de truncamiento (%): 0.304604 %
```


---

## 6. Precisión en Medición

### Definición

La **precisión en la medición** se refiere a qué tan cerca está una medición de su valor verdadero. A menor diferencia, mayor precisión. Esta medida es clave para validar la fiabilidad de instrumentos.

### Fórmula

$$
Precisión = |valor\ original - valor\ reportado|
$$

### Seudocódigo

```
Función CalcularPrecision(valorOriginal, valorReportado)
    precision = abs(valorOriginal - valorReportado)
    retornar precision
FinFunción
```

### Código  
[PrecisionMedicion.java](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/blob/main/tema1/PrecisionMedicion.java)

### Problema  
Calcular la precisión entre dos mediciones 3.45678 y 3.457, y la diferencia en área de círculo para radios 5.678 y 5.68.

Solución (resultado con código):  
```
Precisión de medición: 2.199999999996649E-4
Precisión en área de círculo: 0.07136441871895727
```

---


### Para ejecutar cada ejemplo, descarga los archivos .java en la carpeta [tema1](https://github.com/paulina-hg/M-todos-Num-ricos-ISC/tree/main/tema1) y compílalos con javac y ejecútalos con java.

---
## Bibliografía 
- Chapra, S. C., & Canale, R. P. (2006). *Métodos numéricos para ingenieros*.



