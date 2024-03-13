public class BusquedaAleatoria {
    final int NBITS = 22;
    final int ITER = 1000000;

    public double[] busquedaAleatoria(int numFun, int dimension) {
        Binario binario = new Binario();
        Evaluador evaluador = new Evaluador();
        double[] res = new double[dimension];
        double[] intervalo = intervalo(numFun);
        double mejorValor = Double.MAX_VALUE;
        double peorValor = Double.MIN_VALUE;
        double promedio = 0;
        double[] mejorSol = new double[dimension];
        for (int i = 0; i < ITER; i++) {
            int[] solucionBinaria = binario.generaSolucionAleatoria(NBITS * dimension);
            double[] solucion = binario.decodifica(solucionBinaria, NBITS, intervalo[0], intervalo[1]);
            double valor = evaluador.evaluaEn(numFun, solucion);
            if (valor < mejorValor) {
                mejorValor = valor;
                mejorSol = solucion;
                res = solucion;
            } else if (valor > peorValor) {
                peorValor = valor;
            }
            promedio += valor;
        }
        System.out.println("Mejor valor: " + mejorValor);
        System.out.println("Peor valor: " + peorValor);
        System.out.println("Promedio: " + promedio / ITER);
        System.out.println("Mejor solución: ");
        for (int i = 0; i < mejorSol.length; i++) {
            System.out.println("x" + i + ": " + mejorSol[i] + "  ");
        }
        return res;

    }

    private double[] intervalo(int numFun) {
        double[] res = new double[2];
        if (numFun == 1 || numFun == 4) {
            res[0] = -5.12;
            res[1] = 5.12;
        } else if (numFun == 2) {
            res[0] = -30;
            res[1] = 30;
        } else if (numFun == 3) {
            res[0] = -600;
            res[1] = 600;
        } else {
            res[0] = -2.048;
            res[1] = 2.048;

        }
        return res;
    }

}
