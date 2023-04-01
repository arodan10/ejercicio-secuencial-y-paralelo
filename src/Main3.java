import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) throws IOException {
        /*String rutaUrl = "https://upeu.edu.pe/";
        URL url =  new URL(rutaUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        String resultado = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining());
        System.out.println(resultado);*/
        //System.out.println("Hello world!");

        List<String > rutaUrls = new ArrayList<>();
        rutaUrls.add("https://upeu.edu.pe/");
        rutaUrls.add("https://upeu.edu.pe/fsalud/");
        rutaUrls.add("https://upeu.edu.pe/facihed/educacion-inicial/");
        rutaUrls.add("https://upeu.edu.pe/fia/ingsistemas/");
        rutaUrls.add("https://upeu.edu.pe/fia/industrias-alimentarias/");
        rutaUrls.add("https://upeu.edu.pe/fsalud/psicologia/");
        rutaUrls.add("https://upeu.edu.pe/");
        rutaUrls.add("https://upeu.edu.pe/fsalud/");
        rutaUrls.add("https://upeu.edu.pe/facihed/educacion-inicial/");
        rutaUrls.add("https://upeu.edu.pe/fia/ingsistemas/");
        rutaUrls.add("https://upeu.edu.pe/fia/industrias-alimentarias/");
        rutaUrls.add("https://upeu.edu.pe/fsalud/psicologia/");
        rutaUrls.add("https://upeu.edu.pe/");
        rutaUrls.add("https://upeu.edu.pe/fsalud/");
        rutaUrls.add("https://upeu.edu.pe/facihed/educacion-inicial/");
        rutaUrls.add("https://upeu.edu.pe/fia/ingsistemas/");
        rutaUrls.add("https://upeu.edu.pe/fia/industrias-alimentarias/");
        rutaUrls.add("https://upeu.edu.pe/fsalud/psicologia/");

        long tiempoInicio = System.nanoTime();
        rutaUrls.stream().forEach(s -> obtenerContenidoPagina(s));
        long tiempoFin = System.nanoTime();
        System.out.println();
        System.out.print("Diferencia de tiempo sin programacion paralela "+((tiempoFin-tiempoInicio)/1_000_000_000));

        tiempoInicio = System.nanoTime();
        rutaUrls.stream().parallel().forEach(s -> obtenerContenidoPagina(s));
        tiempoFin = System.nanoTime();
        System.out.println();
        System.out.print("Diferencia de tiempo con programacion paralela "+((tiempoFin-tiempoInicio)/1_000_000_000));
    }
    private static String obtenerContenidoPagina(String rutaUrl){
        try {
            URL url =  new URL(rutaUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream =httpURLConnection.getInputStream();
            Stream<String> lineas = new BufferedReader(new InputStreamReader(inputStream)).lines();
            return  lineas.collect(Collectors.joining());
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        return "";


    }

}