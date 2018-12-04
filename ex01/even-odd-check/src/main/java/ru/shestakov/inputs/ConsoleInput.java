package ru.shestakov.inputs;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        while (true) {
            String nextLine = scanner.nextLine();
            try {
                if(!"e".equals(nextLine)) {
                    Integer.parseInt(nextLine);
                }
                return nextLine;
            } catch (NumberFormatException ie) {
                try {
                    throw new InputException("number have wrong format. please enter validate data again\n");
                } catch (InputException e) {
                    System.out.print(String.format("%s %s", ie.getMessage(), question));
                }
            }
        }
    }
}
