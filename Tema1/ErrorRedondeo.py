class ErrorRedondeo:
    @staticmethod
    def calcular(valor_original, cifras_decimales):
        valor_redondeado = round(valor_original, cifras_decimales)
        return abs(valor_original - valor_redondeado)

    @staticmethod
    def calcular_porcentaje(valor_original, cifras_decimales):
        valor_redondeado = round(valor_original, cifras_decimales)
        return (abs(valor_original - valor_redondeado) / abs(valor_original)) * 100


if __name__ == "__main__":
    er = ErrorRedondeo.calcular(3.14159, 3)
    er_pct = ErrorRedondeo.calcular_porcentaje(3.14159, 3)
    print(f"Error de redondeo: {er}")
    print(f"Error de redondeo (%): {er_pct:.6f} %")
