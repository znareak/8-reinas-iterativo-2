package pkg8.reinas.pilas;

import pkg8.reinas.Stack.piladinamica;
import static pkg8.reinas.pilas.Helpers.imprimirEnLinea;
import static pkg8.reinas.pilas.Helpers.imprimir;
 
public class Algoritmo implements Acciones{

    int cantidadReinas;
    int tablero[];

    // constructor
    public Algoritmo(int reinas) {
        this.cantidadReinas = reinas;
        this.tablero = new int[reinas];
    }
    
    @Override
    public void comenzar(){
        piladinamica<Integer> pila = new piladinamica<>();
        resolver(0, 0, pila); // usando la pila dinamica
        pila = null;
    }
    
        
    public void resolver(int columnaActual, int solucionesEncontradas, piladinamica<Integer> pila) {
        if (cantidadReinas == 2 | cantidadReinas == 3) {
            imprimir("Para esta cantidad no existen soluciones.");
            return;
        }

        while (columnaActual < cantidadReinas) {
            if (esCorrectoElTablero(pila, columnaActual, tablero)) {
                // si el las columnas marcadas y diagonales no atacan a la reina, se coloca en el tablero
                pila.push(columnaActual);
                tablero[pila.size() - 1] = columnaActual;

                columnaActual = 0;

            } else {
                // aumentamos la columna, si la columna es mayor a NUM_REINAS-1 entonces se encontro una solucion
                // salimos del ciclo para buscar otra solucion
                columnaActual++;
            }
        }

        // si la pila tiene 8 elementos (reinas), eso quiere decir que se encontro una solucion
        if (pila.size() == cantidadReinas) {
            solucionesEncontradas++;
            imprimirSolucion(solucionesEncontradas);

        }

        // si el tope de la pilla llega ser nulo (vacio), quiere decir que ya no existe reinas por colocar
        // por ende ya se encontraron todas las soluciones posibles, salimos del ciclo padre
        if (pila.top() == null) {
            pila = null; // se vacia el objeto
            tablero = null;
            return;
        }

        // si no se ha entrado en los condicionales anteriores es porque aun queda reinas y por ende mas soluciones,
        // con esta sentencia eliminamos la anterior dama (columna) y a su vez pasamos a la siguiente columna para
        // seguir buscando mas soluciones
        columnaActual = pila.pop() + 1;

        // volvemos a llamar con las variables ya modificadas
        resolver(columnaActual, solucionesEncontradas, pila);
    }

    boolean esCorrectoElTablero(piladinamica<Integer> pila, int columnaActual, int tablero[]) {

        // iteramos en la pila, cabe destacar que solo recorrera la cantidad de reinas que esten colocadas actualmente
        for (int columna = 0; columna < pila.size(); columna++) {
            // tablero[columna] me da un numero que es la columna donde esta ubicada esa reina
            boolean mismaColumna = tablero[columna] == columnaActual;

            boolean mismaDiagonal = Math.abs(columnaActual - tablero[columna]) == pila.size() - columna;

            if (mismaColumna || mismaDiagonal) {
                return false;
            }
        }
        return true;
    }

    void imprimirSolucion(int solucion) {
        imprimir(solucion + ": ");
        for (int fila = 0; fila < cantidadReinas; fila++) {
            for (int columna = 0; columna < cantidadReinas; columna++) {

                // se va comprobando si en la fila existe una reina
                if (fila == tablero[columna]) {
                    imprimirEnLinea("Q ");
                } else {
                    imprimirEnLinea("# ");
                }
            }
            imprimirEnLinea("\n");
        }
        imprimir("");
    }
}
