package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

/**
 * Clase de prueba para la clase Cifrado.
 * Esta clase contiene varios métodos de prueba para verificar el correcto
 * funcionamiento de los métodos en la clase Cifrado.
 */
public class TestCifrado {

    /**
     * Prueba para verificar que el método SHA256 de la clase Cifrado cifra
     * correctamente la contraseña "XimenaGod".
     */
    @Test
    public void contraseñaCifrada1() {
        Cifrado prueba = new Cifrado();
        String contraseñaEsperada = "556c28f4f1c927dd38d130baea0cbaf097dc4c0aaccc3114ce296404a4f15226";
        String contraCorrecta = prueba.SHA256("XimenaGod").toString();

        assertEquals(contraseñaEsperada, contraCorrecta);
    }

    /**
     * Prueba para verificar que el método SHA256 de la clase Cifrado cifra
     * correctamente la contraseña "VivaGalaviz".
     */
    @Test
    public void contraseñaCifrada2() {
        Cifrado prueba = new Cifrado();
        String contraseñaEsperada = "20b4e37bb387824a9480a644542aec2998e5e67939fd5fea341c7660f58ea79c";
        String contraCorrecta = prueba.SHA256("VivaGalaviz").toString();

        assertEquals(contraseñaEsperada, contraCorrecta);
    }

    /**
     * Prueba para verificar que el método SHA256 de la clase Cifrado cifra
     * correctamente la contraseña "PasennosPorfavor):".
     */
    @Test
    public void contraseñaCifrada3() {
        Cifrado prueba = new Cifrado();
        String contraseñaEsperada = "522752d81c72fdb2fb89f1145b01daec9e42e91df45bb72557c81276101e79c4";
        String contraCorrecta = prueba.SHA256("PasennosPorfavor):").toString();

        assertEquals(contraseñaEsperada, contraCorrecta);
    }

    /**
     * Prueba para verificar que el método SHA256 de la clase Cifrado lanza una
     * excepción IllegalArgumentException cuando se le pasa null como argumento.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contraseñaNula() {
        Cifrado prueba = new Cifrado();
        String contraCorrecta = prueba.SHA256(null).toString();
    }

    /**
     * Prueba para verificar que el método aDecimal de la clase Cifrado retorna un
     * valor no nulo cuando se le pasa "contraseña" como argumento.
     */
    @Test
    public void testADecimal() {
        Cifrado cifrado = new Cifrado();
        String contraseña = "contraseña";
        BigInteger resultado = cifrado.aDecimal(contraseña);
        assertNotNull(resultado);
    }

    /**
     * Prueba para verificar que el método evaluas de la clase Cifrado retorna un
     * array no nulo de longitud n cuando se le pasan los argumentos n, t y
     * "contraseña".
     */
    @Test
    public void testEvaluas() {
        Cifrado cifrado = new Cifrado();
        int n = 10;
        int t = 5;
        String contraseña = "contraseña";
        BigInteger[] resultado = cifrado.evaluas(n, t, contraseña);
        assertNotNull(resultado);
        assertEquals(n, resultado.length);
    }
}
