package pkg8.reinas.pilas;

import pkg8.reinas.pilas.Programa;
import static pkg8.reinas.pilas.Helpers.imprimir;

public class Reinas {

    public static void main(String[] args) {
        imprimir("Algorítmo de las 8 reinas");
        imprimir("Coloque la cantidad de reinas");
        Programa p = new Programa();
        p.comenzar();
        p = null;
    }
}
