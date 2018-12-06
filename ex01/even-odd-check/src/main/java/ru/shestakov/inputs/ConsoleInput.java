package ru.shestakov.inputs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final Logger LOG = LoggerFactory.getLogger(ConsoleInput.class);
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
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
                    LOG.error(e.getMessage(), e);
                    System.out.println(question);
                }
            }
        }
    }
}
