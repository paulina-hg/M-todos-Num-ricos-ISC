from math import sqrt

class ErrorPropagacion:
    @staticmethod
    def suma(e1, e2):
        return e1 + e2

    @staticmethod
    def resta(e1, e2):
        return e1 + e2

    @staticmethod
    def multiplicacion(v1, e1, v2, e2):
        return abs(v1 * v2) * sqrt((e1 / v1) ** 2 + (e2 / v2) ** 2)

    @staticmethod
    def division(v1, e1, v2, e2):
        return abs(v1 / v2) * sqrt((e1 / v1) ** 2 + (e2 / v2) ** 2)

    @staticmethod
    def resistencia_equivalente(R1, e1, R2, e2):
        Req = (R1 * R2) / (R1 + R2)
        eReq = Req * sqrt((e1 / R1) ** 2 + (e2 / R2) ** 2)
        return Req, eReq


if __name__ == "__main__":
    # Ejemplo: resistencia equivalente con error propagado
    Req, eReq = ErrorPropagacion.resistencia_equivalente(100, 2, 200, 3)
    print(f"Resistencia equivalente: {Req:.2f} ± {eReq:.2f} ohms")
