
public class AG {
    final int NBITS = 22;
    final int MAXITER = 10000;

    public double[] algoritmoGenetico(int numFun, int tamPoblacion, int seed, double probCruza, double probMutacion,
            int dimension) {
        // Inicializar población
        Poblacion p = new Poblacion(tamPoblacion, NBITS, seed, dimension, numFun);

        // evaluar población

        int iteracion = 0;
        while (iteracion < MAXITER) {
            p.evaluarPoblacion();
            // p.imprimeMejor();
            // System.out.println(p);
            iteracion++;
            // 1.-Selección de padres por ruleta
            Poblacion hijos = p.clone();
            // 2.-Recombinación, cruz a de un punto con probabilidad probCruza 0.7 sugerido
            hijos.seleccionarPadresRecombinar(probCruza);

            /*
             * 3.-Mutación, intercambio 1 bit con probabilidad probMutacion
             * 1/(popsize*dimension*NBITS) sugerido
             */
            // hijos.mutar(probMutacion);
            // hijos.mutar(1 / (tamPoblacion * dimension * NBITS));
            hijos.mutar(0.01);
            hijos.evaluarPoblacion();

            // 4.-Reemplazo generacional
            p = hijos.clone();
        }
        p.evaluarPoblacion();
        return p.mejor();
    }

}
