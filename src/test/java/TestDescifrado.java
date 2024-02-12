package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.Assert.*;

/**
 * Clase de prueba para la clase Descifrado.
 * Esta clase contiene el método de prueba para verificar el correcto
 * funcionamiento de la clase Descifrado.
 * OJO: Este método de prueba requiere que exista un archivo de evaluaciones
 * en la ruta especificada en la variable rutaEvaluaciones.
 * Puedes cambiar a t al grado al que hallas generado el número minimo de
 * evaluaciones necesarias.
 * Los archivos que se encuentran en evaluaciones son de prueba, puedes usarlos
 * para probar el método.
 */
public class TestDescifrado {
    @Test
    public void testDescifrado() {
        Descifrado descifrado = new Descifrado();
        String rutaEvaluaciones = "evaluaciones/prueba.evl"; // Asigna una ruta válida aquí
        String textoCifrado = "archivoCifrado.txt";
        int t = 3;
        String resultado = descifrado.descifrado(rutaEvaluaciones, textoCifrado, t);
        assertNotNull(resultado);
    }

    @Test
    public void testLeerEvaluaciones() {
        BigInteger[] evaluaciones = Descifrado.leerEvaluaciones("evaluaciones/prueba.evl");
        assertNotNull(evaluaciones);
        assertTrue(evaluaciones.length > 0);
    }

}
