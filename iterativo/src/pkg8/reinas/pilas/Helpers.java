package pkg8.reinas.pilas;

import java.util.Scanner;

public class Helpers {

    public static void imprimir(Object o) {
        System.out.println(o);
    }

    public static void imprimirEnLinea(Object o) {
        System.out.print(o);
    }

    public static boolean esNumero(String str) {
        boolean numeric = true;

        try {
            Double num = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            numeric = false;
        }

        return numeric;
    }

    public static boolean numeroDentroDelRango(int n) {
        return n >= 1 && n <= 8;
    }

    public static String leerCadena() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
}
