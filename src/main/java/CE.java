import java.lang.Math;

public class CE {

    public static void main(String[] args) {
        verificaDatos(args);
    }

    public static void verificaDatos(String[] args) {
        int k = 0;
        int d = 0;
        double[] valores = null;
        int iteraciones = 0;
        if (args.length < 3) {
            System.out.println("Los argumentos no son suficientes");
        } else {
            try {
                k = Integer.parseInt(args[0]);
                d = Integer.parseInt(args[1]);
                if (d > 0 && k > 0 && k < 4) {
                    if (args[2].toLowerCase().charAt(0) == 'a') {
                        if (args.length == 4) {
                            try {
                                iteraciones = Integer.parseInt(args[3]);
                                if (iteraciones > 0) {
                                    busquedaAleatoria(k, d, iteraciones);
                                } else {
                                    throw new Exception();
                                }
                            } catch (Exception e) {
                                System.out.println("El número de iteraciones debe ser un entero positivo");
                            }
                        } else {
                            if (args.length < 4) {
                                System.out.println("Falta el número de iteraciones deseadas");
                            } else {
                                System.out.println("Sobran los siguientes argumentos:");
                                for (int i = 4; i < args.length; i++) {
                                    System.out.println(args[i]);
                                }
                            }
                        }
                    } else {
                        try {

                            valores = new double[d];
                            valores[0] = Double.parseDouble(args[2]);
                        } catch (Exception e) {
                            System.out.println(
                                    "Para el tercer argumento ponga el caracter 'a' para realizar búsqueda aleatoria o el valor de x_1 (hasta x_n por espacios) para realizar búsqueda local");
                            return;
                        }
                        if (args.length == d + 2) {
                            try {
                                for (int i = 1; i < d; i++) {
                                    valores[i] = Double.parseDouble(args[i + 2]);
                                }
                                System.out.println("Dimensión: " + d + "\nValores de x_i:");
                                for (int i = 0; i < d; i++) {
                                    System.out.println("x_" + (i + 1) + " = " + valores[i]);
                                }
                                System.out.println("Resultado:");
                                busquedaLocal(k, d, valores);
                            } catch (Exception e) {
                                System.out.println("Los valores de x_i deben ser números reales");
                                return;
                            }
                        } else {
                            if (args.length < d + 2) {
                                System.out.println("Falta(n) " + (args.length - d) + " valor(es) de x_i");
                                return;
                            }
                            System.out.println("Sobran(n) " + (args.length - d - 2) + " valor(es) de x_i");
                            return;
                        }

                    }
                } else {
                    System.out.println("El primer argumento debe ser:\n" +
                            " 1 para SumSquare\n" +
                            " 2 para DixonPrice\n" +
                            " 3 para StyblinskiTang \n" +
                            " \n" +
                            " El segundo argumento debe ser la dimensión requerida (d mayor o igual a 1)");
                }
            } catch (Exception e) {
                System.out.println("Los argumentos no son validos");
            }
        }

    }

    /**
     * Hace la busqueda aleatoria para identificar el mejor resultado, el peor y el
     * promedio
     * 
     * @param k    es el número de la función a evaluar
     * @param d    es la dimensión de la función
     * @param iter son las iteraciones que se realizarán
     */
    public static void busquedaAleatoria(int k, int d, int iter) {
        Evaluador evaluador = new Evaluador();
        double[] res = evaluador.evaluaAleatorio(k, d, iter);
        System.out.println("Mejor: " + res[d] + "\n Donde:");
        for (int i = 0; i < d; i++) {
            System.out.println("  x_" + (i + 1) + " = " + res[i]);
        }

        System.out.println("\nPeor: " + res[d + 1]);
        System.out.println("Promedio: " + res[d + 2]);
    }

    public static void busquedaLocal(int k, int d, double[] valores) {
        Evaluador evaluador = new Evaluador();
        double res = evaluador.evaluaEn(k, valores);
        System.out.println(res);
    }
}
