class ErrorAbsoluto:
    @staticmethod
    def calcular(valor_real, valor_medido):
        return abs(valor_real - valor_medido)


if __name__ == "__main__":
    ea = ErrorAbsoluto.calcular(2.50, 2.45)
    print(f"Error absoluto: {ea}")
