package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import java.math.BigInteger;

/**
 * Clase de prueba para la clase Polinomio.
 * Esta clase contiene varios métodos de prueba para verificar el correcto
 * funcionamiento de los métodos en la clase Polinomio.
 */
public class TestPolinomio {

    /**
     * Prueba para verificar que el método polinomio_random de la clase Polinomio
     * genera un polinomio
     * con coeficientes aleatorios y que el primer coeficiente es igual al valor k
     * pasado como argumento.
     */
    @Test
    public void testPolinomioRandom() {

        Polinomio polinomio = new Polinomio(5);
        BigInteger k = new BigInteger("123456789");

        polinomio.polinomio_random(k);

        BigInteger[] coeficientes = polinomio.coeficientes();
        assertNotNull(coeficientes);
        assertEquals(k, coeficientes[0]);
    }

    /**
     * Prueba para verificar que el método evaluar de la clase Polinomio retorna un
     * valor no nulo
     * cuando se le pasa 2 como argumento.
     */
    @Test
    public void testEvaluar() {

        Polinomio polinomio = new Polinomio(3);
        BigInteger k = new BigInteger("123456789");
        polinomio.polinomio_random(k);

        BigInteger resultado = polinomio.evaluar(2);

        assertNotNull(resultado);
    }

    /**
     * Prueba para verificar que el método evaluarAN de la clase Polinomio retorna
     * un array no nulo
     * de longitud 5 cuando se le pasa 5 como argumento.
     */
    @Test
    public void testEvaluarAN() {

        Polinomio polinomio = new Polinomio(3);
        BigInteger k = new BigInteger("123456789");
        polinomio.polinomio_random(k);

        BigInteger[] evaluaciones = polinomio.evaluarAN(5);

        assertNotNull(evaluaciones);
        assertEquals(5, evaluaciones.length);
    }

    /**
     * Prueba para verificar que el método evaluarAN de la clase Polinomio retorna
     * un array no nulo
     * de longitud 10 cuando se le pasa 10 como argumento.
     */
    @Test
    public void testEvaluarANConNMayor() {

        Polinomio polinomio = new Polinomio(3);
        BigInteger k = new BigInteger("123456789");
        polinomio.polinomio_random(k);

        BigInteger[] evaluaciones = polinomio.evaluarAN(10);

        assertNotNull(evaluaciones);
        assertEquals(10, evaluaciones.length);
    }

    /**
     * Prueba para verificar que el método evaluarAN de la clase Polinomio retorna
     * un array no nulo
     * de longitud 2 cuando se le pasa 2 como argumento.
     */
    @Test
    public void testEvaluarANConNMenor() {

        Polinomio polinomio = new Polinomio(3);
        BigInteger k = new BigInteger("123456789");
        polinomio.polinomio_random(k);

        BigInteger[] evaluaciones = polinomio.evaluarAN(2);

        assertNotNull(evaluaciones);
        assertEquals(2, evaluaciones.length);
    }
}
