import java.lang.Math;

public class Funciones {

    public double sumSquare(double[] valores) {
        double res = 0;
        for (int i = 0; i < valores.length; i++) {
            res += (i + 1) * Math.pow(valores[i], 2);
        }
        return res;
    }

    public double StyblinskiTang(double[] x) {
        double res = 0;
        for (int i = 0; i < x.length; i++) {
            res += Math.pow(x[i], 4) - 16 * Math.pow(x[i], 2) + 5 * x[i];
        }
        return res / 2;
    }

    public double dixonPrice(double[] x) {
        double res = Math.pow(x[0] - 1, 2);
        for (int i = 1; i < x.length; i++) {
            res += (i + 1) * Math.pow(2 * Math.pow(x[i], 2) - x[i - 1], 2);
        }
        return res;
    }

}
