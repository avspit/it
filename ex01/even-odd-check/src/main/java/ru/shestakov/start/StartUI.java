package ru.shestakov.start;

import ru.shestakov.inputs.ConsoleInput;
import ru.shestakov.inputs.Input;
import ru.shestakov.models.EvenOddManager;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init(EvenOddManager eom) {
        while (true) {
            String text = this.input.ask("input number or 'e' to exit:");
            if ("e".equals(text)) { break; }
            System.out.println(eom.check(text) ? "even" : "odd");
        }
    }

    public static void main(String[] args) {
        EvenOddManager eom = new EvenOddManager();
        Input input = new ConsoleInput();
        new StartUI(input).init(eom);
    }
}
