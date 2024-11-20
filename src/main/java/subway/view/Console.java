package subway.view;

import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    public static String readline() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
