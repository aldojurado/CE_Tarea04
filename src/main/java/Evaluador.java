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
        double[] res = new double[d + 3];
        double[] mejor = new double[d];
        double mejorD = 10000.0;
        double peorD = 0;
        double actualD;
        double promedio = 0;
        double[] actual = new double[d];

        Random random = new Random();
        double valorAleatorio;
        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < d; j++) {
                valorAleatorio = random.nextDouble() * 20 - 10;
                actual[j] = valorAleatorio;
            }
            actualD = evaluaEn(3, actual);
            promedio += actualD;
            if (i == 0) {
                mejorD = actualD;
                peorD = actualD;
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
                if (actualD > peorD) {
                    peorD = actualD;
                }
            }

        }
        res[d] = mejorD;
        res[d + 1] = peorD;
        res[d + 2] = promedio / iter;
        for (int i = 0; i < d; i++) {
            res[i] = mejor[i];

        }
        return res;
    }

    private double[] aleatorioDixonPrice(int d, int iter) {
        double[] res = new double[d + 3];
        double[] mejor = new double[d];
        double mejorD = 10000.0;
        double peorD = 0;
        double actualD;
        double promedio = 0;
        double[] actual = new double[d];

        Random random = new Random();
        double valorAleatorio;
        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < d; j++) {
                valorAleatorio = random.nextDouble() * 20 - 10;
                actual[j] = valorAleatorio;
            }
            actualD = evaluaEn(2, actual);
            promedio += actualD;
            if (i == 0) {
                mejorD = actualD;
                peorD = actualD;
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
                if (actualD > peorD) {
                    peorD = actualD;
                }
            }

        }
        res[d] = mejorD;
        res[d + 1] = peorD;
        res[d + 2] = promedio / iter;
        for (int i = 0; i < d; i++) {
            res[i] = mejor[i];

        }
        return res;
    }

    private double[] aleatorioSumSquare(int d, int iter) {
        double[] res = new double[d + 3];
        double[] mejor = new double[d];
        double mejorD = 10000.0;
        double peorD = 0;
        double actualD;
        double promedio = 0;
        double[] actual = new double[d];

        Random random = new Random();
        double valorAleatorio;
        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < d; j++) {
                valorAleatorio = random.nextDouble() * 20 - 10;
                actual[j] = valorAleatorio;
            }
            actualD = evaluaEn(1, actual);
            promedio += actualD;
            if (i == 0) {
                mejorD = actualD;
                peorD = actualD;
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
                if (actualD > peorD) {
                    peorD = actualD;
                }
            }

        }
        res[d] = mejorD;
        res[d + 1] = peorD;
        res[d + 2] = promedio / iter;
        for (int i = 0; i < d; i++) {
            res[i] = mejor[i];

        }
        return res;
    }

}
