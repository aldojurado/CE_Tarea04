package main.java;

import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class CifradoAES {

    /**
     * Método para cifrar el texto a partir de una contraseña
     * dada por el usuario
     * @param texto texto a cifrar en AES
     * @param contraseña contraseña que se ocupará para cifrar
     * @return texto cifrado en AES
     */
    protected String cifrar(String texto, String contraseña) {
        String textoCifrado = "";
        try {
            String password = contraseña;
            SecretKey claveSecreta = derivarClaveDesdePassword(password);
            textoCifrado = cifrarAES(texto, claveSecreta);
        } catch (Exception e) {
            System.out.println("Error al cifrar el texto.");
        }
        return textoCifrado;
    }
    
    /**
     * Método que recupera el texto original a partir de un texto cifrado
     * @param textoCifrado texto cifrado en AES
     * @param contraseña contraseña con la que se recuperará el texto original
     * @return regresa el texto original a partir del texto cifrado en AES
     */
    protected String descifrar(String textoCifrado, String contraseña) {
        String textoDescifrado = "";
        try {
            String password = contraseña;
            SecretKey claveSecreta = derivarClaveDesdePassword(password);
            textoDescifrado = descifrarAES(textoCifrado, claveSecreta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textoDescifrado;
    }

    /**
    * Método que deriva una clave secreta a partir de una contraseña 
    * usando PBKDF2.
    * @param password la contraseña de la que se deriva la clave secreta
    * @return una clave secreta de 128 bits compatible con AES
    * @throws Exception regresa una excepción en caso de no poder generar la clave secreta
    */
    private static SecretKey derivarClaveDesdePassword(String password) throws Exception {
        String salt = "galaDiosXimenaGodKarlyGod"; // Valor aleatorio conocido como "salt"
        int iteraciones = 100000;  // Número de iteraciones

        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iteraciones, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] claveBytes = factory.generateSecret(keySpec).getEncoded();

        return new SecretKeySpec(claveBytes, "AES");
    }

    /**
     * Cifra un texto en AES dada una clave secreta única
     * @param texto texto a cifrar en AES
     * @param claveSecreta clave secreta con la que será cifrado el texto
     * @return regresa el texto cifrado en AES con una clave secreta
     * @throws Exception regresa excepción encaso de que ocurra un error a la hora de cifrar
     */
    private static String cifrarAES(String texto, SecretKey claveSecreta) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta);
        byte[] textoCifrado = cifrador.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    /**
     * Método que recupera el texto original cifrado en AES a partir de una clave secreta
     * @param textoCifrado texto a recuperar cifrado en AES
     * @param claveSecreta clave con la que se recuperará el texto original
     * @return regresa el texto original, legible el cual estaba cifrado en AES
     * @throws Exception regresa una excepción en caso de que no sea posible descifrar el texto
     */
    private static String descifrarAES(String textoCifrado, SecretKey claveSecreta) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.DECRYPT_MODE, claveSecreta);
        byte[] textoDescifrado = cifrador.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(textoDescifrado);
    }
}
