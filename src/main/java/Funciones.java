import java.lang.Math;

public class Funciones {

    public int[] codifica_aux(int n, int nBit) {
        int[] res = new int[nBit];
        if (Math.pow(2, nBit) > n) {
            String bin = Integer.toBinaryString(n);
            for (int i = 0; i < nBit; i++) {
                if (i < nBit - bin.length()) {
                    res[nBit - 1 - i] = 0;
                } else {
                    res[nBit - 1 - i] = Integer.parseInt(String.valueOf(bin.charAt(i - (nBit - bin.length()))));
                }
            }
        } else {
            throw new IllegalArgumentException(
                    "El número " + n + " no se puede codificar con " + nBit + " bits.");
        }
        return res;
    }

    public int[] codifica(double x, int nBits, double a, double b) {
        int[] res = new int[nBits];
        double valoresInte = b - a;
        x = x - a;
        double pres = valoresInte / (Math.pow(2, nBits) - 1);
        double valor = x / pres;
        res = codifica_aux((int) valor, nBits);
        return res;
    }

    public double decodifica(int x_cod[], double a, double b) {
        double decimal = decdifica_aux(x_cod);
        double pres = (b - a) / (Math.pow(2, x_cod.length) - 1);
        decimal = decimal * pres + a;
        return decimal;
    }

    public double decdifica_aux(int x_cod[]) {
        double decimal = 0;
        for (int i = 0; i < x_cod.length; i++) {
            decimal += x_cod[i] * Math.pow(2, i);
        }
        return decimal;

    }

    public int[] codifica(double x[], int nBits, double a, double b) {
        int res[] = new int[x.length * nBits];
        for (int i = 0; i < x.length; i++) {
            int[] aux = codifica(x[i], nBits, a, b);
            for (int j = 0; j < nBits; j++) {
                res[i * nBits + j] = aux[j];
            }
        }
        return res;
    }

    public double[] decodifica(int x_cod[], int nBits, double a, double b) {
        double[] res = new double[x_cod.length / nBits];
        for (int i = 0; i < res.length; i++) {
            int[] aux = new int[nBits];
            for (int j = 0; j < nBits; j++) {
                aux[j] = x_cod[i * nBits + j];
            }
            res[i] = decodifica(aux, a, b);
        }
        return res;
    }
}
