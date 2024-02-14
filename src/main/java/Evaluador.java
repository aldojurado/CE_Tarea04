
public class Evaluador {

    public double evaluaEn(int k, double[] valores) {
        Funciones funciones = new Funciones();
        switch (k) {
            case 1:
                return funciones.sumSquare(valores);
            case 2:
                return funciones.dixonPrice(valores);
            case 3:
                return funciones.StyblinskiTang(valores);
        }
        return 11111111111.0;
    }

    public double[] evaluaAleatorio(int k, int d, int iter) {
        switch (k) {
            case 1:
                return aleatorioSumSquare(d, iter);
            case 2:
                return aleatorioDixonPrice(d, iter);
            case 3:
                return aleatorioStyblinskiTang(d, iter);
        }
        return null;
    }

    private double[] aleatorioStyblinskiTang(int d, int iter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aleatorioStyblinskiTang'");
    }

    private double[] aleatorioDixonPrice(int d, int iter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aleatorioDixonPrice'");
    }

    private double[] aleatorioSumSquare(int d, int iter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aleatorioSumSquare'");
    }

}
