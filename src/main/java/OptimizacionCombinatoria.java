public class OptimizacionCombinatoria {

    public void ejecutarAlgoritmo(int optimización, int numFun, int dimension) {
        if (optimización == 1) {
            // Recocido simulado
        } else if (optimización == 2) {
            // Búsqueda aleatoria
            BusquedaAleatoria busquedaAleatoria = new BusquedaAleatoria();
            busquedaAleatoria.busquedaAleatoria(numFun, dimension);
        }
    }

}
