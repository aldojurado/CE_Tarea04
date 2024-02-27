import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Coloracion{

    // Representación del problema con matriz de adyacencia
    private int[][] matrizAdyacencia;

    // Colores disponibles. Su finalidad es hacer el resultado final más amigable para el usuario.
    private String[] colores = {
        "Rojo", "Verde", "Azul", "Amarillo", "Naranja", "Morado", "Rosa", "Gris", 
        "Negro", "Blanco", "Turquesa", "Magenta", "Lima", "Cian", "Lavanda", 
        "Radioactivo", "Coral", "Beige", "Menta", "Azul Marino"
    };
    
    // Almacena el número de vértices del archivo ingresado para crear las matrices
    private int numVertices;
    
    // Almacena la ruta del archivo ingresada para devolver la solución
    String rutaArchivo = "";


    /**
     * Constructor de la clase Coloracion
     * Guarda la ruta ingresada en rutaArchivo y lee el archivo
     */
    public Coloracion(String rutaIngresada){
        rutaArchivo = rutaIngresada;
        leeArchivo(rutaIngresada);
    }
    
    /**
     * Getter de la clase Coloracion
     * Devuelve la ruta del archivo ingresada
     */
    public String getRuta(){
        return rutaArchivo;
    }

    /**
     * Regresa el color asignado al número ingresado como parámetro
     * @param numero El número del color
     * @return El color asignado al número
     */
    private String getColor(int numero){
        //Idealmente siempre hay colores disponibles, para fines de la tarea no debe haber problema. 
        return colores[numero - 1];  
    }

    /**
     * Lee el archivo .col ingresado y almacena la información en la matriz de adyacencia.
     * @param rutaIngresada Ruta del archivo .col
     */
    private void leeArchivo(String rutaIngresada){
        
        try(BufferedReader br = new BufferedReader(new FileReader(rutaIngresada))){
            String linea;

            while((linea = br.readLine()) != null){
                //Comentarios
                if(linea.startsWith("c")){
                    continue; 
                //Número de vértices y aristas 
                }else if(linea.startsWith("p edge")){
                    String[] partes = linea.split(" ");
                    numVertices = Integer.parseInt(partes[2]);
                    //Creamos la matriz de adyacencia con el número de vértices
                    matrizAdyacencia = new int[numVertices][numVertices];
                //Las adyacencias de los vértices
                }else if(linea.startsWith("e")){
                    String[] partes = linea.split(" ");
                    //Le restamos uno a los vértices para que se representen correctamente en la matriz que comienza en 0
                    int v1 = Integer.parseInt(partes[1]) - 1;
                    int v2 = Integer.parseInt(partes[2]) - 1;
                    //Nos informa que son adyacentes, por lo que asignamos 1 en la matriz. 
                    matrizAdyacencia[v1][v2] = 1;
                    matrizAdyacencia[v2][v1] = 1;
                }else{
                    throw new RuntimeException("Esquema de codificación incorrecto en el archivo .col ingresado");
                }
            }
        }catch (IOException e){
            throw new RuntimeException("No se ha podido leer el archivo ingresado.", e);
        }
    }

    /**
     * Escribe la solución en un archivo de salida.
     * 
     * @param solucion Un arreglo de enteros que indican los colores de la solución
     * @param iteraciones El número de iteraciones con mejora
     * @param tolerancia El número de iteraciones sin mejora
     */
    private void escribeSolucion(int[] solucion, int iteraciones, int tolerancia){
        // El nombre del archivo de salida es la ruta del archivo de entrada con un identificador "_solucion" al final.
        String nombreArchivoSalida = getRuta().replace(".col", "_solucion.col");

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivoSalida))) {
            writer.println("Solución más optimizada encontrada después de " + iteraciones + " iteraciones y " + tolerancia + " iteraciones sin mejora.");

            for (int vertice = 0; vertice < solucion.length; vertice++) {
                writer.println("Vértice " + (vertice + 1) + ": " + getColor(solucion[vertice]));
            }
            writer.println("Total de colores utilizados: " + evaluarSolucion(solucion) + "\n");
            writer.println("Solución en formato Arreglo de valores discretos: " + java.util.Arrays.toString(solucion));

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Genera una solución aleatoria válida, asigna un color distinto a cada vértice adyacente. 
     * @return Un arreglo de enteros que representan colores con la solución aleatoria.
     */
    private int[] solucionAleatoria(){

        int[] solucion = new int[numVertices];
        Random r = new Random();
        //Recorremos la matriz de adyacencia
        for (int i = 0; i < numVertices; i++){

            //Registramos los colores ya utilizados en un arreglo de  (true) 
            boolean[] coloresUsados = new boolean[numVertices + 1];

            for (int j = 0; j < numVertices; j++) {
                //Si son adyacentes y j ya está coloreado, se marca el color como utilizado (true)
                if (matrizAdyacencia[i][j] == 1 && solucion[j] != 0) {
                    coloresUsados[solucion[j]] = true;
                }
            }
            //Genera un color aleatorio que no esté prohibido y lo asigna al vértice i
            int color;
            do {
                color = 1 + r.nextInt(numVertices);
            } while (coloresUsados[color]);
            solucion[i] = color;
        
        }
        return solucion;
    }

    /**
     * Evalúa la solución ingresada, cuenta cuántos colores son utilizados para colorear la gráfica.
     * @param solucion Un arreglo de enteros que representan colores con la solución
     * @return El número de colores utilizados
     */
    private int evaluarSolucion(int[] solucion){
        boolean[] coloresUsados = new boolean[numVertices + 1];
        int totalColores = 0;
        //Itera sobre la solución, marca los colores ya utilizados y los cuenta
        for (int color : solucion) {
            if (!coloresUsados[color]) {
                coloresUsados[color] = true;
                totalColores++;
            }
        }
        return totalColores;
    }

    private int[] generarSolucionVecina(int[] solucionActual) {
        Random rand = new Random();
        int[] nuevaSolucion = solucionActual.clone();
        int vertice = rand.nextInt(numVertices);
    
        // Contar la frecuencia de cada color en la solución actual.
        int[] frecuenciaColores = new int[numVertices + 1];
        for (int color : solucionActual) {
            if (color != 0) { // Asumiendo que 0 no es un color válido.
                frecuenciaColores[color]++;
            }
        }
    
        // Identificar los colores prohibidos para el vértice seleccionado.
        boolean[] coloresProhibidos = new boolean[numVertices + 1];
        for (int j = 0; j < numVertices; j++) {
            if (matrizAdyacencia[vertice][j] == 1) {
                coloresProhibidos[solucionActual[j]] = true;
            }
        }
    
        // Buscar el color más frecuente que no esté prohibido para este vértice.
        int colorSeleccionado = 0;
        int maxFrecuencia = 0;
        for (int color = 1; color <= numVertices; color++) {
            if (!coloresProhibidos[color] && frecuenciaColores[color] > maxFrecuencia) {
                colorSeleccionado = color;
                maxFrecuencia = frecuenciaColores[color];
            }
        }
    
        // Si se encontró un color válido, asignarlo al vértice.
        if (colorSeleccionado != 0) {
            nuevaSolucion[vertice] = colorSeleccionado;
        } else {
            // Si no, asignar un color al azar que no esté prohibido (enfoque de respaldo).
            do {
                colorSeleccionado = 1 + rand.nextInt(numVertices);
            } while (coloresProhibidos[colorSeleccionado]);
            nuevaSolucion[vertice] = colorSeleccionado;
        }
    
        return nuevaSolucion;
    }
    
    

    public void busquedaPorEscalada() {
        int iteraciones = 0;
        int[] solucionActual = solucionAleatoria();
        int evaluacionActual = evaluarSolucion(solucionActual);

        int tolerancia = 0;
        while (tolerancia < 30) {
            int[] solucionVecina = generarSolucionVecina(solucionActual);
            int evaluacionVecina = evaluarSolucion(solucionVecina);

            if (evaluacionVecina < evaluacionActual) {
                solucionActual = solucionVecina;
                evaluacionActual = evaluacionVecina;
                iteraciones++;
            } else {
                tolerancia++;
            }
        }

        escribeSolucion(solucionActual, iteraciones, tolerancia);
    }

    

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Es necesario ingresar la ruta del archivo .col como argumento.");
            return;
        }

        String rutaIngresada = args[0];
        Coloracion coloracion = new Coloracion(rutaIngresada);
        coloracion.busquedaPorEscalada();
    }
}
