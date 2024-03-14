public class Recocido {

    final int NBITS = 22;
    final int MAXITER = 100000;

    public double[] recocido(int numFun, int dimension) {
        Binario bin = new Binario();
        Evaluador eval = new Evaluador();
        double[] intervalo = eval.intervalo(numFun);

        // solución inicial
        int[] solucion = bin.generaSolucionAleatoria(NBITS * dimension);
        double temp = 10000;
        int numIt = 0;

        while (numIt < MAXITER && temp > 0) {
            numIt++;

            // seleccionamos un vecino
            int[] vecino = bin.vecinoRnd(solucion);
            double[] valores = evaluaBin(solucion, vecino, numFun, intervalo);
            if (valores[1] < valores[0]) {
                solucion = vecino;
            } else {
                double proba = Math.exp((valores[0] - valores[1]) / temp);
                double rnd = Math.random();
                System.out.println("Proba: " + proba + " Rnd: " + rnd);
                if (rnd < proba) {
                    solucion = vecino;
                }
            }
            temp = temp * 0.999;

        }
        return bin.decodifica(solucion, NBITS, intervalo[0], intervalo[1]);
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
