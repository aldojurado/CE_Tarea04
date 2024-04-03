import java.util.Random;

public class Poblacion {
    private int tam;
    private int numBits;
    private int seed;
    private double[] evaluaciones;
    private int[][] individuos;
    private int dimension;
    private int[] mejorIndividuo;
    private int numFun;
    private double[] intervalo;

    /**
     * Constructor de la población
     * 
     * @param tamPoblacion
     * @param numBits
     * @param seed
     * @param dimension
     */
    public Poblacion(int tamPoblacion, int numBits, int seed, int dimension, int numFun) {
        this.tam = tamPoblacion;
        this.numBits = numBits;
        this.seed = seed;
        this.individuos = generaIndividuos(seed, tamPoblacion, numBits, dimension);
        this.evaluaciones = new double[tamPoblacion];
        this.dimension = dimension;
        this.numFun = numFun;
        Evaluador evaluador = new Evaluador();
        this.intervalo = evaluador.intervalo(numFun);
    }

    /**
     * Genera una población de individuos aleatorios con una semilla
     * 
     * @param semilla
     * @param tamPoblacion
     * @param numBits2
     * @param dimension
     * @return
     */
    private int[][] generaIndividuos(int semilla, int tamPoblacion, int numBits2, int dimension) {
        int[][] individuos = new int[tamPoblacion][numBits2 * dimension];
        Random random = new Random(semilla);
        for (int i = 0; i < tamPoblacion; i++) {
            for (int j = 0; j < numBits2 * dimension; j++) {
                individuos[i][j] = random.nextInt(2);
            }
        }
        return individuos;
    }

    public void evaluarPoblacion() {
        Binario binario = new Binario();
        Evaluador evaluador = new Evaluador();
        for (int i = 0; i < tam; i++) {
            int[] individuo = individuos[i];
            double[] solucion = binario.decodifica(individuo, numBits, intervalo[0], intervalo[1]);
            evaluaciones[i] = evaluador.evaluaEn(numFun, solucion);
        }

    }

    /**
     * Imprime el mejor individuo de la población
     * Para mandar a llamar este debemos evaluar la población primero
     */
    public double[] mejor() {
        Binario binario = new Binario();
        int mejor = 0;
        for (int i = 0; i < tam; i++) {
            if (evaluaciones[i] < evaluaciones[mejor]) {
                mejor = i;
            }
        }

        double[] mejorSol = binario.decodifica(individuos[mejor], numBits, intervalo[0], intervalo[1]);
        return mejorSol;
    }

    /**
     * Selecciona en la población actual los padres para la siguiente generación
     * 
     */
    public void seleccionarPadres() {
        Poblacion padres = new Poblacion(tam, numBits, seed, dimension, numFun);
    }
}
