import java.util.Scanner;

public class CE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("1. Problema de coloración BLI");
        System.out.println("2. Problema de codificación");
        int opcion = escaneaNum(2);
        if (opcion == 1) {
            System.out.println("Ingrese el nombre del archivo: ");
            String rutaIngresada = scanner.next();
            Coloracion coloracion = new Coloracion(rutaIngresada);
            //Es posible cambiar el critero de término de ambas búsquedas, en este caso BLI 100 iteraciones y BE 50 iteraciones.
            coloracion.busquedaLocalIterada(100,50);
        } else if (opcion == 2) {
            System.out.println("Seleccione el tipo de optimización:");
            System.out.println("1. Recocido simulado");
            System.out.println("2. Búsqueda aleatoria");
            int tipoOptimizacion = escaneaNum(2);
            System.out.println("Seleccione la función a evaluar:");
            System.out.println("1. Sphere Function");
            System.out.println("2. Ackley Function");
            System.out.println("3. Griewank Function");
            System.out.println("4. Rastrigin Function");
            System.out.println("5. Rosenbrock Function");
            System.out.println("6. Sum Square Function");
            System.out.println("7. Styblinski-Tang Function");
            System.out.println("8. Dixon-Price Function");
            int numFun = escaneaNum(8);

            System.out.println("Ingrese la dimensión:");
            int dimension = escaneaNum(50);

            OptimizacionCombinatoria metodoOptimizacion = new OptimizacionCombinatoria();
            metodoOptimizacion.ejecutarAlgoritmo(tipoOptimizacion, numFun, dimension);
        } else {
            System.out.println("Opción inválida");
        }
    }

    public static int escaneaNum(int max) {
        int res = Integer.MAX_VALUE;

        while (res == Integer.MAX_VALUE) {
            Scanner scanner = new Scanner(System.in);
            try {
                int num = scanner.nextInt();
                if (num < 1 || num > max) {
                    res = Integer.MAX_VALUE;
                    System.out.println("Ingrese un índice válido:");
                } else {
                    res = num;
                }
            } catch (Exception e) {
                System.out.println("Se debe ingresar un número entero");
                res = Integer.MAX_VALUE;
                System.out.println("Ingrese un entero:");
            }

        }
        return res;
    }

}
