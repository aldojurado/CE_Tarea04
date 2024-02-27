import java.lang.Math;

public class Funciones {

    public int[] codifica_aux(int n, int nBit) {
        int[] res = new int[nBit];
        if (Math.pow(2, nBit) > n) {
            String bin = Integer.toBinaryString(n);
            for (int i = 0; i < nBit; i++) {
                if (i < nBit - bin.length()) {
                    res[i] = 0;
                } else {
                    res[i] = Integer.parseInt(String.valueOf(bin.charAt(i - (nBit - bin.length()))));
                }
            }
        } else {
            throw new IllegalArgumentException("El número " + n + " no se puede codificar con " + nBit + " bits.");
        }

        return res;
    }

    public int[] codifica(double x, int nBits, double a, double b) {
        int[] res = new int[nBits];
        double valoresInte = b - a;
        x = x - a;
        double pres = valoresInte / (Math.pow(2, nBits) - 1);
        double valor = x / pres;
        if (Math.pow(2, nBits) > valor) {
            String bin = Integer.toBinaryString((int) valor);
            for (int i = 0; i < nBits; i++) {
                if (i < nBits - bin.length()) {
                    res[nBits - 1 - i] = 0;
                } else {
                    res[nBits - 1 - i] = Integer.parseInt(String.valueOf(bin.charAt(i - (nBits - bin.length()))));
                }
            }
        } else {
            throw new IllegalArgumentException(
                    "El número " + (int) valor + " no se puede codificar con " + nBits + " bits.");
        }
        return res;
    }

    public double decodifica(int x_cod[], double a, double b) {
        double decimal = 0;
        for (int i = 0; i < x_cod.length; i++) {
            decimal += x_cod[i] * Math.pow(2, i);
        }
        double pres = (b - a) / (Math.pow(2, x_cod.length) - 1);
        decimal = decimal * pres + a;
        return decimal;
    }

}
