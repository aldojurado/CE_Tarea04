import java.lang.Math;

public class CE {

    public static void main(String[] args) {
        Funciones f = new Funciones();
        double x = 18.3;
        double a = 15.2;
        double b = 31.3;
        int nBits = 10;
        System.out.println("El número a codificar es " + x);
        int[] res = f.codifica(x, nBits, a, b);

        double decodifcado = f.decodifica(res, a, b);
        System.out.println("\n El número decodificado es " + decodifcado);
        /*
         * int n = 5;
         * int nBit = 2;
         * int[] res = f.codifica_aux(n, nBit);
         * for (int i = 0; i < res.length; i++) {
         * System.out.print(res[i]);
         * }
         */
    }

    public static void verificaDatos(String[] args) {

    }

}
