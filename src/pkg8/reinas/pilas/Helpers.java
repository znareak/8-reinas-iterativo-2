package pkg8.reinas.pilas;

import java.util.Scanner;

public class Helpers {

    public static void logLn(Object o) {
        System.out.println(o);
    }

    public static void log(Object o) {
        System.out.print(o);
    }

    public static boolean isNumber(String str) {
        boolean numeric = true;

        try {
            Double num = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            numeric = false;
        }

        return numeric;
    }

    public static boolean isNumberInRange(int n) {
        return n >= 1 && n <= 8;
    }

    public static String readString() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }

}
