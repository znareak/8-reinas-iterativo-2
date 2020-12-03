package pkg8.reinas.pilas;

import pkg8.reinas.Stack.piladinamica;
import static pkg8.reinas.pilas.Helpers.esNumero;
import static pkg8.reinas.pilas.Helpers.imprimir;
import static pkg8.reinas.pilas.Helpers.leerCadena;
import static pkg8.reinas.pilas.Helpers.numeroDentroDelRango;

public class Programa implements Acciones {

    @Override
    public void comenzar() {
        boolean seguir = true;

        while (seguir) {
            String str = leerCadena();
            if (!str.isEmpty() && esNumero(str)) {
                int reinas = Integer.parseInt(str);
                if (numeroDentroDelRango(reinas)) {

                    Acciones ag = new Algoritmo(reinas); // constructor
                    ag.comenzar();
                    ag = null;
                    seguir = false;

                } else {
                    imprimir("El valor ingresado no es un numero en el rango 1-8.\nIntente de nuevo:");
                }
            } else {
                imprimir("El valor ingresado no es un numero valido.\nIntente de nuevo:");
            }

        }
    }
}
