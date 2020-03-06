package coepoeFishAFish.helpers;

import java.util.Random;
import java.util.Scanner;

public class Utilities {

    public static Scanner scan = new Scanner(System.in);

    public static void pause() {
        System.out.println("Press ENTER to continue...");
        scan.nextLine();
    }

    public static String getString(String prompt) {
        String input;

        System.out.print(prompt);
        input = scan.nextLine();

        return input;
    }

    public static String getString(String prompt, int min, int max) {
        String input;

        do {
            input = getString(prompt);
        } while (input.length() < min || input.length() > max);

        return input;
    }

    public static int getInt(String prompt) {
        int input = 0;
        boolean inputIsWrong = true;

        while (inputIsWrong) {

            try {

                System.out.print(prompt);
                input = scan.nextInt();
                scan.nextLine();
                inputIsWrong = false;

            } catch (Exception e) {

                scan = new Scanner(System.in);
                inputIsWrong = true;
                input = 0;

            }

        }

        return input;
    }

    public static int getInt(String prompt, int min, int max) {
        int input;

        do {
            input = getInt(prompt);
        } while (input < min || input > max);

        return input;
    }

    public static int getRandom(int min, int max) {
        //noinspection OptionalGetWithoutIsPresent
        return new Random().ints(min, max + 1).findAny().getAsInt();
    }

}