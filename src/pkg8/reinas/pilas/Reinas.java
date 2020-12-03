package pkg8.reinas.pilas;

import static pkg8.reinas.pilas.Helpers.imprimir;
import static pkg8.reinas.pilas.Helpers.leerCadena;
import static pkg8.reinas.pilas.Helpers.esNumero;
import static pkg8.reinas.pilas.Helpers.numeroDentroDelRango;
import static pkg8.reinas.pilas.Algoritmo.resolver;

public class Reinas {

    public static void main(String[] args) {
        imprimir("Algorítmo de las 8 reinas");
        imprimir("Coloque la cantidad de reinas");
        
        boolean seguir = true;
        
        while (seguir) {
            String str = leerCadena();
            if (!str.isEmpty() && esNumero(str)) {
                int queens = Integer.parseInt(str);
                if (numeroDentroDelRango(queens)) {
                    resolver(queens);
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
