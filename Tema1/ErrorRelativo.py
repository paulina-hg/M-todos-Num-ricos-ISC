class ErrorRelativo:
    @staticmethod
    def calcular(valor_real, valor_medido):
        ea = abs(valor_real - valor_medido)
        return (ea / abs(valor_real)) * 100


if __name__ == "__main__":
    er = ErrorRelativo.calcular(2.50, 2.45)
    print(f"Error relativo: {er:.4f} %")
