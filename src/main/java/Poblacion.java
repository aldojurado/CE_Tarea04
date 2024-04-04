import java.util.Random;

public class Poblacion implements Cloneable {
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
        mejorIndividuo = mejorBin();

    }

    /**
     * @return Devuelve el mejor individuo de la población en su representación
     *         binaria
     */
    private int[] mejorBin() {
        int mejor = 0;
        for (int i = 0; i < tam; i++) {
            if (evaluaciones[i] < evaluaciones[mejor]) {
                mejor = i;
            }
        }
        return individuos[mejor];
    }

    /**
     * @return Devuelve el mejor individuo de la población en su representación
     *         decimal
     */
    public double[] mejor() {
        Binario binario = new Binario();
        int[] mejorIndividuo = mejorBin();
        double[] mejorSol = binario.decodifica(mejorIndividuo, numBits, intervalo[0], intervalo[1]);
        return mejorSol;
    }

    // seguir en este método
    public void seleccionarPadres() {
        int numHijos = 0;
        while (numHijos < tam) {
            int[] padre1 = individuos[ruleta()];
            int[] padre2 = individuos[ruleta()];
            int[][] hijos = cruzar(padre2, padre1);
            int[] hijo1 = hijos[0];
            int[] hijo2 = hijos[1];
            if (numHijos < tam) {
                individuos[numHijos] = hijo1;
                numHijos++;

            }
            if (numHijos < tam) {

                individuos[numHijos] = hijo2;
                numHijos++;
            }
        }

    }

    private int[][] cruzar(int[] padre1, int[] padre2) {
        int[][] hijos = new int[2][padre1.length];
        return hijos;
    }

    private int ruleta() {
        // Calculamos la aptitud total
        double f = 0;
        for (int i = 0; i < tam; i++) {
            f += evaluaciones[i];
        }

        // Calculamos la probabilidad de selección de cada individuo
        double[] proba = new double[tam];
        for (int i = 0; i < tam; i++) {
            proba[i] = evaluaciones[i] / f;
        }

        // Generamos un número aleatorio entre 0 y 1
        Random random = new Random();
        double r = random.nextDouble();

        // Realizamos la selección basada en la ruleta
        double probaAcumulada = 0;
        for (int i = 0; i < tam; i++) {
            probaAcumulada += proba[i];
            if (r < probaAcumulada) {
                return i;
            }
        }

        // El ciclo debe funcionar bn, pero igual java nos pide que devolvamos algunos,
        // por cualquier cosa dejamos el último
        return tam - 1;
    }

    @Override
    public Poblacion clone() {
        try {
            Poblacion clonedPoblacion = (Poblacion) super.clone();
            // Copiar los atributos primitivos
            clonedPoblacion.tam = this.tam;
            clonedPoblacion.numBits = this.numBits;
            clonedPoblacion.seed = this.seed;
            clonedPoblacion.dimension = this.dimension;
            clonedPoblacion.numFun = this.numFun;

            // Copiar los arrays
            clonedPoblacion.evaluaciones = this.evaluaciones.clone();
            clonedPoblacion.mejorIndividuo = this.mejorIndividuo.clone();
            clonedPoblacion.intervalo = this.intervalo.clone();

            // Copiar la matriz
            clonedPoblacion.individuos = new int[this.individuos.length][];
            for (int i = 0; i < this.individuos.length; i++) {
                clonedPoblacion.individuos[i] = this.individuos[i].clone();
            }

            return clonedPoblacion;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
