package ru.shestakov.start;

import ru.shestakov.inputs.ConsoleInput;
import ru.shestakov.inputs.Input;
import ru.shestakov.models.DivisionManager;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init(DivisionManager eom) {
        while (true) {
            String text = this.input.ask("input number or 'e' to exit:");
            if ("e".equals(text)) { break; }
            System.out.println(eom.check(text));
        }
    }

    public static void main(String[] args) {
        DivisionManager eom = new DivisionManager();
        Input input = new ConsoleInput();
        new StartUI(input).init(eom);
    }
}
