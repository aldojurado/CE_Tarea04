package main.java;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cifrado {

    /**
     * Método que codifica una clave dada por el usuario para ser 
     * codificada en SHA-256
     * @param contraseña contraseña ingresada por el usuario a encriptar
     * @return hash de la clave solicitada
     */
    protected String SHA256(String contraseña) {
        if(contraseña == null){
            throw new IllegalArgumentException();
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(contraseña.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (int i = 0; i < encodedHash.length; i++) {
                String hex = Integer.toHexString(0xff & encodedHash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Método que evalúa un polinomio con coeficientes aleatorios en n puntos
     * @param n números de evaluaciones del polinomio
     * @param t número de coeficientes del polinomio (grado t-1)
     * @param contraseña contraseña que dispersada será el coeficiente independiente [0]
     * @return un arreglo de BigInteger con las n evaluaciones del polinomio
     */
    protected BigInteger[] evaluas(int n, int t, String contraseña) {
        //evaluaciones
        Polinomio polinomio = new Polinomio(t);
        BigInteger decimal = aDecimal(contraseña);
        polinomio.polinomio_random(decimal);
        return polinomio.evaluarAN(n);
    }

    /**
     * Método que cifra un texto dado por el usuario usando una contraseña SHA-256
     * @param texto es el texto que se desea cifrar
     * @param contraseña es la contraseña en hexadecimal que se usará para cifrar el texto
     * @return texto cifrado en AES
     */
    protected String cifrado(String texto, String contraseña) {
        CifradoAES cifrado = new CifradoAES();
        String decimal = aDecimal(contraseña).toString();
        return cifrado.cifrar(texto, decimal);
    }
    
    /**
     * Método que convierte una string con un número en base hexadecimal a 
     * un BigInteger en base decimal
     * @param contraseña es el número en base hexadecimal
     * @return un BigInteger en base decimal
     */
    protected BigInteger aDecimal(String contraseña) {
        String contra = SHA256(contraseña);
        BigInteger decimal = new BigInteger(contra, 16);
        return decimal;
    }

}

