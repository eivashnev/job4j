package ru.job4j.tracker.actions;

import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class ExitProgram extends BaseAction {

    public ExitProgram(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        StartUI.exit = true;
        System.out.println("------------ Good bye! --------------");
    }
}
