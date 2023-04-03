import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Producto {
    String codigoBarras;
    int stock;

    public Producto(String codigoBarras, int stock) {
        this.codigoBarras = codigoBarras;
        this.stock = stock;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public int getStock() {
        return stock;
    }
}

public class Inventario {

    public static void main(String[] args) {
        // Creamos una lista de productos de ejemplo
        // List<Producto> productos = new ArrayList<>();
        // productos.add(new Producto("123456789", 100));
        // productos.add(new Producto("234567890", 50));
        // productos.add(new Producto("345678901", 200));
        // productos.add(new Producto("456789012", 75));
        // productos.add(new Producto("567890123", 300));
        List<Producto> productos = new ArrayList<>();
        for (int i = 1; i < 27000000; i++) {
            productos.add(new Producto(String.valueOf(i), i));
        }

        // Tarea secuencial: obtener una lista de los códigos de barras de los productos con stock bajo
        int stockMinimo = 1000;
        long startTimeSecuencial = System.currentTimeMillis();
        List<String> codigosBarrasSecuencial = productos.stream()
                .filter(producto -> producto.getStock() < stockMinimo)
                .map(producto -> producto.getCodigoBarras())
                .collect(Collectors.toList());
        long endTimeSecuencial = System.currentTimeMillis();
        long timeElapsedSecuencial = endTimeSecuencial - startTimeSecuencial;
        //System.out.println("Productos con stock inferior a " + stockMinimo + ": " + codigosBarrasSecuencial);
        System.out.println("Tiempo de ejecución (secuencial): " + timeElapsedSecuencial + " milisegundos");

        // Tarea paralela: obtener una lista de los códigos de barras de los productos con stock bajo en paralelo
        long startTimeParalelo = System.currentTimeMillis();
        List<String> codigosBarrasParalelo = productos.parallelStream()
                .filter(producto -> producto.getStock() < stockMinimo)
                .map(producto -> producto.getCodigoBarras())
                .collect(Collectors.toList());
        long endTimeParalelo = System.currentTimeMillis();
        long timeElapsedParalelo = endTimeParalelo - startTimeParalelo;
        //System.out.println("Productos con stock inferior a " + stockMinimo + " (en paralelo): " + codigosBarrasParalelo);
        System.out.println("Tiempo de ejecución (paralelo): " + timeElapsedParalelo + " milisegundos");
    }
}

