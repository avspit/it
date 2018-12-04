package ru.shestakov.start;

import ru.shestakov.inputs.ConsoleInput;
import ru.shestakov.inputs.Input;
import ru.shestakov.models.SquareManager;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init(SquareManager sm) {
        while (true) {
            String text = this.input.ask("function is: y = x^n, where n is exponent. input function`s exponent, square section and limit (format: <exponent,from,to,limit>) or 'e' to exit:");
            if ("e".equals(text)) { break; }
            System.out.println(sm.integrate(text));
        }
    }

    public static void main(String[] args) {
        SquareManager eom = new SquareManager();
        Input input = new ConsoleInput();
        new StartUI(input).init(eom);
    }
}
