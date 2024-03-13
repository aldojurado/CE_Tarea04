public class OptimizacionCombinatoria {

    public void ejecutarAlgoritmo(int optimización, int numFun) {
        if (optimización == 1) {
            // Recocido simulado
        } else if (optimización == 2) {
            // Búsqueda aleatoria
            Evaluador evaluador = new Evaluador();
            double[] res = evaluador.evaluaAleatorio(numFun, 5, 1000000);
            for (double d : res) {
                System.out.println(d);
            }
        }
    }

}
