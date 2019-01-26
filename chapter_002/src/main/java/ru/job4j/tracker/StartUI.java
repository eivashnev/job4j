package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Tracker Program.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class StartUI {

    Input input;
    Tracker tracker;

    public static boolean exit = false;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        while (!exit) {
            menu.show();
            menu.select(input.ask("Select: ", range));
        }
    }

    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }

}
