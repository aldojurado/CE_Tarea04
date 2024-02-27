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
            System.out.println("Ingrese la ruta del archivo .col:");
            String rutaIngresada = scanner.next();
            Coloracion coloracion = new Coloracion(rutaIngresada);
            coloracion.busquedaPorEscalada();
        } else if (opcion == 2) {
            Funciones f = new Funciones();
            double x = 18.3;
            double a = 15.2;
            double b = 31.3;
            int nBits = 10;
            System.out.println("El número a codificar es " + x);
            int[] res = f.codifica(x, nBits, a, b);

            double decodificado = f.decodifica(res, a, b);
            System.out.println("\nEl número decodificado es " + decodificado);
        } else {
            System.out.println("Opción inválida");
        }
    }

    public static void verificaDatos(String[] args) {

    }

}
