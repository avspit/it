package ru.shestakov.start;

import ru.shestakov.inputs.ConsoleInput;
import ru.shestakov.inputs.Input;
import ru.shestakov.models.ExcelFileManager;
import ru.shestakov.models.RKManager;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init(RKManager sm) {
        while (true) {
            String text = this.input.ask("function is: y' = x + y. input y(0) value (2 by default), step value (0.1 by default), section (from 0 to 1 by default) and limit (20 by default). format: <y0,step,from,to,limit> or 'e' to exit:");
            if ("e".equals(text)) { break; }
            sm.loadParams(text);
            sm.calculate();
            new ExcelFileManager().print(sm);
        }
    }

    public static void main(String[] args) {
        RKManager eom = new RKManager();
        Input input = new ConsoleInput();
        new StartUI(input).init(eom);
    }
}
