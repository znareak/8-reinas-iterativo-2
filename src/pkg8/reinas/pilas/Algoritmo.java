package pkg8.reinas.pilas;

import pkg8.reinas.Stack.piladinamica;
import static pkg8.reinas.pilas.Helpers.imprimirEnLinea;
import static pkg8.reinas.pilas.Helpers.imprimir;

public class Algoritmo {

    static int[] tablero;

    static void resolver(int cantidadReinas) {
        if(cantidadReinas == 2 | cantidadReinas == 3){
            imprimir("Para esta cantidad no existen soluciones.");
            return;
        }
        
        tablero = new int[cantidadReinas];
        int columnaActual = 0;
        int solucionesEncontradas = 0;
        piladinamica<Integer> pila = new piladinamica<>();

        while (true) {
            while (columnaActual < cantidadReinas) {
                if (esCorrectoElTablero(pila, columnaActual)) {
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
                imprimirSolucion(solucionesEncontradas, cantidadReinas);
            }

            // si el tope de la pilla llega ser nulo (vacio), quiere decir que ya no existe reinas por colocar
            // por ende ya se encontraron todas las soluciones posibles, salimos del ciclo padre
            if (pila.top() == null) {
                break;
            }

            // si no se ha entrado en los condicionales anteriores es porque aun queda reinas y por ende mas soluciones,
            // con esta sentencia eliminamos la anterior dama (columna) y a su vez pasamos a la siguiente columna para
            // seguir buscando mas soluciones
            columnaActual = pila.pop() + 1;
        }
        pila = null; // se vacia el objeto
        tablero = null;
    }

    static boolean esCorrectoElTablero(piladinamica<Integer> pila, int columnaActual) {

        // iteramos en la pila, cabe destacar que solo recorrera la cantidad de reinas que esten colocadas actualmente
        for (int columna = 0; columna < pila.size(); columna++) {
            // tablero[columna] me da un numero que es la columna donde esta ubicada esa reina
            boolean mismaColumna = tablero[columna] == columnaActual;

            // la resta de las filas y columnas es siempre constante.
            // si la columna de la reina ya colocada menos la columna en la que se itera actualmente es igual
            // 
            boolean mismaDiagonal = Math.abs(columnaActual - tablero[columna]) == pila.size() - columna;

            if (mismaColumna || mismaDiagonal) {
                return false;
            }
        }
        return true;
    }

    static void imprimirSolucion(int solucion, int cantidadReinas) {
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
