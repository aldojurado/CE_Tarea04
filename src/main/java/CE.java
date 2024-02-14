import java.lang.Math;

public class CE {

    public static void main(String[] args) {
        int d;
        double[] rango = new double[2];
        try {
            d = Integer.parseInt(args[0]);
            rango[0] = Double.parseDouble(args[1]);
            rango[1] = Double.parseDouble(args[2]);
            Evaluador e = new Evaluador(d, rango);
            System.out.println("Evaluador creado con éxito");
        } catch (Exception e) {
            // TODO: handle exception
        }
        // Pruebas de mínimos
        Funciones f = new Funciones();
        double[] valores = { 0, 0 };
        System.out.println("El resultado es " + f.sumSquare(valores));
        double[] y = { 1, 0.70710678 };
        System.out.println("El resultado de dixonPrice " + f.dixonPrice(y));
        double[] x = { -2.903534, -2.903534 };
        System.out.print("El resultado de styblinski " + f.StyblinskiTang(x));

    }

}
