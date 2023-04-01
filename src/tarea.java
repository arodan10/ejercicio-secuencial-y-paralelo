import java.util.stream.IntStream;

public class tarea {
    public static void main(String[] args) {
        int maximoNumero = 10000000;

        long inicioTiempo = System.currentTimeMillis();
        int[] primosecuencial = findPrimesSequential(maximoNumero);
        long finTiempo = System.currentTimeMillis();
        long timeElapsedSequential = finTiempo - inicioTiempo;
        System.out.println("Tiempo Secuencial: " + timeElapsedSequential + " milissegundos");
        
        inicioTiempo = System.currentTimeMillis();
        int[] primoparalelo = findPrimesParallel(maximoNumero);
        finTiempo = System.currentTimeMillis();
        long timeElapsedParallel = finTiempo - inicioTiempo;
        System.out.println("Tiempo Pararelo: " + timeElapsedParallel + " milisegundos");
    }

    /*public static int[] findPrimesSequential(int maximoNumero) {
        int[] primos = IntStream.rangeClosed(2, maximoNumero)
                .filter(tarea::primo)
                .toArray();
        for(int primo : primos) {
            System.out.print(primo + " ");
        }
        return primos;
    }

    public static int[] findPrimesParallel(int maximoNumero) {
        int[] primos = IntStream.rangeClosed(2, maximoNumero)
                .parallel()
                .filter(tarea::primo)
                .toArray();
        for(int primo : primos) {
            System.out.print(primo + " ");
        }
        return primos;
    }*/

    public static int[] findPrimesSequential(int maximoNumero) {
        return IntStream.rangeClosed(2, maximoNumero)
                .filter(tarea::primo)
                .toArray();
    }

    public static int[] findPrimesParallel(int maximoNumero) {
        return IntStream.rangeClosed(2, maximoNumero)
                .parallel()
                .filter(tarea::primo)
                .toArray();
    }


    public static boolean primo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
