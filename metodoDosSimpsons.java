import java.util.function.DoubleUnaryOperator;

public class metodoDosSimpsons {

    public static void main(String[] args) {
        // Defina os limites de integração e o número de subintervalos
        double a = 0.0;  // Limite inferior de integração
        double b = Math.PI;  // Limite superior de integração (por exemplo, pi para integrar sin(x) de 0 a pi)
        int n = 100;  // Número de subintervalos (deve ser par para o método de Simpson)

        // Calcula a integral usando o método de Simpson repetido
        double resultado = metodoDosSimpsons(a, b, n, Math::sin);
        
        // Exibe o resultado da integral
        System.out.println("Resultado da integral: " + resultado);
    }

    public static double metodoDosSimpsons(double a, double b, int n, DoubleUnaryOperator f) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("O número de subintervalos 'n' deve ser par para o método de Simpson.");
        }

        double h = (b - a) / n;  // Comprimento de cada subintervalo
        double integral = 0.0;

        // Aplica o método de Simpson composto em cada par de subintervalos
        for (int i = 0; i < n / 2; i++) {
            double xi0 = a + 2 * i * h;
            double xi1 = xi0 + h;
            double xi2 = xi0 + 2 * h;

            // Aplica a regra de Simpson composta para os subintervalos [xi0, xi2]
            integral += (h / 3.0) * (f.applyAsDouble(xi0) + 4 * f.applyAsDouble(xi1) + f.applyAsDouble(xi2));
        }

        return integral;
    }
}
