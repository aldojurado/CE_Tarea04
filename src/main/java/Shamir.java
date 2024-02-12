package main.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.swing.JPasswordField;



import java.io.Console;
import java.io.File;
import java.io.FileReader;

public class Shamir {

    public static void main(String[] args) {

        if (args.length > 0) {
            String codDef = args[0]; //instrucción codificar o decodificar
            if (codDef.equalsIgnoreCase("C") && validarArgs(args,1)) {
                cifradoMain(args);
                
            }
            else if (codDef.equalsIgnoreCase("D") && validarArgs(args,2)) {
                descifradoMain(args);
            }

            else if (!codDef.equalsIgnoreCase("D") && !codDef.equalsIgnoreCase("C")) {
                System.out.println("Las opciones disponibles son cifrar (C) o descifrar (D)");
            }     
        } else{
            System.out.println("No se han introducido argumentos");
        }
    }
    
    public static String pedirContra() {
        Console consola = System.console();
        if (consola != null) {
            System.out.println("\n Introduca la contraseña con la que será cifrado el documento \n");
            char[] letras = consola.readPassword();
            return new String(letras);
        }
        return null;

    }

    public static void descifradoMain(String[] args) {
        String rutaCifrado = args[2];
                Descifrado descifrado = new Descifrado();
                String textoDes = descifrado.descifrado(args[1], lecturaCifrada(rutaCifrado),
                        Integer.parseInt(args[3]));
                String rutaDestino = rutaCifrado.substring(0, rutaCifrado.length() - 4) + ".dec";
                guardarEnArchivo(rutaDestino, textoDes);

    }
    

    public static void cifradoMain(String[] args) {
    String rutaClaro = args[3]; //arg[3] debe ser ruta del texto claro
                int n = Integer.parseInt(args[1]);
                int t = Integer.parseInt(args[2]);
                String contraseña = pedirContra();
                Cifrado cifrado = new Cifrado(); 
                BigInteger[] eval = cifrado.evaluas(n, t, contraseña);
                String cifradoTexto = cifrado.cifrado(lecturaDoc(rutaClaro), contraseña);
                guardarEnArchivo("evaluaciones/" + args[4] + ".evl", eval);
                    String destinoCifrado = rutaClaro.substring(0, rutaClaro.length() - 4) + ".cif";
                    guardarEnArchivo(destinoCifrado, cifradoTexto);
    }
    
    protected static boolean validarArgs(String[] args, int num) {
        if (num==1) {
            if (args.length != 5) {
                System.out.println("Número de argumentos incorrecto para codificar");
                return false;
            }
            int n = 0;//n requerido con n>2
            int t = 0; //t con 1 < t < n
            try {
                n = Integer.parseInt(args[1]);
                t = Integer.parseInt(args[2]);
            } catch (Exception e) {
                System.out.println("Alguno de los argumentos introducidos no es un número");
                return false;
            }
            if (n <= 2 || t <= 1 || t >= n) {
                System.out.println("Se debe cumplir que 2<n y 1<t<n");
                return false;
            }
            
        } else {
            if (args.length != 4) {
                System.out.println("Número de argumentos incorrecto para decodificar");
                return false;
            }
            int t = 0; //t con 1 < t 
            try {
                t = Integer.parseInt(args[3]);
            } catch (Exception e) {
                System.out.println("t debe ser un número");
                return false;
            }
            if (t <= 1) {
                System.out.println("t debe ser mayor a 1");
                return false;
            }
        }

        return true;
    }
    
    /**
     * Método que lee un documento dada una ruta.
     * @param ruta ruta donde se ubica el archivo
     * @return String con todo el texto del archivo
     */
    protected static String lecturaDoc(String ruta) {
        String documento = null;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(ruta));
            String linea = buffer.readLine();
            StringBuilder cadenas = new StringBuilder();
            while (linea != null) {
                cadenas.append(linea).append("\n");
                linea = buffer.readLine();
            }
            documento = cadenas.toString();
        } catch (Exception e) {
            System.out.println("Error al leer el documento con ruta:"+ruta);
        }
        return documento;
    }
    
    protected static String lecturaCifrada(String ruta) {
        String documento = null;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(ruta));
            String linea = buffer.readLine();
            if (linea != null) {
                documento = linea;
            }
            buffer.close();
        } catch (Exception e) {
            System.out.println("Error al leer el documento con ruta: "+ruta);
        }
        return documento;
    }

    private static void guardarEnArchivo(String rutaArchivo, BigInteger[] evaluaciones) {
        crearCarpeta();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (int i = 0; i < evaluaciones.length; i++) {
                writer.write((i + 1) + " " + evaluaciones[i].toString());
                writer.newLine();
            }
            System.out.println("Datos guardados en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void crearCarpeta() {
        File carpeta = new File( "evaluaciones");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }
    
    private static void guardarEnArchivo(String ruta, String texto) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(texto);
            writer.newLine();
            System.out.println("Datos guardados en el archivo: " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
