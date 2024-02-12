package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Descifrado {

    /**
     * Método que descifra el un texto cifrado usando AES.
     * El método recupera la contraseña con la que se cifró mediante evaluaciones
     * de un polinomio donde la llave es el término independiente
     * 
     * @param rutaEvaluaciones es la ruta del archivo que contiene las evaluaciones
     *                         del polinomio
     * @param textoCifrado
     * @param t                es el número de evaluaciones que se necesitan para
     *                         recuperar el secreto
     * @return texto descifrado
     */
    protected String descifrado(String rutaEvaluaciones, String textoCifrado, int t) {
        BigInteger[] evaluaciones = leerEvaluaciones(rutaEvaluaciones);
        if (evaluaciones.length < t) {
            throw new IllegalArgumentException("No hay suficientes evaluaciones para recuperar el secreto");
        }
        BigInteger secreto = recuperarSecreto(evaluaciones, t);
        CifradoAES cifrado = new CifradoAES();
        return cifrado.descifrar(textoCifrado, secreto.toString());
    }

    /**
     * Método que lee las evaluaciones de un polinomio de un archivo
     * Este método funciona específicamente para la forma en la que se
     * guardan las evaluaciones en este mismo programa
     * 
     * @param rutaArchivo ruta del archivo con las evaluaciones
     * @return un arreglo de BigInteger con las evaluaciones
     */
    protected static BigInteger[] leerEvaluaciones(String rutaArchivo) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            List<BigInteger> evaluacionesList = new ArrayList<>();
            while ((linea = buffer.readLine()) != null) {
                String[] partes = linea.split(" ");
                evaluacionesList.add(new BigInteger(partes[1]));
            }
            int tamLista = evaluacionesList.size();
            BigInteger[] evaluaciones = new BigInteger[tamLista];
            Iterator<BigInteger> iterator = evaluacionesList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                evaluaciones[i] = iterator.next();
                i++;
            }
            return evaluacionesList.toArray(new BigInteger[0]);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de evaluaciones");
        }
        return null;
    }

    /**
     * Este método recupera el término independiente de un polinomio dadas
     * las evaluaciones de este y el número de evaluaciones que se necesitan
     * Usa la interpolación de Lagrange evaluada en 0
     * 
     * @param evaluaciones
     * @param t            t-1 es el grado del polinomio y se necesitan t
     *                     evaluaciones para recuperar el secreto
     * @return el término independiente del polinomio en un BigInteger
     */
    protected static BigInteger recuperarSecreto(BigInteger[] evaluaciones, int t) {
        BigInteger secreto = BigInteger.ZERO;
        for (int i = 0; i < t; i++) {
            secreto = secreto.add(evaluaciones[i].multiply(poliI(i + 1, t)));
        }
        return secreto;
    }

    /**
     * Método que calcula el polinomio de Lagrange en un punto i
     * 
     * @param i punto en el que se evalúa el polinomio
     * @param t t-1 es el grado del polinomio
     * @return el polinomio de Lagrange evaluado en i en un BigInteger
     */
    protected static BigInteger poliI(int i, int t) {
        BigInteger poli = BigInteger.ONE;
        BigInteger numerador = BigInteger.ONE;
        BigInteger denominador = BigInteger.ONE;
        for (int j = 1; j < t + 1; j++) {
            if (j != i) {
                numerador = numerador.multiply(new BigInteger("" + (-j)));
                denominador = denominador.multiply(new BigInteger("" + (i - j)));

            }
        }
        poli = poli.multiply(numerador.divide(denominador));
        return poli;
    }

}
