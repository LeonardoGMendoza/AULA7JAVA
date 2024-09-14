package section4_3;

public class RecursionExample {

    public static void main(String[] args) {
    	
    	
    	
    	 // Dados reais do IBOVESPA
        double currentIbovespaValue = 134.882; // Valor atual
        double minIbovespaValue = 134.031;     // Mínimo do dia
        double maxIbovespaValue = 135.879;     // Máximo do dia

        // Teste da sequência de Fibonacci com lógica fuzzy
        System.out.println("Índice  | Valor Fibonacci | Grau de Pertinência (Atual) | Grau de Pertinência (Intervalo)");
        for (int i = 0; i < 10; i++) {
            double fuzzyValueCurrent = fuzzyFibonacci(i, currentIbovespaValue);
            double fuzzyValueRange = fuzzyFibonacciInRange(i, minIbovespaValue, maxIbovespaValue);
            // Corrigindo o formato para números inteiros e ponto flutuante
            System.out.printf("%6d  | %16d  | %.2f                       | %.2f%n", i, fibonacci(i), fuzzyValueCurrent, fuzzyValueRange);
        }
    }

        // Teste do cálculo do fatorial
        //System.out.println(fatorial(6)); // Saída esperada: 720
    	//recurseMethod(4);
    	//for (int i = 0; i < 10; i++) {
            //System.out.print(fibonacci(i) + " "); // Remove a vírgula e adiciona um espaço para separar os números
    	//for (int i = 0; i < 10; i++) {
            //double fuzzyValue = fuzzyFibonacci(i);
            // Corrigindo o formato para números inteiros e ponto flutuante
           // System.out.printf("Índice %d: Valor Fibonacci = %d, Grau de Pertinência = %.2f%n", i, fibonacci(i), fuzzyValue);
        //}
    //}
    // Método para calcular o fatorial de um número usando recursão
    public static int fatorial(int num) {
        if (num <= 1) {
            return 1; // Caso base: o fatorial de 0 e 1 é 1
        }
        return num * fatorial(num - 1); // Chamada recursiva
    }



    public static int fibonacci(int index) {
        if (index <= 1) {
            return index; // Caso base: retorna o índice (0 ou 1)
        }
        return fibonacci(index - 1) + fibonacci(index - 2); // Chamada recursiva
    }

    // Método para calcular o grau de pertinência fuzzy baseado no número de Fibonacci e valor atual
    public static double fuzzyFibonacci(int index, double maxValue) {
        int fib = fibonacci(index);
        // Normalizar o valor do Fibonacci para um intervalo de 0 a 1 usando o valor atual do IBOVESPA
        return Math.min(fib / maxValue, 1.0); // Grau de pertinência no intervalo [0, 1]
    }

    // Método para calcular o grau de pertinência fuzzy baseado no número de Fibonacci e intervalo do IBOVESPA
    public static double fuzzyFibonacciInRange(int index, double minValue, double maxValue) {
        int fib = fibonacci(index);
        // Normalizar o valor do Fibonacci para um intervalo de 0 a 1 usando o intervalo de variação do IBOVESPA
        if (maxValue > minValue) {
            return Math.min((fib - minValue) / (maxValue - minValue), 1.0); // Grau de pertinência no intervalo [0, 1]
        }
        return 0.0; // Evitar divisão por zero, caso minValue == maxValue
    }
}
       /* 
    // Método para calcular o número de Fibonacci usando recursão
       public static int fibonacci(int index) {
           if (index <= 1) {
               return index; // Caso base: retorna o índice (0 ou 1)
           }
           return fibonacci(index - 1) + fibonacci(index - 2); // Chamada recursiva
       }

       // Método para calcular o grau de pertinência fuzzy baseado no número de Fibonacci
       public static double fuzzyFibonacci(int index) {
           int fib = fibonacci(index);
           // Exemplo de lógica fuzzy: normalizar o valor do Fibonacci para um intervalo de 0 a 1
           // Aqui usamos uma normalização simples dividindo por um valor máximo arbitrário
           double maxFibonacci = 34; // Valor máximo da sequência que estamos considerando
           return Math.min(fib / maxFibonacci, 1.0); // Grau de pertinência no intervalo [0, 1]
       }
   } 
 
       public static int fibonacci(int index) {
           if (index <= 1) {
               return index; // Caso base: retorna o índice (0 ou 1)
           }
           return fibonacci(index - 1) + fibonacci(index - 2); // Chamada recursiva
       }
   }
       
       public static int fibonacci(int index) {
           if (index < 0) {
               throw new IllegalArgumentException("Índice deve ser não-negativo");
           }
           if (index == 0) {
               return 0;
           }
           if (index == 1) {
               return 1;
           }

           int[] fib = new int[index + 1];
           fib[0] = 0;
           fib[1] = 1;

           for (int i = 2; i <= index; i++) {
               fib[i] = fib[i - 1] + fib[i - 2];
           }

           return fib[index];
       }
   }

package section4_3;

public class RecursionExample {

	public static void main(String[] args) {
		// Factorial
     System.out.println(fatorial(6));
	}
	
	public static int fatorial(int num) {
		int result =num;
		for(int i = num-1; i > 0; i--)
	    result *= i;
		return result;
	}
}
*/