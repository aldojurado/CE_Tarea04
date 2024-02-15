import java.util.Random;

public class Evaluador {

    public double evaluaEn(int k, double[] valores) {
        Funciones funciones = new Funciones();
        switch (k) {
            case 1:
                return funciones.sumSquare(valores);
            case 2:
                return funciones.dixonPrice(valores);
            case 3:
                return funciones.StyblinskiTang(valores);
        }
        return 11111111111.0;
    }

    public double[] evaluaAleatorio(int k, int d, int iter) {
        switch (k) {
            case 1:
                return aleatorioSumSquare(d, iter);
            case 2:
                return aleatorioDixonPrice(d, iter);
            case 3:
                return aleatorioStyblinskiTang(d, iter);
        }
        return null;
    }

    private double[] aleatorioStyblinskiTang(int d, int iter) {
        double[] mejor = { 1 };
        for (int i = 0; i < iter; i++) {

        }
        return mejor;
    }

    private double[] aleatorioDixonPrice(int d, int iter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aleatorioDixonPrice'");
    }

    private double[] aleatorioSumSquare(int d, int iter) {
        double[] mejor = new double[d];
        double mejorD = 10000.0;
        double peor;
        double actualD;
        double[] promedio = new double[d];
        double[] actual = new double[d];

        Random random = new Random();
        double valorAleatorio;
        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < d; j++) {
                valorAleatorio = random.nextDouble() * 20 - 10;
                actual[j] = valorAleatorio;
            }
            actualD = evaluaEn(1, actual);
            if (i == 0) {
                mejorD = actualD;
                for (int j = 0; j < d; j++) {
                    mejor[j] = actual[j];
                }
            } else {
                if (actualD < mejorD) {
                    mejorD = actualD;
                    for (int j = 0; j < d; j++) {
                        mejor[j] = actual[j];
                    }
                }
            }

        }
        return mejor;
    }

}
