public class Recocido {

    final int NBITS = 22;
    final int MAXITER = 1000000;

    public double[] recocido(int numFun, int dimension) {
        Binario bin = new Binario();
        Evaluador eval = new Evaluador();
        double[] res = new double[dimension];
        double[] intervalo = eval.intervalo(numFun);
        int[] solucion = bin.generaSolucionAleatoria(NBITS * dimension);
        double temp = 1000;
        int numIt = 0;
        while (numIt < MAXITER && temp > 0.0001) {
            numIt++;

            // seleccionamos un vecino
            int[] vecino = bin.vecinoRnd(solucion);
            double[] valores = evaluaBin(solucion, vecino, numFun, intervalo);
            if (valores[1] < valores[0]) {
                solucion = vecino;
            } else {
                double proba = Math.exp((valores[0] - valores[1]) / temp);
                if (Math.random() < proba) {
                    solucion = vecino;
                }
            }

            // bajamos la temperatura

        }
        return res;
    }

    private double[] evaluaBin(int[] solucion, int[] vecino, int numFun, double[] intervalo) {
        Evaluador evaluador = new Evaluador();
        Binario binario = new Binario();

        double[] solucionAct = binario.decodifica(solucion, NBITS, intervalo[0], intervalo[1]);
        double valorAct = evaluador.evaluaEn(numFun, solucionAct);

        double[] solucionVec = binario.decodifica(vecino, NBITS, intervalo[0], intervalo[1]);
        double valorVec = evaluador.evaluaEn(numFun, solucionVec);
        return new double[] { valorAct, valorVec };
    }

}
