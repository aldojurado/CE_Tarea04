
public class AG {
    final int NBITS = 22;
    final int MAXITER = 2;

    public double[] algoritmoGenetico(int numFun, int tamPoblacion, int seed, double probCruza, double probMutacion,
            int dimension) {
        // Inicializar población
        Poblacion p = new Poblacion(tamPoblacion, NBITS, seed, dimension, numFun);

        // evaluar población
        p.evaluarPoblacion();
        int iteracion = 0;
        while (iteracion < MAXITER) {
            iteracion++;
            // 1.-Selección de padres por ruleta
<<<<<<< HEAD
            Poblacion padres = p.clone();
            padres.seleccionarPadres();
=======
            p.seleccionarPadres();
>>>>>>> b7eb6cf98d4a3848f7137b9585311130980aa871

            // 2.-Recombinación, cruz a de un punto con probabilidad probCruza 0.7 sugerido

            /*
             * 3.-Mutación, intercambio 1 bit con probabilidad probMutacion
             * 1/(popsize*dimension*NBITS) sugerido
             */

            // 4.-Reemplazo generacional
        }
        return p.mejor();
    }

}
