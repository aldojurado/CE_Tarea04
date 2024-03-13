public class OptimizacionCombinatoria {

    public void ejecutarAlgoritmo(int optimización, int numFun, int dimension) {
        if (optimización == 1) {
            // Recocido simulado
            Recocido recocido = new Recocido();
            recocido.recocido(numFun, dimension);
        } else if (optimización == 2) {
            // Búsqueda aleatoria
            BusquedaAleatoria busquedaAleatoria = new BusquedaAleatoria();
            busquedaAleatoria.busquedaAleatoria(numFun, dimension);
            // acá llega la solución ya decodificada
        }
    }

}
