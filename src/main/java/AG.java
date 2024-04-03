
public class AG {
    final int NBITS = 22;
    final int MAXITER = 1000;

    public double[] algoritmoGenetico(int numFun, int tamPoblacion, int seed, double probCruza, double probMutacion,
            int dimension) {
        // Inicializar población
        Poblacion p = new Poblacion(tamPoblacion, NBITS, seed, dimension);

        // evaluar población
        p.evaluarPoblacion(numFun);
        int iteracion = 0;
        while (iteracion < MAXITER) {
            // 1.-Selección de padres por ruleta

            // 2.-Recombinación, cruz a de un punto con probabilidad probCruza

            // 3.-Mutación, intercambio 1 bit con probabilidad probMutacion

            // 4.-Reemplazo generacional
        }
        return null;
    }

}
