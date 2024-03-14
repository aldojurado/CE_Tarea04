import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OptimizacionCombinatoria {

    public void ejecutarAlgoritmo(int optimización, int numFun, int dimension) {
        Evaluador evaluador = new Evaluador();
        if (optimización == 1) {
            // Recocido simulado
            Recocido recocido = new Recocido();

            for (int i = 0; i < 10; i++) {
                double[] res = recocido.recocido(numFun, dimension);
                double valor = evaluador.evaluaEn(numFun, res);
                guardarSolucion(res, valor, numFun, i, dimension, "solRecocido");
            }
        } else if (optimización == 2) {
            // Búsqueda aleatoria
            BusquedaAleatoria busquedaAleatoria = new BusquedaAleatoria();
            for (int i = 0; i < 10; i++) {
                double[] res = busquedaAleatoria.busquedaAleatoria(numFun, dimension);
                double valor = evaluador.evaluaEn(numFun, res);
                guardarSolucion(res, valor, numFun, i, dimension, "solAleatoria");
            }

        }
    }

    private void guardarSolucion(double[] res, double valor, int numFun, int index, int dimension,
            String optimizacion) {
        String solucion = "Solución: [";

        // Nombre del archivo donde se guardará el texto
        String nombFun = nombreFuncion(numFun);
        String nombreArchivo = "src/output/solucionesContinuas/" + optimizacion + "_" + nombFun + "_D" + index + ".txt";
        for (int i = 0; i < res.length; i++) {
            solucion += res[i];
            if (i < res.length - 1) {
                solucion += ", ";
            }
        }
        solucion += "]";

        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir la cadena en el archivo
            bufferedWriter.write("Dimensión: " + dimension);
            bufferedWriter.newLine();
            bufferedWriter.write(solucion);
            bufferedWriter.newLine();
            bufferedWriter.write("Evaluación de la solución: " + valor);

            // Cerrar el BufferedWriter
            bufferedWriter.close();

            System.out.println("Texto guardado en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private String nombreFuncion(int numFun) {
        String nombre = "";
        switch (numFun) {
            case 1:
                nombre = "Sphere";
                break;
            case 2:
                nombre = "Ackley";
                break;
            case 3:
                nombre = "Griewank";
                break;
            case 4:
                nombre = "Rastrigin";
                break;
            case 5:
                nombre = "Rosenbrock";
                break;
            case 6:
                nombre = "SumSquare";
                break;
            case 7:
                nombre = "StyblinskiTang";
                break;
            case 8:
                nombre = "DixonPrice";
                break;
            default:
                nombre = "desconocida";
                break;
        }
        return nombre;
    }

}
