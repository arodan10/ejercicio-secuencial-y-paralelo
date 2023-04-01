import java.util.Random;
import java.util.stream.IntStream;

public class prueba {
    public static void main(String[] args) {

        // Crear un conjunto de números aleatorios
        int[] numeros = new Random().ints(10000000).toArray();

        // Calcular la suma secuencialmente
        long inicioSecuencial = System.currentTimeMillis();
        int sumaSecuencial = 0;
        for (int i = 0; i < numeros.length; i++) {
            sumaSecuencial += numeros[i];
        }
        long finSecuencial = System.currentTimeMillis();
        System.out.println("Suma secuencial: " + sumaSecuencial + " en " + (finSecuencial - inicioSecuencial) + " milisegundos");

        // Calcular la suma en paralelo
        long inicioParalelo = System.currentTimeMillis();
        int sumaParalela = IntStream.of(numeros).parallel().sum();
        long finParalelo = System.currentTimeMillis();
        System.out.println("Suma paralela: " + sumaParalela + " en " + (finParalelo - inicioParalelo) + " milisegundos");
    }
}
