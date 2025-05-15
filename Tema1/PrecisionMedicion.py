from math import pi

class PrecisionMedicion:
    @staticmethod
    def calcular(valor_original, valor_reportado):
        return abs(valor_original - valor_reportado)

    @staticmethod
    def area_circulo(r_original, r_reportado):
        area_real = pi * r_original ** 2
        area_reportada = pi * r_reportado ** 2
        return abs(area_real - area_reportada)


if __name__ == "__main__":
    p = PrecisionMedicion.calcular(3.45678, 3.457)
    print(f"Precisión de medición: {p}")

    a = PrecisionMedicion.area_circulo(5.678, 5.68)
    print(f"Precisión en área de círculo: {a}")
