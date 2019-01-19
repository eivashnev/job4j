package ru.job4j.tracker.actions;

import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class ExitProgram implements UserAction {
    private int key;
    private String info;

    public ExitProgram(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        StartUI.exit = true;
        System.out.println("------------ Good bye! --------------");
    }

    @Override
    public String info() {
        return this.info;
    }
}
