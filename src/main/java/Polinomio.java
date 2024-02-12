package main.java;

import java.math.BigInteger;
import java.util.Random;

public class Polinomio {
    //Coeficientes del polinomio
    private BigInteger[] coeficientes;

    /**
     * Constructor de la clase Polinomio, incializa el polinomio
     * de grado t-1
     * @param t t-1 es el grado del polinomio
     */
    public Polinomio(int t) {
        this.coeficientes = new BigInteger[t];
    }

    /**
     * Genera los coeficientes aleatorios del polinomio y el término independiente
     * es el número k
     * @param k término independiete
     */
    public void polinomio_random(BigInteger k) {
        this.coeficientes[0] = k;
        for (int i = 1; i < this.coeficientes.length; i++) {
            int num = (int) (Math.random() * 5);
            this.coeficientes[i] =  new BigInteger(""+num);
        }
    }

    /**
     * Evalúa el polinomio en un punto x 
     * @param x número en el que será evaluádo el polinomio
     * @return el resultado de evaluar el polinomio en x
     */
    public BigInteger evaluar(int x) {
        BigInteger resultado = BigInteger.ZERO;
        BigInteger multi = new BigInteger(""+x);
        for (int i = coeficientes.length - 1; i > 0; i--) {
            resultado = (resultado.add(coeficientes[i])).multiply(multi);
        }
        resultado = resultado.add(coeficientes[0]) ;
        return resultado;
    }

    /**
     * @return los coeficientes del polinomio
     */
    public BigInteger[] coeficientes() {
        return this.coeficientes;
    }
    
    /**
     * Método que evalúa el polinomio en los los puntos del 1 al n
     * @param n número de evaluaciones del polinomio
     * @return un arreglo de BigInteger con las n evaluaciones del polinomio
     */
    protected BigInteger[] evaluarAN(int n) {
        BigInteger[] evaluaciones = new BigInteger[n];
        for (int i = 1; i < n+1; i++) {
            evaluaciones[i-1] = evaluar(i);
        }
        return evaluaciones;
    }
}