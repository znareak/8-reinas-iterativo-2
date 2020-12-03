package pkg8.reinas.pilas;

import static pkg8.reinas.pilas.Helpers.imprimir;

public class Reinas {

    public static void main(String[] args) {
        imprimir("Algorítmo de las 8 reinas");
        imprimir("Coloque la cantidad de reinas");
        Acciones p = new Programa();
        p.comenzar();
        p = null;
    }
}
