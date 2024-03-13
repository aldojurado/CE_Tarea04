public class BusquedaAleatoria {
    final int NBITS = 22;
    final int ITER = 1000000;

    public double[] busquedaAleatoria(int numFun, int dimension) {
        Binario binario = new Binario();
        Evaluador evaluador = new Evaluador();
        double[] res = new double[dimension];
        double[] intervalo = evaluador.intervalo(numFun);
        double mejorValor = Double.MAX_VALUE;
        double peorValor = Double.MIN_VALUE;
        double promedio = 0;
        for (int i = 0; i < ITER; i++) {
            int[] solucionBinaria = binario.generaSolucionAleatoria(NBITS * dimension);
            double[] solucion = binario.decodifica(solucionBinaria, NBITS, intervalo[0], intervalo[1]);
            double valor = evaluador.evaluaEn(numFun, solucion);
            if (valor < mejorValor) {
                mejorValor = valor;
                res = solucion;
            } else if (valor > peorValor) {
                peorValor = valor;
            }
            promedio += valor;
        }
        System.out.println("Mejor valor: " + mejorValor);
        System.out.println("Peor valor: " + peorValor);
        System.out.println("Promedio: " + promedio / ITER);
        return res;

    }

}
