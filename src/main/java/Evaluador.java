import java.util.Random;

public class Evaluador {
    public double evaluaEn(int k, double[] valores) {
        Funciones funciones = new Funciones();
        switch (k) {
            case 1:
                return funciones.sphere(valores);
            case 2:
                return funciones.ackley(valores);
            case 3:
                return funciones.griewank(valores);
            case 4:
                return funciones.rastrigin(valores);
            case 5:
                return funciones.rosenbrock(valores);
            case 6:
                return funciones.sumSquare(valores);
            case 7:
                return funciones.StyblinskiTang(valores);
            case 8:
                return funciones.dixonPrice(valores);
        }
        return 11111111111.0;
    }
}
