package org.scoula.lib;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public String read(String title) {
        System.out.print(title + ": ");
        return input.nextLine();
    }

    public String read(String title, String defaultValue) {
        System.out.print(title + "(" + defaultValue + "): ");
        String result = input.nextLine();
        if (result.equals("")) {
            return defaultValue;
        }
        return result;
    }

    public int readInt(String title) {
        System.out.print(title + ": ");
        String result = input.nextLine();
        return Integer.parseInt(result);
    }

    public boolean confirm(String title, boolean defaultValue) {

        System.out.print(title + "(Y/n): ");
        String result = input.nextLine();
        if (result.equals("")) {
            return defaultValue;
        }
        if (result.equals("Y")) {
            return true;
        }
        return false;
    }

    public boolean confirm(String title) {
        return confirm(title, true);
    }
}
