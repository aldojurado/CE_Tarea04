import java.util.Scanner;
import java.lang.Math;

public class CE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("1. Problema de coloración");
        System.out.println("2. Problema de codificación");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.println("Ingrese el nombre del archivo: ");
            String rutaIngresada = scanner.next();
            Coloracion coloracion = new Coloracion(rutaIngresada);
            coloracion.busquedaPorEscalada(30);
        } else if (opcion == 2) {
            System.out.println("Seleccione el tipo de optimización:");
            System.out.println("1. Recocido simulado");
            System.out.println("2. Búsqueda aleatoria");
            int tipoOptimizacion = scanner.nextInt();
            System.out.println("Seleccione la función a evaluar:");
            System.out.println("1. fun 1");
            System.out.println("2. fun2");
            System.out.println("3. fun3");
            System.out.println("4. fun3");
            System.out.println("5. fun3");
            int numFun = scanner.nextInt();
            OptimizacionCombinatoria metodoOptimizacion = new OptimizacionCombinatoria();
            metodoOptimizacion.ejecutarAlgoritmo(tipoOptimizacion, numFun);
        } else {
            System.out.println("Opción inválida");
        }
    }

    public static void verificaDatos(String[] args) {

    }

}
