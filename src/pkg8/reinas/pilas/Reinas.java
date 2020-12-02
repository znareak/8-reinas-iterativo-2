package pkg8.reinas.pilas;

import static pkg8.reinas.pilas.Helpers.log;
import static pkg8.reinas.pilas.Helpers.logLn;
import static pkg8.reinas.pilas.Helpers.readString;
import static pkg8.reinas.pilas.Helpers.isNumber;
import static pkg8.reinas.pilas.Helpers.isNumberInRange;
import pkg8.reinas.Stack.piladinamica;

public class Reinas {
    
    static final int NUM_REINAS = 8;
    static int[] tablero = new int[NUM_REINAS];
    
    static void resolver(int cantidadReinas) {
        int columnaActual = 0;
        int solucionesEncontradas = 0;
        piladinamica<Integer> pila = new piladinamica<>();
        
        while (true) {
            while (columnaActual < cantidadReinas) {
                if (esCorrectoElTablero(pila, columnaActual)) {
                    pila.push(columnaActual);
                    tablero[pila.size() - 1] = columnaActual;
                    columnaActual = 0;
                } else {
                    columnaActual++;
                }
            }
            
            if (pila.size() == cantidadReinas) {
                solucionesEncontradas++;
                imprimirSolucion(solucionesEncontradas);
            }

            // si el tope de la pilla llega ser nulo (vacio), quiere decir que ya no existe reinas por colocar
            // por ende ya se encontraron todas las soluciones posibles
            if (pila.top() == null) {
                break;
            }
            
            if (pila.top() == cantidadReinas) {
                pila.pop();
            }

            // si no se ha entrado en los condicionales anteriores es porque aun queda reinas y por ende mas soluciones
            // con esta sentencia eliminamos la anterior dama (columna) y a su vez pasamos a la siguiente columna para
            // seguir buscando mas soluciones
            columnaActual = pila.pop() + 1;
        }
        pila = null; // se vacia el objeto
    }
    
    static boolean esCorrectoElTablero(piladinamica<Integer> pila, int columnaActual) {
        
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
    
    static void imprimirSolucion(int solucion) {
        logLn(solucion + ": ");
        for (int fila = 0; fila < NUM_REINAS; fila++) {
            for (int columna = 0; columna < NUM_REINAS; columna++) {
                
                // se va comprobando si en la fila existe una reina
                if(fila ==  tablero[columna]){
                    log("Q ");
                }else{
                    log("# ");
                }
            }
            log("\n");
        }
        logLn("");
    }
    
    public static void main(String[] args) {
        logLn("Algorítmo de las 8 reinas");
        logLn("Coloque la cantidad de reinas");
        
        boolean seguir = true;
        
        while (seguir) {
            String str = readString();
            if (!str.isEmpty() && isNumber(str)) {
                int queens = Integer.parseInt(str);
                if (isNumberInRange(queens)) {
                    resolver(queens);
                    seguir = false;
                    
                } else {
                    logLn("El valor ingresado no es un numero en el rango 1-8.\nIntente de nuevo:");
                }
            } else {
                logLn("El valor ingresado no es un numero valido.\nIntente de nuevo:");
            }
        }
        
        tablero = null; // se vacia el objeto
    }
}
