class ErrorTruncamiento:
    @staticmethod
    def truncar(valor, cifras_decimales):
        factor = 10 ** cifras_decimales
        truncado = int(valor * factor) / factor
        return truncado

    @staticmethod
    def calcular(valor_original, cifras_decimales):
        truncado = ErrorTruncamiento.truncar(valor_original, cifras_decimales)
        return abs(valor_original - truncado)

    @staticmethod
    def calcular_porcentaje(valor_original, cifras_decimales):
        truncado = ErrorTruncamiento.truncar(valor_original, cifras_decimales)
        return (abs(valor_original - truncado) / abs(valor_original)) * 100


if __name__ == "__main__":
    et = ErrorTruncamiento.calcular(2.71828, 2)
    et_pct = ErrorTruncamiento.calcular_porcentaje(2.71828, 2)
    print(f"Error de truncamiento: {et}")
    print(f"Error de truncamiento (%): {et_pct:.6f} %")
