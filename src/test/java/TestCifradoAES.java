package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Clase de prueba para la clase CifradoAES.
 * Esta clase contiene varios métodos de prueba para verificar el correcto
 * funcionamiento de los métodos en la clase CifradoAES.
 */
public class TestCifradoAES {

    /**
     * Prueba para verificar que el método cifrar de la clase CifradoAES retorna un
     * valor no nulo cuando se le pasa "texto a cifrar" y "contraseña" como
     * argumentos.
     */
    @Test
    public void testCifrar() {

        CifradoAES cifradoAES = new CifradoAES();
        String texto = "texto a cifrar";
        String contraseña = "contraseña";

        String textoCifrado = cifradoAES.cifrar(texto, contraseña);

        assertNotNull(textoCifrado);
    }

    /**
     * Prueba para verificar que el método descifrar de la clase CifradoAES retorna
     * el texto original cuando se le pasa el texto cifrado y la misma contraseña
     * utilizada para cifrar.
     */
    @Test
    public void testDescifrar() {

        CifradoAES cifradoAES = new CifradoAES();
        String texto = "texto a cifrar";
        String contraseña = "contraseña";
        String textoCifrado = cifradoAES.cifrar(texto, contraseña);

        String textoDescifrado = cifradoAES.descifrar(textoCifrado, contraseña);

        assertEquals(texto, textoDescifrado);
    }

    /**
     * Prueba para verificar que el método cifrar y luego descifrar de la clase
     * CifradoAES retorna el texto original.
     */
    @Test
    public void testCifrarYDescifrar() {

        CifradoAES cifradoAES = new CifradoAES();
        String texto = "texto a cifrar y descifrar";
        String contraseña = "contraseña";

        String textoCifrado = cifradoAES.cifrar(texto, contraseña);
        String textoDescifrado = cifradoAES.descifrar(textoCifrado, contraseña);

        assertEquals(texto, textoDescifrado);
    }

    /**
     * Prueba para verificar que el método cifrar con una contraseña y luego
     * descifrar con otra contraseña de la clase CifradoAES no retorna el texto
     * original.
     */
    @Test
    public void testCifrarConContraseñaDiferente() {

        CifradoAES cifradoAES = new CifradoAES();
        String texto = "texto a cifrar";
        String contraseña1 = "contraseña1";
        String contraseña2 = "contraseña2";

        String textoCifrado = cifradoAES.cifrar(texto, contraseña1);
        String textoDescifrado = cifradoAES.descifrar(textoCifrado, contraseña2);

        // Como las contraseñas son diferentes, el texto descifrado no debería ser igual
        // al texto original
        assertNotEquals(texto, textoDescifrado);
    }
}
