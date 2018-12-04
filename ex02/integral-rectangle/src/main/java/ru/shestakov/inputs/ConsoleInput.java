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
                    String[] params = nextLine.replaceAll(" ","").split(",");
                    if (params.length != 4) {
                        throw new InputException("wrong number of params. should be 4. please enter validate data again\n");
                    }
                    for (int i=0; i<params.length; i++) {
                        Integer.parseInt(params[i]);
                    }
                }
                return nextLine;
            } catch (InputException ie) {
                try {
                    throw new InputException("one or more params have wrong format. please enter validate data again\n");
                } catch (InputException e) {
                    System.out.print(String.format("%s %s", ie.getMessage(), question));
                }
            }
        }
    }
}
